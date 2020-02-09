package easyProblems;

import java.util.Stack;

public class DesignMinStack {
	
    Stack<Integer> elementStack;
    Stack<Integer> minStack;
    

    /** initialize your data structure here. */
    public DesignMinStack(){
        elementStack = new Stack<>();
        minStack = new Stack<>();
        elementStack.push(Integer.MAX_VALUE);
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        elementStack.push(x);
        if(x<=minStack.peek())
            minStack.push(x);
    }
    
    public void pop() {
        if(elementStack.peek() == minStack.peek())
            minStack.pop();
        
        elementStack.pop();
    }
    
    public int top() {
        return elementStack.peek();
        
    }
    
    public int getMin() {
        return minStack.peek();
    }
	

	public static void main(String[] args) {
		
		DesignMinStack minStack = new DesignMinStack();
		minStack.push(512);
		minStack.push(-1024);
		minStack.push(-1024);
		minStack.push(512);
		minStack.pop();
		minStack.getMin();   
		minStack.pop();      
		minStack.getMin();
		minStack.pop();      
		minStack.getMin();

	}

}
