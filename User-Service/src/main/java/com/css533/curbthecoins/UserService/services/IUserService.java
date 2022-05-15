package com.css533.curbthecoins.UserService.services;

import com.css533.curbthecoins.UserService.domain.User;
import com.css533.curbthecoins.UserService.exception.CCAuthException;

public interface IUserService {

    User validateUser(String email, String password) throws CCAuthException;

    User registerUser(String firstName, String lastName, String email, String password, String inviteCode) throws CCAuthException;

}
