import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class Lambda8MethodReference2 {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60, Gender.MALE),
				new Person("Lewis", "Carroll", 42, Gender.MALE),
				new Person("Thomas", "Carlyle", 51, Gender.MALE),
				new Person("Charlotte", "Bronte", 45, Gender.MALE),
				new Person("Matthew", "Arnold", 39, Gender.MALE),
				new Person("Jamie", "Goa", 22, Gender.FEMALE),
				new Person("Anna", "Cook", 18, Gender.FEMALE)
			);

		 performConditionally(people, p -> true, System.out::println);
	}
	
	
	private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for(Person p: people) {
			if(predicate.test(p)) {
				consumer.accept(p);
			} 
		}
	}

}
