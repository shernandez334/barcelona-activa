package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

@RestController
public class UserController {
    private UserService userService;

    public ResponseEntity<String> createUser(@RequestBody String username, @RequestBody String password){
        return userService.registerUser(username, password);
    }
}
