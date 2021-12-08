
import java.util.function.BiConsumer;

public class Lambda5ExceptionHandling {

	public static void main(String[] args) {
		
		int someNumbers[] = { 1, 2, 3, 4 };
		int key =2;
		process(someNumbers, key);
		withLambdaprocess(someNumbers, key, (v, k) -> System.out.println(v+ k) );
		
		int key2 = 0;
		withLambdaprocess(someNumbers, key2, (v, k) -> {
			
			try {
				System.out.println(v/k);
			} catch(ArithmeticException e) {
				System.out.println("ArithmeticException occured >>> ");
			}
		});
		
		
		withLambdaprocess(someNumbers, key2,  wrapperLambda((v, k) ->System.out.println(v/ k)) );
	}
	
	// without lambda
	private static void process(int someNumbers[], int key) {
		
		for(int i: someNumbers) {
			System.out.println(i + key);
		}
		
	}
	
	private static void withLambdaprocess(int someNumbers[], int key, BiConsumer<Integer, Integer> consumer) {
		
		for(int i: someNumbers) {
			consumer.accept(i, key);
		}
		
	}
	
	// handle exception in the wrapper lambda
	
	private static BiConsumer<Integer, Integer>  wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		
		return (v, k) -> {
			try {
			consumer.accept(v, k);
			} catch(ArithmeticException e) {
				System.out.println("ArithmeticException in wrapper occured >>> ");
			}
		};
	}

}
