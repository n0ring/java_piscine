package edu.school21.sockets;

//
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductsReposutoryJdbcImplTest {
//	final Product EXPECTED_FIND_BY_ID_PRODUCT = new Product(2L, "product1", 100);
//	final Product NEW_PRODUCT_TO_SAVE = new Product(42L, "product1", 100);
//	final Product OLD_PRODUCT_TO_SAVE = new Product(42L, "notSavev", 42);
//	final Product PRODUCT_TO_DELETE = new Product(42L, "toDel", 42);
//	final Product EXPECTED_UPDATED_PRODUCT = new Product(42L, "after updated", 42);
//	final Product TO_UPDATED_PRODUCT = new Product(42L, "before updated", 21);
//	final List<Product> EXPECTED_FIND_ALL_PRODUCTS = new ArrayList<>();


	@
	void init() {
	}

//	@Test
//	void findByExistIdTest() {
//		Optional<Product> res = ProductRep.findById(2L);
//		Assertions.assertTrue(res.isPresent());
//		Assertions.assertTrue(EXPECTED_FIND_BY_ID_PRODUCT.equals(res.get()));
//	}

//	@Test
//	void findByNotExistIdTest() {
//		Optional<Product> res = ProductRep.findById(2222L);
//		Assertions.assertFalse(res.isPresent());
//	}
//
//	@Test
//	void saveTestWithNewId() {
//		ProductRep.save(NEW_PRODUCT_TO_SAVE);
//		Optional<Product> res = ProductRep.findById(NEW_PRODUCT_TO_SAVE.getId());
//		Assertions.assertTrue(res.isPresent());
//		Assertions.assertEquals(NEW_PRODUCT_TO_SAVE, res.get());
//	}
//
//	@Test
//	void saveTestWithExistId() {
//		ProductRep.save(NEW_PRODUCT_TO_SAVE);
//		ProductRep.save(OLD_PRODUCT_TO_SAVE);
//		Optional<Product> res = ProductRep.findById(OLD_PRODUCT_TO_SAVE.getId());
//		Assertions.assertTrue(res.isPresent());
//		Assertions.assertNotEquals(OLD_PRODUCT_TO_SAVE, res.get());
//	}
//
//	@Test
//	void deleteTestExistId() {
//		ProductRep.save(PRODUCT_TO_DELETE);
//		Optional<Product> res = ProductRep.findById(PRODUCT_TO_DELETE.getId());
//		Assertions.assertTrue(res.isPresent());
//		ProductRep.delete(PRODUCT_TO_DELETE.getId());
//		res = ProductRep.findById(PRODUCT_TO_DELETE.getId());
//		Assertions.assertFalse(res.isPresent());
//	}
//
//	@Test
//	void deleteTestNotExistId() {
//		ProductRep.save(PRODUCT_TO_DELETE);
//		Optional<Product> res = ProductRep.findById(PRODUCT_TO_DELETE.getId());
//		Assertions.assertTrue(res.isPresent());
//		ProductRep.delete(4444L);
//		res = ProductRep.findById(PRODUCT_TO_DELETE.getId());
//		Assertions.assertTrue(res.isPresent());
//	}
//
//	@Test
//	void updateExistEl() {
//		ProductRep.save(TO_UPDATED_PRODUCT);
//		ProductRep.update(EXPECTED_UPDATED_PRODUCT);
//		Optional<Product> res = ProductRep.findById(EXPECTED_UPDATED_PRODUCT.getId());
//		Assertions.assertTrue(res.isPresent());
//		Assertions.assertTrue(EXPECTED_UPDATED_PRODUCT.equals(res.get()));
//	}
//
//	@Test
//	void findAllTest() {
//		EXPECTED_FIND_ALL_PRODUCTS.add(new Product(1L, "product1", 100));
//		EXPECTED_FIND_ALL_PRODUCTS.add(new Product(2L, "product1", 100));
//		EXPECTED_FIND_ALL_PRODUCTS.add(new Product(3L, "product1", 100));
//		EXPECTED_FIND_ALL_PRODUCTS.add(new Product(4L, "product1", 100));
//		EXPECTED_FIND_ALL_PRODUCTS.add(new Product(5L, "product1", 100));
//		EXPECTED_FIND_ALL_PRODUCTS.add(new Product(6L, "product1", 100));
//		List<Product> result = ProductRep.findAll();
//		Assertions.assertEquals(EXPECTED_FIND_ALL_PRODUCTS, result);
//	}
//
//	@Test
//	void findAllTestNotWrite() {
//		EXPECTED_FIND_ALL_PRODUCTS.add(new Product(1L, "product1", 100));
//		EXPECTED_FIND_ALL_PRODUCTS.add(new Product(2L, "product1", 100));
//		EXPECTED_FIND_ALL_PRODUCTS.add(new Product(3L, "product1", 100));
//		EXPECTED_FIND_ALL_PRODUCTS.add(new Product(4L, "product1", 100));
//		EXPECTED_FIND_ALL_PRODUCTS.add(new Product(5L, "product1", 100));
//		EXPECTED_FIND_ALL_PRODUCTS.add(new Product(6L, "product1", 100));
//		EXPECTED_FIND_ALL_PRODUCTS.add(new Product(66L, "product1", 100));
//		List<Product> result = ProductRep.findAll();
//		Assertions.assertNotEquals(EXPECTED_FIND_ALL_PRODUCTS, result);
//	}
}
