package edu.school21.chat.models;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private Long                Id;
    private String              Login;
    private String              Password;
    private ArrayList<Chatroom> CreatedChatRooms;
    private ArrayList<Chatroom> VisitedChatRooms;

    public User(Long id, String login, String password, ArrayList<Chatroom> createdChatRooms,
                ArrayList<Chatroom> visitedChatRooms) {
        Id = id;
        Login = login;
        Password = password;
        CreatedChatRooms = createdChatRooms;
        VisitedChatRooms = visitedChatRooms;
    }

    public Long getId() {
        return Id;
    }

    public String getLogin() {
        return Login;
    }

    public  String getPassword() {
        return Password;
    }

    public ArrayList<Chatroom> getCreatedChatRooms() {
        return CreatedChatRooms;
    }

    public  ArrayList<Chatroom> getVisitedChatRooms() {
        return VisitedChatRooms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(Id, user.Id) && Objects.equals(Login, user.Login)
                && Objects.equals(Password, user.Password)
                && Objects.equals(CreatedChatRooms, user.CreatedChatRooms)
                && Objects.equals(VisitedChatRooms, user.VisitedChatRooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Login, Password, CreatedChatRooms, VisitedChatRooms);
    }


    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", Login='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                ", createdChatRooms=" + CreatedChatRooms +
                ", visitedChatRooms=" + VisitedChatRooms +
                '}';
    }

}