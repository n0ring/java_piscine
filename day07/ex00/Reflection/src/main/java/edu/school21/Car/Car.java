package edu.school21.Car;

public class Car {
	private String Model;
	private Integer Price;
	private Integer MaxSpeed;

	public Car(String model, Integer price, Integer maxSpeed) {
		Model = model;
		Price = price;
		MaxSpeed = maxSpeed;
	}

	public Car() {
	}

	public void crash() {
		Price /= 10;
		MaxSpeed = 0;
	}

	@Override
	public String toString() {
		return "Car{" +
				"Model='" + Model + '\'' +
				", Price=" + Price +
				", MaxSpeed=" + MaxSpeed +
				'}';
	}
}
