package com.css533.curbthecoins.BudgetService.repositories;

import com.css533.curbthecoins.BudgetService.domain.Budget;
import com.css533.curbthecoins.BudgetService.exception.CCBadRequestException;
import com.css533.curbthecoins.BudgetService.exception.CCBudgetNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;


@Repository
public class BudgetRepository implements IBudgetRepository{


    private static final String SQL_FIND_BY_ID = "SELECT BUDGET_ID, USER_ID, PARTNER_ID, BUDGET, TITLE, DESCRIPTION FROM CC_BUDGET WHERE USER_ID IN (? , ?)";
    private static final String SQL_CREATE = "INSERT INTO CC_BUDGET (BUDGET_ID, USER_ID, PARTNER_ID, BUDGET, TITLE, DESCRIPTION) VALUES ( NEXTVAL('CC_BUDGET_SEQ'),?,?,?,?,? )";
    private static final String SQL_UPDATE = "UPDATE CC_BUDGET SET BUDGET = ?, TITLE = ?, DESCRIPTION = ? WHERE USER_ID IN (? , ? )";
    private static final String SQL_UPDATE_PARTNER = "UPDATE CC_BUDGET SET PARTNER_ID = ? WHERE USER_ID = ?";
    private static final String SQL_DELETE_CATEGORY = "DELETE FROM CC_BUDGET WHERE USER_ID IN (?, ?)";

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Budget findById(Integer userId, Integer partnerId) throws CCBudgetNotFoundException {
        try{
            if(partnerId == null){
                partnerId = 0;
            }
            System.out.println("Inside findby id  userId " + userId);
            return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, budgetRowMapper, new Object[]{userId,partnerId});
        }catch(Exception e){
            throw new CCBudgetNotFoundException("Budget not found" + e.getMessage());
        }
    }

    @Override
    public Integer create(Integer userId, Integer partnerId, Double budget, String title, String description) throws CCBadRequestException {
        try{
            System.out.println("Inside create budget repository userID " + userId+" partnerID " + partnerId );
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection ->{
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setInt (1, userId);
                ps.setInt(2, partnerId);
                ps.setDouble(3,budget);
                ps.setString(4, title);
                ps.setString(5,description);
                return ps;
            } , keyHolder);

            System.out.println(keyHolder.getKeys().get("BUDGET_ID"));
            return (Integer) keyHolder.getKeys().get("BUDGET_ID");
        }catch( Exception e){
            throw new CCBadRequestException("Invalid request while creating a new budget" + e.getMessage());
        }
    }

    @Override
    public void update(Integer userId, Integer partnerId, Double budget, String title, String description) throws CCBadRequestException {
        try{
            jdbcTemplate.update(SQL_UPDATE , new Object[]{budget, title, description, userId, partnerId});
        }catch(Exception e){
            throw new CCBadRequestException("Invalid request" + e.getMessage());
        }
    }

    @Override
    public void updatePartner(Integer userId, Integer partnerId) throws CCBadRequestException {
        try{
            jdbcTemplate.update(SQL_UPDATE_PARTNER , new Object[]{userId, partnerId});
        }catch(Exception e){
            throw new CCBadRequestException("Invalid request" + e.getMessage());
        }
    }

    @Override
    public void removeById(Integer userId, Integer partnerId) {
        if(partnerId == null){
            partnerId = 0;
        }
        jdbcTemplate.update(SQL_DELETE_CATEGORY, new Object[]{userId,partnerId});
    }

    private RowMapper<Budget> budgetRowMapper = ((rs, rowNum) ->{
        return new Budget(rs.getInt("BUDGET_ID"),
                rs.getInt("USER_ID"),
                rs.getInt("PARTNER_ID"),
                rs.getDouble("BUDGET"),
                rs.getString("TITLE"),
                rs.getString("DESCRIPTION"));
    });
}
