package jenny;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import guiTeacher.components.AnimatedComponent;
import guiTeacher.components.Component;

public class Person{
	
	private int age;
	private String firstName;
	private String gender;
	private String image;

	public Person(int age, String name, String gender) {
		this.age = age;
		firstName = name;
		this.gender = gender;
		image = "resources/" + gender + ".png";
	}
	
	public String toString() {
		return firstName + "," + gender + "," + age + "," + image;
	}
	
	public static int length() {
		return 3;
	}
}
