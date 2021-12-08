
public class Lambda2 {

	public static void main(String[] args) {
		
		StringLengthLambda mylambda = s -> s.length();
		
		//System.out.println(mylambda.getLength("kumaran"));
		printLambda(mylambda);
	}
	
	
	public static void printLambda(StringLengthLambda l) {
		System.out.println(l.getLength("kumaran"));
	}

}

@FunctionalInterface
interface StringLengthLambda {
	int getLength(String s);
}
