package jenny;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import guiPlayer.Book;

public class CatalogMaker {

	private static ArrayList<Person> people;
	private static Scanner in;
	private static boolean add;
	private static String[] thing;

	public static void main(String[] args) {
		thing = new String[Person.length()];

		CatalogMaker maker = new CatalogMaker();
		in = new Scanner(System.in);
		maker.start();
	}

	public void start() {
		add = true;
		System.out.println("Do you want to open a saved file? ('yes' or 'no')");
		String s = in.nextLine();
		
		if(s.equals("yes")) {
			//
		}else {
			while(add) {
				add();
				System.out.println("Type 'no' to stop adding people!");
				s = in.nextLine();
				if(s.equals("no")) {
					System.out.println("Would you like to save? ('yes' or 'no')");
					s = in.nextLine();
					if(s.equals("yes"))
						save();
					add = false;
				}
			}
		}
	}

	public void add() {
		String name = null;
		String gender = null;
		int age = 0;
		System.out.println("Please enter age");
		age = getIntegerInput();
		System.out.println("Please enter first name");
		name = getStringInput();
		System.out.println("Please enter gender ('Woman' or 'Man')");
		gender = getStringInput();
		addPerson(new Person(age, name, gender));
	}

	public int getIntegerInput() {
		//String text = in.nextLine();
		int value = 0;
		boolean valid = false;
		while(!valid){
			try{
				value = Integer.parseInt(text);
				valid = true;
			}catch(NumberFormatException nfe){
				System.out.println("You must enter an integer.");
				text = in.nextLine();
			}
		}
		return value;
	}

	private static String getStringInput(){
		String text = in.nextLine();
		while(text.isEmpty()){
			System.out.println("You must enter a non-empty String.");
			text = in.nextLine();
		}
		return text;
	}

	public void addPerson(Person b){
		people.add(b);
	}

	public CatalogMaker() {
		people = new ArrayList<Person>();
		people.add(new Person(17, "Jenny", "Woman"));
		people.add(new Person(17, "Qibing", "Man"));
		people.add(new Person(17, "Yeongseo", "Woman"));
		people.add(new Person(20, "Dylan", "Man"));
		people.add(new Person(17, "Eric", "Man"));
		people.add(new Person(15, "Krysta", "Woman"));
	}

	public String getCSVContent() {
		String data = "";
		for(Person p: people) {
			data += p + "\n";
		}
		return data;
	}

	public static void save() {
		try{    
			FileWriter fw = new FileWriter("People.csv");
			for(Person b: people){
				fw.write(b+"\n");    	
			}

			fw.close();    
			System.out.println("Success! File \"People.csv\" saved!");
		}catch(IOException e){
			System.out.println("An IOException was thrown. \nCheck to see that the directory where you tried to save the file actually exists.");
		}
	}
}
