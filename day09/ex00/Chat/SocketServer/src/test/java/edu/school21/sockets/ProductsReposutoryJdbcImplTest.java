package edu.school21.sockets;


import edu.school21.sockets.models.User;
import edu.school21.sockets.repositories.UsersRepositoryImpl;
//import org.junit.Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Optional;

public class ProductsReposutoryJdbcImplTest {
	User USER_FOR_SAVE = new User(21L, "newUser", "newPass");
	User USER_FOR_UPDATE = new User(USER_FOR_SAVE.getIdentifier(), "Updated login", "updated pass");
	User USER_TO_DELETE = new User(69L, "NAME TO DEL", "PASS TO DEL");
	User USER_FOR_FIND_BY_LOGIN = new User(422L, "namina21", "PASDDDS");
	UsersRepositoryImpl repo;

	@BeforeEach
	void init() {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("context.xml");
		repo = context.getBean("UsersRepo", UsersRepositoryImpl.class);
	}


	@Test
	void findByExistIdTest() {
		Assertions.assertEquals(new User(1L, "namina", "pass1234"),
				repo.findById(1L));
	}

//	@Test
//	void findByNotExistIdTest() {
//		Assertions.assertNull(repo.findById(42213L));
//	}
//
//		@Test
//	void findAllTest() {
//		Assertions.assertTrue(repo.findAll().size() > 1);
//	}

//	@Test
//	void saveTestWithNewId() {
//		repo.save(USER_FOR_SAVE);
//		User res = repo.findById(USER_FOR_SAVE.getIdentifier());
//		Assertions.assertEquals(res, USER_FOR_SAVE);
//	}

//	@Test
//	void updateTest() {
//		repo.update(USER_FOR_UPDATE);
//		Assertions.assertEquals(USER_FOR_UPDATE, repo.findById(USER_FOR_UPDATE.getIdentifier()));
//
//	}
//
//	@Test
//	void deleteTestExistId() {
//		repo.save(USER_TO_DELETE);
//		User res = repo.findById(USER_TO_DELETE.getIdentifier());
//		Assertions.assertTrue(res != null);
//		repo.delete(USER_TO_DELETE.getIdentifier());
//		res = repo.findById(USER_TO_DELETE.getIdentifier());
//		Assertions.assertTrue(res == null);
//	}
//
//	@Test
//	void findByLoginTest() {
//		Optional<User> res =  repo.findByLogin(USER_FOR_FIND_BY_LOGIN.getLogin());
//		if (res.isPresent()) {
//			Assertions.assertEquals(res.get(), USER_FOR_FIND_BY_LOGIN);
//		}
//	}
}
