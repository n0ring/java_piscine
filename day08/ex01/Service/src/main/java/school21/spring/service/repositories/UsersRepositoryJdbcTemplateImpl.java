package school21.spring.service.repositories;

import school21.spring.service.models.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {
    private DriverManagerDataSource Ds;

    public UsersRepositoryJdbcTemplateImpl(DriverManagerDataSource ds) {
        Ds = ds;
    }

    @Override
    public User findById(Long id) {
        JdbcTemplate template = new JdbcTemplate(Ds);
        List<User> res =  template.query("SELECT * FROM public.Service WHERE id=?", new Object[]{id}, ROW_MAPPER);
        if (res.isEmpty())
            return null;
        else
            return res.get(0);
    }

    @Override
    public List<User> findAll() {
        JdbcTemplate template = new JdbcTemplate(Ds);
        return  template.query("SELECT * FROM public.Service", new Object[]{}, ROW_MAPPER);
    }

    @Override
    public void save(User entity) {
        JdbcTemplate template = new JdbcTemplate(Ds);
        template.update("INSERT INTO public.Service  values (?, ?)", entity.getIdentifier(), entity.getEmail());
    }

    @Override
    public void update(User entity) {
        JdbcTemplate template = new JdbcTemplate(Ds);
        template.update("UPDATE public.Service SET email=? WHERE id=?",
                entity.getEmail(), entity.getIdentifier());

    }

    @Override
    public void delete(Long id) {
        JdbcTemplate template = new JdbcTemplate(Ds);
        template.update("DELETE FROM public.Service WHERE id=?", id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        JdbcTemplate template = new JdbcTemplate(Ds);
        List<User> res =  template.query("SELECT * FROM public.Service WHERE email=?", new Object[]{email}, ROW_MAPPER);
        if (res.isEmpty())
            return Optional.empty();
        else
            return Optional.of(res.get(0));
    }

    private RowMapper<User> ROW_MAPPER = (ResultSet resultSet, int rowNum) -> {
        return new User(resultSet.getLong("id"), resultSet.getString("email"));
    };
}
