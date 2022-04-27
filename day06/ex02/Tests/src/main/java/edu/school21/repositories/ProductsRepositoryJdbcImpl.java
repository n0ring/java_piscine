package edu.school21.repositories;

import edu.school21.models.Product;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJdbcImpl implements ProductsRepository{
	private EmbeddedDatabase Db;

	public ProductsRepositoryJdbcImpl(EmbeddedDatabase db) {
		Db = db;
	}

	@Override
	public Optional<Product> findById(Long id) {
		String      GET_QUERY = "SELECT * FROM products WHERE identifier=" + id;
		try {
			Connection connection = Db.getConnection();
			Statement  statement = connection.createStatement();
			ResultSet  res = statement.executeQuery(GET_QUERY);
			Product     returnObj;
			if (!res.next()) {
				System.out.println("id " + id + " not found");
				return Optional.empty();
			}

			returnObj = new Product(id, res.getString("name"),
					res.getInt("price"));
			return Optional.of(returnObj);
		}
		catch (Exception e) {
			return Optional.empty();
		}
	}

	@Override
	public void save(Product product) {
		try{
			String INSERT_QUERY = "INSERT INTO products (identifier, name, price) VALUES ("
					+ product.getId() +", '"+ product.getName()
					+"', "+ product.getPrice() +");";
			Connection          connection = Db.getConnection();
			PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
			statement.execute();
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println("save impossible");
		}
	}

	@Override
	public void delete(Long id) {
		try{
			String DELETE_QUERY = "DELETE FROM products WHERE identifier=" + id;
			Connection          connection = Db.getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
			statement.execute();
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println("delete impossible");
		}
	}


	@Override
	public void update(Product product) {
		try{
			String DELETE_QUERY = "UPDATE products SET"
					+ " identifier = " + product.getId()
					+ ", name = \'" + product.getName()
					+ "\', price = " + product.getPrice()
					+"  WHERE identifier=" + product.getId();
			Connection          connection = Db.getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_QUERY );
			statement.execute();
		}
		catch (Exception e) {
			System.out.println(e);
			System.out.println("update impossible");
		}
	}

	@Override
	public List<Product> findAll() {
		List<Product> result = new ArrayList<>();
		try{
			String GET_ALL_QUERY = "SELECT * FROM products;";
			Connection          connection = Db.getConnection();
			PreparedStatement statement = connection.prepareStatement(GET_ALL_QUERY );
			ResultSet resultSet =  statement.executeQuery();
			while (resultSet.next()) {
				result.add(new Product(resultSet.getLong("identifier"),
						resultSet.getString("name"),
						resultSet.getInt("price")
						));
			}
			return result;
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}

