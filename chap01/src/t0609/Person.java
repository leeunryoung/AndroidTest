package t0609;

public class Person implements Comparable<Person>{

	public String name;
	public int age;
	
	public Person(String name, int age) {
		this.name=name;
		this.age=age;
	}
	@Override
	public int compareTo(Person arg0) {
		if(age < arg0.age)
			return -1;
		else if(age == arg0.age)
			return 0;
		else
			return 1;
	
	}

}
