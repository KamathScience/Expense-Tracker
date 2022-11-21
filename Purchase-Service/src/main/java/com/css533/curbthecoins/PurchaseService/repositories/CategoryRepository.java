package com.css533.curbthecoins.PurchaseService.repositories;

import com.css533.curbthecoins.PurchaseService.domain.Category;
import com.css533.curbthecoins.PurchaseService.exceptions.CCBadRequestException;
import com.css533.curbthecoins.PurchaseService.exceptions.CCResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;


@Repository
public class CategoryRepository implements  ICategoryRepository{

    private static final String SQL_FIND_ALL = "SELECT C.CATEGORY_ID, C.USER_ID, C.TITLE, C.DESCRIPTION, " +
            "COALESCE(SUM(T.AMOUNT), 0) TOTAL_EXPENSE " +
            "FROM CC_TRANSACTIONS T RIGHT OUTER JOIN CC_CATEGORIES C ON C.CATEGORY_ID = T.CATEGORY_ID "+
            "WHERE C.USER_ID IN (?, ?) GROUP BY C.CATEGORY_ID";
    private static final String SQL_FIND_BY_ID = "SELECT C.CATEGORY_ID, C.USER_ID, C.TITLE, C.DESCRIPTION, " +
            "COALESCE(SUM(T.AMOUNT), 0) TOTAL_EXPENSE " +
            "FROM CC_TRANSACTIONS T RIGHT OUTER JOIN CC_CATEGORIES C ON C.CATEGORY_ID = T.CATEGORY_ID "+
            "WHERE C.USER_ID IN (?, ?) AND C.CATEGORY_ID = ? GROUP BY C.CATEGORY_ID";
    private static final String SQL_CREATE = "INSERT INTO CC_CATEGORIES (CATEGORY_ID, USER_ID, TITLE, DESCRIPTION) VALUES( NEXTVAL('CC_CATEGORIES_SEQ'), ?,?,? )";
    private static final String SQL_UPDATE = "UPDATE CC_CATEGORIES SET TITLE = ?, DESCRIPTION = ? WHERE USER_ID IN (?, ?) AND CATEGORY_ID = ?";
    private static final String SQL_DELETE_CATEGORY = "DELETE FROM CC_CATEGORIES WHERE USER_ID IN (?, ?) AND CATEGORY_ID = ?";
    private static final String SQL_DELETE_ALL_TRANSACTIONS = "DELETE FROM CC_TRANSACTIONS WHERE CATEGORY_ID = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> findAll(Integer userId,  Integer partnerId) throws CCResourceNotFoundException {
        System.out.println("3. Inside category repository. Finding all category of the user");
        if(partnerId == null){
            partnerId = 0;
        }
        return jdbcTemplate.query(SQL_FIND_ALL, categoryRowMapper, new Object[]{userId , partnerId});
    }

    @Override
    public Category findById(Integer userId, Integer partnerId, Integer categoryId) throws CCResourceNotFoundException {
        System.out.println("3. Inside category repository. Finding particular category of the user");
        try{
            if(partnerId == null){
                partnerId = 0;
            }
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, categoryRowMapper, new Object[]{userId,partnerId, categoryId});
        }catch(Exception e){
            throw new CCResourceNotFoundException("Category not found");
        }
    }

    @Override
    public Integer create(Integer userId, Integer partnerId, String title, String description) throws CCBadRequestException {
        System.out.println("3. Inside category repository. Creating new category for the user");
        try{
           KeyHolder keyHolder = new GeneratedKeyHolder();
           jdbcTemplate.update(connection ->{
               PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
               ps.setInt(1,userId);
               ps.setString(2, title);
               ps.setString(3,description);
               return ps;
           } , keyHolder);
            return (Integer) keyHolder.getKeys().get("CATEGORY_ID");
       }catch( Exception e){
           throw new CCBadRequestException("Invalid request while creating a new category" );
       }
    }

    @Override
    public void update(Integer userId, Integer partnerId, Integer categoryId, Category category) throws CCBadRequestException {
        System.out.println("3. Inside category repository. Updating particular category of the user");
        try{
            jdbcTemplate.update(SQL_UPDATE , new Object[]{category.getTitle(), category.getDescription(), userId,partnerId, categoryId});
        }catch(Exception e){
            throw new CCBadRequestException("Invalid request");
        }
    }

    @Override
    public void removeById(Integer userId, Integer partnerId, Integer categoryId) {
        System.out.println("3. Inside category repository. Deleteing particular category of the user");
        this.removeAllCategoryTransactions(categoryId);
        if(partnerId == null){
            partnerId = 0;
        }
        jdbcTemplate.update(SQL_DELETE_CATEGORY, new Object[]{userId,partnerId, categoryId});
    }

    private void removeAllCategoryTransactions(Integer categoryId){
        System.out.println("3. Inside category repository. Deleting all transaction of a category of the user");
        jdbcTemplate.update(SQL_DELETE_ALL_TRANSACTIONS, new Object[]{categoryId});
    }

    private RowMapper<Category> categoryRowMapper = ((rs, rowNum) ->{
       return new Category(rs.getInt("CATEGORY_ID"),
               rs.getInt("USER_ID"),
                rs.getString("TITLE"),
                rs.getString("DESCRIPTION"),
                rs.getDouble("TOTAL_EXPENSE"));
    });



}
