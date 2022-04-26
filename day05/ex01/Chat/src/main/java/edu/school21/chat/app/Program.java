package edu.school21.chat.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.util.Optional;
import java.util.Scanner;


public class Program {
	public static void main(String[] args) {
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

		System.out.println("Enter a message ID");
		if (sc.hasNextLong()) {
			id = sc.nextLong();
			result = repo.findById(id);
			if (result.isPresent()) {
				System.out.println(result.get());
			}
		}
		else {
			System.out.println("Need a number");
		}
		ds.close();
	}
}
