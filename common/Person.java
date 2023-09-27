package common;

public class Person {
private String name;
public Person(String name, int age) {
	super();
	this.name = name;
	this.age = age;
}

/**
 * @return the name
 */
public String getName() {
	return name;
}

/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}

/**
 * @return the age
 */
public int getAge() {
	return age;
}

/**
 * @param age the age to set
 */
public void setAge(int age) {
	this.age = age;
}

private int age;

public Person() {}
}
