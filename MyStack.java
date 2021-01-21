package stackForGetMin;

import java.util.Stack;

/*
* 设计一个有getMin功能的栈：
* 一个栈在基本功能的基础上， 再实现返回栈中最小元素的操作
* 要求：
* 1. pop, push, getMin 操作的时间复杂度都是O(1)
* 2. 设计的栈类型可以使用现成的栈结构
*/


/*
* 在设计上使用两个栈：一个用来保存当前栈中的元素， 其功能和普通栈没有区别
* 记作stackData； 另一个栈用于保存每一步的最小值，记作 stackMin
*/
public class MyStack {
	// stack.peek() 返回栈顶元素， 但不在堆栈中删除它
	// stack.pop() 返回栈顶元素， 并在堆栈中删除它
	
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    
     public MyStack() {
    	 this.stackData = new Stack<Integer>();
    	 this.stackMin = new Stack<Integer>();
     }
     
     public void push(int newNum){
    	 if(stackMin.isEmpty()) {
    		 stackMin.push(newNum);
    	 }else if(newNum < getMin()) {
    		 stackMin.push(newNum);
    	 }else {
    		 int newMin = stackMin.peek();
    		 stackMin.push(newMin);
    	 }
    	 this.stackData.push(newNum);
     }
    
     public int pop() {
    	   if(stackData.isEmpty()) {
    		   throw new RuntimeException("Your stasck is empty.");
    	   }
    	   stackMin.pop();
    	   return stackData.pop();
     }
	
     public int getMin() {
    	 if(stackMin.isEmpty()) {
    		 throw new RuntimeException("Your stack is empty.");
    	 }
    	 return stackMin.peek();
     }
	
}
