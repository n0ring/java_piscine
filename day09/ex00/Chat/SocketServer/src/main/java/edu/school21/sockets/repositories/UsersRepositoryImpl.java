package edu.school21.sockets.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import edu.school21.sockets.models.User;


import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryImpl implements UsersRepository {
    private DataSource Ds;

    public UsersRepositoryImpl(DataSource ds) {
        Ds = ds;
    }

    @Override
    public User findById(Long id) {
        JdbcTemplate template = new JdbcTemplate(Ds);
        List<User> res =  template.query("SELECT * FROM chat.user WHERE user_id=?",
                new Object[]{id}, ROW_MAPPER);
        if (res.isEmpty())
            return null;
        else
            return res.get(0);
    }

    @Override
    public List<User> findAll() {
        JdbcTemplate template = new JdbcTemplate(Ds);
        return  template.query("SELECT * FROM chat.user", new Object[]{}, ROW_MAPPER);
    }

    @Override
    public void save(User entity) {
        JdbcTemplate template = new JdbcTemplate(Ds);
        template.update("INSERT INTO chat.user  values (?, ?, ?)",
                entity.getIdentifier(), entity.getLogin(), entity.getPassword());
    }

    @Override
    public void update(User entity) {
        JdbcTemplate template = new JdbcTemplate(Ds);
        template.update("UPDATE chat.user SET login=?, password = ? WHERE user_id=?",
                entity.getLogin(), entity.getPassword(), entity.getIdentifier());
    }

    @Override
    public void delete(Long id) {
        JdbcTemplate template = new JdbcTemplate(Ds);
        template.update("DELETE FROM chat.user WHERE user_id=?", id);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        JdbcTemplate template = new JdbcTemplate(Ds);
        List<User> res =  template.query("SELECT * FROM chat.user WHERE login=?",
                new Object[]{login}, ROW_MAPPER);
        if (res.isEmpty())
            return Optional.empty();
        else
            return Optional.of(res.get(0));
    }

    private RowMapper<User> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return new User(resultSet.getLong("user_id"),
                resultSet.getString("login"), resultSet.getString("password"));
    };
}
