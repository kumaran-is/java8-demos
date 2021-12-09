import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import java.util.Comparator;

public class ImperativeVsDeclarativeExample3 {

	public static void main(String[] args) {
		List<Person> people = getPeople();
		
		// Declarative approach 
		
		// Filter to include only female
	    List<Person> females = people.stream()
	        .filter(person -> person.getGender().equals(Gender.FEMALE))
	        .collect(toList());
	  //  females.forEach(System.out::println);
	    
	    // Sort
	    List<Person> sorted = people.stream()
	        .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed())
	        .collect(toList());
	    //	sorted.forEach(System.out::println);
	    
	 // All match age > 50
	    boolean allMatch = people.stream()
	        .allMatch(person -> person.getAge() > 50);
	   // System.out.println(allMatch);
	    
	    // Any match
	    boolean anyMatch = people.stream()
	        .anyMatch(person -> person.getAge() > 59);
	    //	System.out.println(anyMatch);
	    
	 // None match
	    boolean noneMatch = people.stream()
	        .noneMatch(person -> person.getFirstName().equals("Lewis"));
	   //  System.out.println(noneMatch);
	    
	    // Max
	    people.stream()
	        .max(Comparator.comparing(Person::getAge))
	        .ifPresent(System.out::println);

	    // Min
	    people.stream()
	     .min(Comparator.comparing(Person::getAge))
        .ifPresent(System.out::println);
	    
	 // Group
	    Map<Gender, List<Person>> groupByGender = people.stream()
	        .collect(Collectors.groupingBy(Person::getGender));

	    groupByGender.forEach((gender, people1) -> {
	   System.out.println(gender);
      people1.forEach(System.out::println);
	    });
	    
	    Optional<String> oldestFemaleAge = people.stream()
	            .filter(person -> person.getGender().equals(Gender.FEMALE))
	            .max(Comparator.comparing(Person::getAge))
	            .map(Person::getFirstName);

	        oldestFemaleAge.ifPresent(System.out::println);
	    
	}
	
	private static List<Person> getPeople() {
	    return List.of(
	    		new Person("Charles", "Dickens", 60, Gender.MALE),
				new Person("Lewis", "Carroll", 42, Gender.MALE),
				new Person("Thomas", "Carlyle", 51, Gender.MALE),
				new Person("Charlotte", "Bronte", 45, Gender.MALE),
				new Person("Matthew", "Arnold", 39, Gender.MALE),
				new Person("Jamie", "Goa", 22, Gender.FEMALE),
				new Person("Anna", "Cook", 18, Gender.FEMALE)
	    );
	  }

}
