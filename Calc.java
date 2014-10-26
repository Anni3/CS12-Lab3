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
	public void push(double x){
		top++;
		numStack[top]=var;
	}
	
	//Pop top number (removes)
	public double pop(){
		if (top==-1) throw new RuntimeException();
		top--;
		int incremTop = top+1;
		return numStack[incremTop];
	}
	
	//Peek at top number (don't remove)
	public double peek(){
		if (top==-1) throw new RuntimeExpection();
		return numStack[top];
	}
	
	//Add top two numbers
	public void add(){
		if(top<1) throw new RuntimeExpection();
		//addition: 1st = 1st + 2nd
		numStack[top-1] = numStack[top-1] + numStack[top];
		top--;
	}
	
	//Subtract top two numbers (top on right side)
	public void subtract(){
		if (top<1) throw new RuntimeExpection();
		// 1st = 1st - 2nd
		numStack[top-1] = numStack[top-1]-numStack[top];
		top--;
	}
	
	//multiply top two numbers
	public void multiple(){
		if(top<1) throw new RuntimeExpection();
	}
	
	//divide top two numbers
	public void divide(){
		if(top<1) throw new RuntimeExpection();
	}
	
	//return how many numbers are in the stack
	public int depth(){
		return 0;
	}
	
}