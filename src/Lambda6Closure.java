
public class Lambda6Closure {

	public static void main(String[] args) {

     int a = 10;
     int b = 20;
     
     // without Lambda expression
     doProcess(a, new Process() {
    	 @Override
    	 public void process(int i) {
    		 System.out.println(i + b);
    	 }
     });
	
	
	// using Lambda Expression
	
	doProcess(a, i -> System.out.println(i + b));
	
	}
	
	public static void doProcess(int i, Process p) {
		p.process(i);
	}

}

interface Process {
	void process(int i);
}
