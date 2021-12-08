import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Lambda3Java7 {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
					new Person("Charles", "Dickens", 60),
					new Person("Lewis", "Carroll", 42),
					new Person("Thomas", "Carlyle", 51),
					new Person("Charlotte", "Bronte", 45),
					new Person("Matthew", "Arnold", 39)
				);
		
		// Java 7
		
		// Step: Sort the list by last name
		
		Collections.sort(people, new Comparator<Person>() { 
			@Override
			public int compare(Person p1, Person p2) {
				return p1.getLastName().compareTo(p2.getLastName());
			}
		});
		
		// Step 2: Create a method that prints all element in the list
		
		printAll(people);
		
		// Step 3: Create a method that prints all people that have last name beginning with C
		
		printLastNameBeginningWithC(people);
		
		// Step 3:prints by passing condition
		
		printConditionally(people, new Condition() {
			@Override
			public boolean test(Person p) {
				return p.getLastName().startsWith("A");
			}
			
		});
	}
	
	private static void printAll(List<Person> people) {
	  for(Person p: people) {
		  System.out.println("printAll >>>>" + p);
	  }
	}
	
	private static void printLastNameBeginningWithC(List<Person> people) {
		for(Person p: people) {
			if(p.getLastName().startsWith("C")) {
				System.out.println("printLastNameBeginningWithC >>>>" + p);
			} 
		}
	}
	
	private static void printConditionally(List<Person> people, Condition condition) {
		for(Person p: people) {
			if(condition.test(p)) {
				System.out.println("printConditionally >>>>" + p);
			} 
		}
	}

}


interface Condition {
	boolean test(Person p);
}
