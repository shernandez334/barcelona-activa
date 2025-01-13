package cat.itacademy.s05.t02.service;

import cat.itacademy.s05.t02.enums.UserRole;
import cat.itacademy.s05.t02.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import cat.itacademy.s05.t02.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<String> registerUser(String username, String password, UserRole userRole) {
        String hashedPassword = passwordEncoder.encode(password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(hashedPassword);
        user.setUserRole(userRole);
        userRepository.save(user);
        return ResponseEntity.ok("User created successfully.");
    }
}