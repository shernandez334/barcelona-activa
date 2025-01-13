package cat.itacademy.s05.t02.dto;

import cat.itacademy.s05.t02.enums.UserRole;

public class UserRequest {
    private String username;
    private String password;
    private UserRole userRole;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
