package edu.school21.sockets.models;

public class User {
    private Long    Identifier;
    private String  Login;
    private String  Password;

    public User(Long identifier, String name, String password) {
        Identifier = identifier;
        Login = name;
        Password = password;
    }

    public Long getIdentifier() {
        return Identifier;
    }

    public String getName() {
        return Login;
    }

    public String getPassword() {
        return Password;
    }

    public void setIdentifier(Long identifier) {
        Identifier = identifier;
    }

    public void setName(String name) {
        Login = name;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "Identifier=" + Identifier +
                ", Name='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
