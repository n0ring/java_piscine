package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

public class Chatroom {
    private Long             Id;
    private String              Name;
    private User                Owner;
    private ArrayList<Message>  ChatRoomMessages;

    public Chatroom(Long id, String name, User owner, ArrayList<Message> chatRoomMessages) {
        Id = id;
        Name = name;
        Owner = owner;
        ChatRoomMessages = chatRoomMessages;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public User getOwner() {
        return Owner;
    }

    public ArrayList<Message> getChatRoomMessages() {
        return ChatRoomMessages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chatroom chatroom = (Chatroom) o;
        return Objects.equals(Id, chatroom.Id) && Objects.equals(Name, chatroom.Name) && Objects.equals(Owner, chatroom.Owner) && Objects.equals(ChatRoomMessages, chatroom.ChatRoomMessages);
    }

    @Override
    public String toString() {
        return "Chatroom{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Owner=" + Owner +
                ", ChatRoomMessages=" + ChatRoomMessages +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Name, Owner, ChatRoomMessages);
    }
}
