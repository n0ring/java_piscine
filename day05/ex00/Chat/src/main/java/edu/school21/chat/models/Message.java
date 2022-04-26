package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
	private Long        Id;
	private User        Author;
	private Chatroom    Room;
	private String      Text;
	private LocalDateTime Time;

	public Message(Long id, User author, Chatroom room, String text, LocalDateTime time) {
		Id = id;
		Author = author;
		Room = room;
		Text = text;
		Time = time;
	}

	public  Long getId() {
		return Id;
	}

	public User getAuthor() {
		return Author;
	}

	public Chatroom getRoom() {
		return Room;
	}

	public String getText() {
		return Text;
	}

	public LocalDateTime getTime() {
		return Time;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Message message = (Message) o;
		return Objects.equals(Id, message.Id) && Objects.equals(Author, message.Author) && Objects.equals(Room, message.Room) && Objects.equals(Text, message.Text) && Objects.equals(Time, message.Time);
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, Author, Room, Text);
	}

	@Override
	public String toString() {
		return "Message{" +
				"Id=" + Id +
				", Author=" + Author +
				", Room=" + Room +
				", Text='" + Text + '\'' +
				", Time=" + Time +
				'}';
	}
}
