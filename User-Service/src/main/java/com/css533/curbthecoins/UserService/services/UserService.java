package com.css533.curbthecoins.UserService.services;

import com.css533.curbthecoins.UserService.domain.User;
import com.css533.curbthecoins.UserService.exception.CCAuthException;
import com.css533.curbthecoins.UserService.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.regex.Pattern;


@Service
@Transactional
public class UserService implements IUserService{

    @Autowired
    IUserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws CCAuthException {
        if(email != null) email = email.toLowerCase();
        email.trim();
        return userRepository.findByEmailAndPassword(email,password);
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password, String inviteCode) throws CCAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(email != null ) email = email.toLowerCase();
        if(!pattern.matcher(email).matches())
            throw new CCAuthException("Invalid email format");
        Integer count = userRepository.getCountByEmail(email);
        if(count > 0){
            throw new CCAuthException("Email Already in use");
        }
        System.out.println(inviteCode + " invite code *************************");
        if(inviteCode == ""){
            Integer userId = userRepository.create(firstName.trim(), lastName.trim(), email.trim(), password);
            return userRepository.findById(userId);
        }
        Integer inviteCount = userRepository.getCountByInviteCode(inviteCode);
        if(inviteCount != 1){
            throw new CCAuthException("Invalid invite code");
        }
        Integer partnerCount = userRepository.getCountByPartner(inviteCode);
        if(partnerCount != 1){
            throw new CCAuthException("Code is already in use - partnerCount is " + partnerCount);
        }

        Integer partner = userRepository.getPartner(inviteCode);

        Integer userId = userRepository.createWithPartner(firstName.trim(), lastName.trim(), email.trim(), password,partner );
        userRepository.updatePartner(partner, userId);
        return userRepository.findById(userId);
    }
}
