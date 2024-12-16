package service;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import repository.UserRepository;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void registerUser(String userName, String password){
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        userRepository.save(user);
    }
}
