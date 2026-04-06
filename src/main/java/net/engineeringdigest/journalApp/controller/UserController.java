package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntity;
import net.engineeringdigest.journalApp.entity.UserEntity;
import net.engineeringdigest.journalApp.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public ResponseEntity<?> getAllUsers () {
        List<UserEntity> data = userService.getAllUsers();
        return new ResponseEntity<>(data , HttpStatus.OK);
    }

    @PostMapping("/create")
    public void addUser (@RequestBody UserEntity user) {
        userService.addUser(user);
    }
}
