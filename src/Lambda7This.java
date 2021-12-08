
public class Lambda7This {
	
	public void  doProcess(int i, Process p) {
		p.process(i);
	}
	
	public void execute() {
			doProcess(10, i ->{
			
			System.out.println("value of inside execute() i is " + i);
			
			 System.out.println(this);
		});
	}

	public static void main(String[] args) {
		Lambda7This lambda7This = new Lambda7This();
		lambda7This.doProcess(10,new Process() {
			
			@Override
			public void process(int i) {
				System.out.println("value of i is " + i);
				// this refers to inner anaonymous class
				System.out.println(this);
			}
			
			@Override
			public String toString() {
				return "this is anaonymous inner class";
			}
		});
		
		
		lambda7This.doProcess(10, i ->{
			
			System.out.println("value of i is " + i);
			// this is always refer to parent class, this reference does not get modified
			// System.out.println(this);
		});
		
		lambda7This.execute();

	}

}
