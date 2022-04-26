package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;


public class Program {
	public static <Room> void main(String[] args) {
		Scanner             sc = new Scanner(System.in);
		Long                id;
		Optional<Message>   result;
		HikariConfig        config;
		config = new HikariConfig();
		config.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
		config.setUsername("alex");
		config.setPassword("pass1234");

		HikariDataSource ds = new HikariDataSource(config);
		MessagesRepositoryJdbcImpl repo = new MessagesRepositoryJdbcImpl(ds);
		User creator = new User(2L, "user", "user", new ArrayList(), new ArrayList());
		User author = creator;
		Chatroom room = new Chatroom(1L, "room", creator, new ArrayList());
		Message message = new Message(null, author, room, "Hello!", LocalDateTime.now());
		repo.save(message);
		System.out.println(message.getId());
		ds.close();
	}
}
