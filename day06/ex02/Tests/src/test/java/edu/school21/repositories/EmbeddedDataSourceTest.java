package edu.school21.repositories;

import org.junit.jupiter.api.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.SQLException;


public class EmbeddedDataSourceTest {
	private EmbeddedDatabase db;

	@BeforeEach
	void init() {
		db = (new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.HSQL)
				.addScript("schema.sql")
				.addScript("data.sql"))
				.build();
	}

	@AfterEach
	public void shutdownTable() {
		db.shutdown();
	}

	@Test
	public void checkGetConnection() throws SQLException {
		Assertions.assertNotNull(db);
		Assertions.assertNotNull(db.getConnection());
	}

}
