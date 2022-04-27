package edu.school21.models;

import java.util.Objects;

public class Product {
	Long Id;
	String Name;
	Integer Price;

	public Product(Long id, String name, Integer price) {
		Id = id;
		Name = name;
		Price = price;
	}

	public Long getId() {
		return Id;
	}

	public Integer getPrice() {
		return Price;
	}

	public String getName() {
		return Name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return Objects.equals(Id, product.Id)
				&& Objects.equals(Name, product.Name)
				&& Objects.equals(Price, product.Price);
	}
}
