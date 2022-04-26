package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.hibernate.HikariConnectionProvider;
import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;
import java.sql.Timestamp;
import java.util.Date;


public class MessagesRepositoryJdbcImpl implements MessagesRepository{
	private HikariDataSource Ds;

	public MessagesRepositoryJdbcImpl(DataSource dataSource){
		Ds = (HikariDataSource) dataSource;
	}

	@Override
	public Optional<Message> findById(Long id) {
		String      GET_QUERY = "SELECT * FROM chat.message WHERE message_id=" + id;
		try {
			Connection          connection = Ds.getConnection();
			Statement           statement = connection.createStatement();
			ResultSet           res = statement.executeQuery(GET_QUERY);
			if (!res.next()) {
				System.out.println("id " + id + " not found");
				return Optional.empty();
			}
			User user = new User(Long.parseLong(res.getString("author")),
					"authorrr", "Pass321", null, null);
			Chatroom chatroom = new Chatroom(Long.parseLong(res.getString("room")),
					null, null, null);
			Message message = new Message(id, user, chatroom, res.getString("text"),
					LocalDateTime.of(2022, 4, 20, 4, 20));
			connection.close();
			res.close();
			return Optional.of(message);
		} catch (Exception e) {
			System.out.println(e);
		}
		return Optional.empty();
	}

	private String setQuery(Long authorId, Long roomId, String text) {
		Date date = new Date();
		Timestamp ts=new Timestamp(date.getTime());
		String INSERT_QUERY = "INSERT INTO chat.Message (message_id, author, room, text, time) "
				+ " VALUES (DEFAULT, "+ authorId +", "+ roomId +", \'" + text + "\', \'" + ts.toString() + "\');";
		System.out.println(INSERT_QUERY);
		return (INSERT_QUERY);
	}

	public void save(Message message) {
		try{
			validateMessageData(message);
			String q = setQuery(message.getAuthor().getId(), message.getRoom().getId(), message.getText());
			Connection          connection = Ds.getConnection();
			PreparedStatement   statement = connection.prepareStatement(q, Statement.RETURN_GENERATED_KEYS );
			statement.execute();
			ResultSet resultSet = statement.getGeneratedKeys();
			resultSet.next();
			message.setId(resultSet.getLong("message_id"));
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println("save impossible");
		}
	}

	private void validateMessageData(Message message) throws NotSavedSubEntityException {
		if (message.getAuthor() == null) {
			throw new NotSavedSubEntityException("author arg is null");
		}
		if (message.getRoom() == null) {
			throw new NotSavedSubEntityException("room is null");
		}
		Long authorId = message.getAuthor().getId();
		Long roomId = message.getRoom().getId();
		if (!isIdExist("user", authorId)) {
			throw new NotSavedSubEntityException("user with id " + authorId + " is not exist in database" );
		}
		if (!isIdExist("chatroom", roomId)) {
			throw new NotSavedSubEntityException("chatroom with id " + roomId + " is not exist in database" );
		}
	}


	private boolean isIdExist(String table, Long id) {
		String      GET_QUERY = "SELECT * FROM chat." + table + " WHERE " + table + "_id=" + id;
		Connection  connection;
		Statement   statement;
		ResultSet   resultSet;
		try {
			connection = Ds.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(GET_QUERY);
			return resultSet.next();
		}
		catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
}
