

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class ImperativeVsDeclarativeExample1 {

	public static void main(String[] args) {
		
		// sum of integers for the range from 0 to 100
        /**
         * Imperative Style - how style of programming
         */
		
		int sum =0;
		
		for(int i=0; i<=100; i++) {
			sum+=i;  // shared mutable state and its sequential anf it will go step by step
            // and it will have issues if we try to run the code in multithreaded environment
		}
		
		System.out.println("Sum is : "+sum);

		 /**
         * Declarative style. (Functional programming uses the same style)
         * what style of programming.
         * You let the system do the job for you and get the result.
         */
		int sum1 = IntStream.rangeClosed(0,100)
							.parallel()
							.map(Integer::new)
							.sum();
		System.out.println("sum1 : " + sum1);
		
		// find the minimum number
		
		int numbers[] = {21,32,13,4,25, 2, 100, 1}; 
		
		int min = IntStream.of(numbers).min().orElse(0);
		
		System.out.println("min : " + min);
		
        int min1 = IntStream.of(numbers).min().getAsInt();
		
		System.out.println("min : " + min1);
		
	    IntStream.of(numbers).min().ifPresent(System.out::println);
	    
	    
	    // find first distinct smallest numbers from an array
	    
	    int num[] = {21,32,13,41,25, 2, 2,11, 11, 10, 100,}; 
	    
	    IntStream.of(num).distinct().sorted().limit(3).forEach(System.out::println);
	    
	   int result[] = IntStream.of(num).distinct().sorted().limit(3).toArray();
	    
	   System.out.println("result : " + result[0]);  
				
	  //  Names of 3 oldest person
	   
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
		.sorted(Comparator.comparingInt(Person::getAge).reversed())
		.limit(3)
		.map(Person::getFirstName)
		.forEach(System.out::println);

	}

}
