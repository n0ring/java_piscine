package school21.spring.service.repositories;

import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    private DataSource Ds;

    public UsersRepositoryJdbcImpl(DataSource ds) {
        Ds = ds;
    }

    @Override
    public User findById(Long id) {
        String      GET_QUERY = "SELECT * FROM public.Service WHERE id=" + id;
        try {
            Connection connection = Ds.getConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(GET_QUERY);
            if (!res.next()) {
                System.out.println("id " + id + " not found");
                return null;
            }
            User resultUser =  new User(id, res.getString("email"));
            connection.close();
            res.close();
            return resultUser;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> result = new ArrayList<>();
        try{
            String GET_ALL_QUERY = "SELECT * FROM public.service;";
            Connection          connection = Ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(GET_ALL_QUERY );
            ResultSet resultSet =  statement.executeQuery();
            while (resultSet.next()) {
                result.add(new User(resultSet.getLong("id"),
                        resultSet.getString("email")
                ));
            }
            return result;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    @Override
    public void save(User entity) {
        try{
            String INSERT_QUERY = "INSERT INTO  public.Service (id, email) VALUES ("
                    + entity.getIdentifier() +", '"+ entity.getEmail()
                    +"' );";
            Connection          connection = Ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            statement.execute();
        }
        catch (Exception e) {
            System.out.println(e);
            System.out.println("save impossible");
        }
    }

    @Override
    public void update(User entity) {
        try{
            String DELETE_QUERY = "UPDATE public.Service SET"
                    + " id = " + entity.getIdentifier()
                    + ", email = \'" + entity.getEmail()
                    + "\' "
                    +"  WHERE id=" + entity.getIdentifier();
            Connection          connection = Ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_QUERY );
            statement.execute();
        }
        catch (Exception e) {
            System.out.println(e);
            System.out.println("update impossible");
        }
    }

    @Override
    public void delete(Long id) {
        try{
            String DELETE_QUERY = "c" + id;
            Connection          connection = Ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
            statement.execute();
        }
        catch (Exception e) {
            System.out.println(e);
            System.out.println("delete impossible");
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        String      GET_QUERY = "SELECT * FROM public.Service WHERE email=\'" + email + "\'";

        try {
            Connection connection = Ds.getConnection();
            Statement statement = connection.createStatement();
            ResultSet res = statement.executeQuery(GET_QUERY);
            if (!res.next()) {
                System.out.println("email " + email + " not found");
                return Optional.empty();
            }
            User resultUser =  new User(res.getLong("id"), res.getString("email"));
            connection.close();
            res.close();
            return Optional.of(resultUser);

        } catch (Exception e) {
            System.out.println(e);
        }
        return Optional.empty();
    }
}
