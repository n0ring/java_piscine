package edu.school21.Reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class Reflection {

	static public void showClassEntry(String className) throws ClassNotFoundException {
		Class<?> objectClass = Class.forName("edu.school21." + className + "." + className);
		Field[] fields = objectClass.getDeclaredFields();
		System.out.println("fields :");
		for (Field field : fields) {
			System.out.println("\t" + field.getType().getSimpleName() + " " + field.getName());
		}
		Method[] methods = objectClass.getDeclaredMethods();
		System.out.println("methods :");
		for (Method method : methods) {
			if (Modifier.isPublic(method.getModifiers())) {
				System.out.println( "\t"+
						method.getReturnType().getSimpleName()
						+ " " + method.getName()
						+ "()"
				);
			}
		}
	}

	static public void createObject(String className) throws ClassNotFoundException,
			NoSuchMethodException {
		Class<?> objectClass = Class.forName("edu.school21." + className + "." + className);
		Constructor<?> constructor = objectClass.getConstructor();

	}
}
