package cat.itacademy.s05.t02.controller;

import cat.itacademy.s05.t02.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cat.itacademy.s05.t02.service.UserService;

@RestController
@RequestMapping("/tamagochi")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/newuser")
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest){
        return userService.registerUser(userRequest.getUsername(), userRequest.getPassword(), userRequest.getUserRole());
    }
}
