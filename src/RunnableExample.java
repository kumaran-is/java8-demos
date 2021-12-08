
public class RunnableExample {

	public static void main(String[] args) {
		Thread myThread = new Thread(new Runnable() {
			
			public void run() {
				System.out.println("Running inside Runnbale");
			}
			
		});
		
		myThread.run();
		
		// using lambda expression
		
		Thread myThread2 = new Thread(() -> System.out.println("Running inside Runnbale"));
		myThread2.run();
	}
}
