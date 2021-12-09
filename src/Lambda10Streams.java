import java.util.Arrays;
import java.util.List;

public class Lambda10Streams {

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
		
		
		people.stream()
		.filter(p -> p.getLastName().startsWith("C"))
		.forEach(p -> System.out.println(p.getFirstName()));
		
		long count = people.stream()
		.filter(p -> p.getLastName().startsWith("C"))
		.count();
		
		System.out.println(count);
		
		// lambda enables functional programmaing,  paralell streams , more readbale , easier use library and better library.
		long count2 = people.parallelStream()
				.filter(p -> p.getLastName().startsWith("C"))
				.count();
				
				System.out.println(count);
		
	}

}
