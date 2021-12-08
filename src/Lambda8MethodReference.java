
public class Lambda8MethodReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Thread t =new Thread (() -> printMessage());
		
		// replace lambda expression above with method reference  
		
		Thread t =new Thread (Lambda8MethodReference::printMessage);
		t.start();
		
		// There Lambda8MethodReference::printMessage is equal to () -> printMessage()

	}
	
	public static void printMessage() {
		System.out.println("Hello");
	}

}
