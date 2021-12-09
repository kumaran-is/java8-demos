import java.util.Optional;

public class OptionalDemo1 {

	public static void main(String[] args) {
	
	// Optional<Object> empty = Optional.empty();
	//  Optional<Object> empty = Optional.of("test");
		Optional<Object> empty = Optional.ofNullable("test");
	 
	 System.out.println(empty.isEmpty());
	 System.out.println(empty.isPresent());
	 
	 System.out.println(empty.orElse("Hello"));
	}

}
