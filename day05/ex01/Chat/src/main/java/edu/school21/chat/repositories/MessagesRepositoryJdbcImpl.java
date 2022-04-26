package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.hibernate.HikariConnectionProvider;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;


public class MessagesRepositoryJdbcImpl implements MessagesRepository{
	private HikariDataSource Ds;

	public MessagesRepositoryJdbcImpl(DataSource dataSource){
		Ds = (HikariDataSource) dataSource;
	}

	@Override
	public Optional<Message> findById(Long id) {
		String      GET_QUERY = "SELECT * FROM chat.message WHERE message_id=" + id;
		User        user;
		Message     message;
		Chatroom    chatroom;
		try {
			Connection          connection = Ds.getConnection();
			Statement           statement = connection.createStatement();
			ResultSet           res = statement.executeQuery(GET_QUERY);
			if (!res.next()) {
				System.out.println("id " + id + " not found");
				return Optional.empty();
			}
			user = new User(Integer.parseInt(res.getString("author")),
					"authorrr", "Pass321");
			chatroom = new Chatroom(Integer.parseInt(res.getString("room")),
					null, null);
			message = new Message(id, user, chatroom, res.getString("text"),
					LocalDateTime.of(2022, 4, 20, 4, 20));
			connection.close();
			res.close();
			return Optional.of(message);
		} catch (Exception e) {
			System.out.println(e);
		}
		return Optional.empty();
	}
}
