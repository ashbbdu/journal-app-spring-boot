package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.UserEntity;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<UserEntity> getAllUsers () {
        return userRepository.findAll();
    }

    public UserEntity addUser (UserEntity user) {
        return userRepository.save(user);
    }

}
