import java.io.*;

public class Puppy {
	int puppyAge;
	public Puppy() {
	}
	
	public puppy(String name) {
		// only have one parameter: name
		System.out.println("Passed name is:"+name);
	}
	
	public void setAge(int age) {
		puppyAge = age;
	}
	
	public int getAge() {
		System.out.println("Puppy's age is: "+puppyAge);
		return puppyAge;
	}
	
	public static void main(String[] args) {
		// create new object
		Puppy myPuppy = new Puppy("andy");
		myPuppy.setAge(2);
		myPuppy.getAge();
		System.out.println("Variable Value: "+myPuppy.puppyAge);
	}
}