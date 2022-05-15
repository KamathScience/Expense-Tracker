package com.css533.curbthecoins.UserService.repositories;

import com.css533.curbthecoins.UserService.domain.User;
import com.css533.curbthecoins.UserService.exception.CCAuthException;

public interface IUserRepository {

    Integer create(String firstName, String lastName, String email, String password) throws CCAuthException;

    User findByEmailAndPassword(String email, String password) throws CCAuthException;

    Integer getCountByEmail(String email);

    User findById(Integer userId);

    Integer getCountByInviteCode(String inviteCode);

    Integer getCountByPartner(String inviteCode);

    Integer createWithPartner(String firstName, String lastName, String email, String password, Integer partner) throws CCAuthException;

    void updatePartner(Integer userId, Integer partner) throws CCAuthException ;

    Integer getPartner(String inviteCode);
}
