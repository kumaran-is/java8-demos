import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class Lambda4Java8 {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
					new Person("Charles", "Dickens", 60),
					new Person("Lewis", "Carroll", 42),
					new Person("Thomas", "Carlyle", 51),
					new Person("Charlotte", "Bronte", 45),
					new Person("Matthew", "Arnold", 39)
				);
		
		// Java 8
		
		// Step: Sort the list by last name
		
		Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		// Step 2: Create a method that prints all element in the list
		
		// printAll(people);
		// printConditionally(people, p -> true);
		 performConditionally(people, p -> true, p -> System.out.println(p));
	
		// Step 3:prints by passing condition
		
		// printConditionally(people, p -> p.getLastName().startsWith("A"));
		 performConditionally(people,  p -> p.getLastName().startsWith("A"), p -> System.out.println(p));
		 
		 performConditionally(people,  p -> p.getLastName().startsWith("A"), p -> System.out.println(p.getFirstName()));
		
		
		
	}
	
	private static void printAll(List<Person> people) {
	  for(Person p: people) {
		  System.out.println("printAll >>>>" + p);
	  }
	}
	

	/*private static void printConditionally(List<Person> people, Condition condition) {
		for(Person p: people) {
			if(condition.test(p)) {
				System.out.println("printConditionally >>>>" + p);
			} 
		}
	} */
	
	// replace Condition interface with function -> predicate interface 
	private static void printConditionally(List<Person> people, Predicate<Person> predicate) {
		for(Person p: people) {
			if(predicate.test(p)) {
				System.out.println("printConditionally >>>>" + p);
			} 
		}
	}
	
	private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for(Person p: people) {
			if(predicate.test(p)) {
				consumer.accept(p);
			} 
		}
	}

}

