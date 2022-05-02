package edu.school21.sockets.models;

import java.util.Objects;

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

    public String getLogin() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(Identifier, user.Identifier) && Objects.equals(Login, user.Login) && Objects.equals(Password, user.Password);
    }
    @Override
    public int hashCode() {
        return Objects.hash(Identifier, Login, Password);
    }
}
