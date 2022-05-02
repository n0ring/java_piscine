package edu.school21.App;

import edu.school21.Car.Car;
import edu.school21.Reflection.Reflection;
import edu.school21.User.User;

import java.util.Scanner;

public class App {
	public static void main(String[] args)  {

		String className;
		Scanner sc = new Scanner(System.in);
		System.out.println("Classes: ");
		System.out.println(User.class.getSimpleName());
		System.out.println(Car.class.getSimpleName());
		System.out.println("-------------------");
		System.out.println("Enter the class name:");
		className = sc.nextLine();
		try {
			Reflection.showClassEntry(className);
		}
		catch (Exception e) {
			System.err.println(e);
		}


	}
}
