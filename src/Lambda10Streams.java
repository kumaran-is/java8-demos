import java.util.Arrays;
import java.util.List;

public class Lambda10Streams {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
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
