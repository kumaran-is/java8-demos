import java.util.Arrays;
import java.util.List;

public class Lambda9CollectionIteration {

	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
			);
		
		for(int i =0; i <people.size();  i++) {
			System.out.println(people.get(i));
		}
		
		System.out.println("111111111111111111");
		
		for(Person p: people) {
			System.out.println(p);
		}
		
		System.out.println("22222222222222222222");
		
		people.forEach(p -> System.out.println(p) );
		
		System.out.println("3333333");
		
		// safely run on multi threaded.
		people.forEach(System.out::println );
	}

}
