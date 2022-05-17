package com.css533.curbthecoins.UserService.repositories;

import com.css533.curbthecoins.UserService.domain.User;
import com.css533.curbthecoins.UserService.exception.CCAuthException;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;


@Repository
public class UserRepository implements IUserRepository{

    private static final String SQL_CREATE = "INSERT INTO CC_USERS(USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD) VALUES(NEXTVAL('CC_USERS_SEQ'), ?,?,?,?)";
    private static final String SQL_COUNT_BY_EMAIL = "SELECT COUNT(*) FROM CC_USERS WHERE EMAIL = ?";
    private static final String SQL_FIND_BY_ID = "SELECT USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, PARTNER, INVITE_CODE FROM CC_USERS WHERE USER_ID = ?";
    private static final String SQL_FIND_BY_EMAIL_AND_PASSWORD = "SELECT USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, PARTNER,INVITE_CODE FROM CC_USERS WHERE EMAIL = ?";
    private static final String SQL_COUNT_BY_INVITE_CODE = "SELECT COUNT(*) FROM CC_USERS WHERE INVITE_CODE = ?";
    private static final String SQL_COUNT_BY_PARTNER = "SELECT COUNT(*) FROM CC_USERS WHERE INVITE_CODE = ? AND PARTNER IS NULL";
    private static final String SQL_FIND_BY_INVITE_CODE = "SELECT USER_ID FROM CC_USERS WHERE INVITE_CODE = ? AND PARTNER IS NULL";
    private static final String SQL_CREATE_WITH_PARTNER = "INSERT INTO CC_USERS(USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD,PARTNER) VALUES(NEXTVAL('CC_USERS_SEQ'), ?,?,?,?,?)";
    private static final String SQL_UPDATE_PARTNER = "UPDATE CC_USERS SET PARTNER = ? WHERE USER_ID = ? ";
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer create(String firstName, String lastName, String email, String password) throws CCAuthException {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection ->{
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, firstName);
                ps.setString(2, lastName);
                ps.setString(3,email);
                ps.setString(4,hashedPassword );
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("USER_ID");
        }catch(Exception e){
            throw new CCAuthException("Invalid detail. Failed to create account" + e.getMessage());
        }
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws CCAuthException {
        try{
            User user = jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL_AND_PASSWORD, userRowMapper, new Object[]{email});
            if(!BCrypt.checkpw(password, user.getPassword())){
                throw new CCAuthException(user.getPassword() + "Invalid username / password 1 ");
            }
            return user;
        }catch( Exception e){
            throw new CCAuthException("Invalid email/password" + e.getMessage());
        }
    }

    @Override
    public Integer getCountByEmail(String email) {
        return jdbcTemplate.queryForObject(SQL_COUNT_BY_EMAIL, Integer.class,new Object[]{email});

    }

    @Override
    public User findById(Integer userId) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, userRowMapper, new Object[]{userId} );

    }

    @Override
    public Integer getCountByInviteCode(String inviteCode) {
        return jdbcTemplate.queryForObject(SQL_COUNT_BY_INVITE_CODE, Integer.class,new Object[]{inviteCode});
    }

    @Override
    public Integer getCountByPartner(String inviteCode) {
        return jdbcTemplate.queryForObject(SQL_COUNT_BY_PARTNER, Integer.class,new Object[]{inviteCode});
    }

    @Override
    public Integer createWithPartner(String firstName, String lastName, String email, String password, Integer partner) throws CCAuthException {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(10));
        try{
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection ->{
                PreparedStatement ps = connection.prepareStatement(SQL_CREATE_WITH_PARTNER, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, firstName);
                ps.setString(2, lastName);
                ps.setString(3,email);
                ps.setString(4,hashedPassword );
                ps.setInt(5,partner);
                return ps;
            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("USER_ID");
        }catch(Exception e){
            throw new CCAuthException("Invalid detail. Failed to create account" + e.getMessage());
        }
    }

    @Override
    public void updatePartner(Integer userId, Integer partner) throws CCAuthException  {
        try{
            jdbcTemplate.update(SQL_UPDATE_PARTNER, new Object[]{partner , userId});
        }catch(Exception e){
            throw new CCAuthException("Invalid request" + e.getMessage() + "*****************************");
        }
    }

    @Override
    public Integer getPartner(String inviteCode) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_INVITE_CODE, Integer.class,new Object[]{inviteCode});
    }


    private RowMapper<User> userRowMapper = (rs, rowNum) -> {
        User user = new User(rs.getInt("USER_ID"),
                rs.getString("FIRST_NAME"),
                rs.getString("LAST_NAME"),
                rs.getString("EMAIL"),
                rs.getString("PASSWORD"),
                rs.getInt("PARTNER"),
                rs.getString("INVITE_CODE"));
                return user;
    };

}
