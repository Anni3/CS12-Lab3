public class Calc {
	
	//initialize array of doubles
	private double [] numStack;
	//initialize top of pile as an integer
	private int top;
	
	//Constructor
	public Calc(){
		top = -1;
		numStack = new double[100];
	}
	
	//Push a number
	public void push(double x){}
	
	//Pop top number (removes)
	public double pop(){
		return 0.0;
	}
	
	//Peek at top number (don't remove)
	public double peek(){
		return 0.0;
	}
	
	//Add top two numbers
	public void add(){}
	
	//Subtract top two numbers (top on right side)
	public void subtract(){}
	
	//multiply top two numbers
	public void multiple(){}
	
	//return how many numbers are in the stack
	public int depth(){
		return 0;
	}
	
}