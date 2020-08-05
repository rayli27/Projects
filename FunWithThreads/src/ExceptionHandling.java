import java.io.IOException;
import java.util.EmptyStackException;

public class ExceptionHandling {

	public ExceptionHandling() {

		Stack stack = new Stack(5);
		
		
		try {
			stack.push(0);
			stack.push(10);
			stack.push(8);
			stack.push(6);
			stack.push(4);
//			stack.push(2);
//			stack.push(0);
//			stack.push(-2);
//			stack.push(-4);
//			stack.push(-6);
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println("catch");
		} finally {
			System.out.println("finally");
		}
		System.out.println("ok");


//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
//		System.out.println(stack.pop());
	}

}

class Stack {
	int[] theStack;
	int index = 0;
	
	public Stack(int length) {
		theStack = new int[length];
	}
	
	public void push(int value) throws IOException {
		if(index>=theStack.length) {
			throw new IOException();
		}
		theStack[index++] = value;
	}
	
	public int pop() {
//		if(index>0) {
			return theStack[--index];
//		}
//		return 100;
	}
	
}