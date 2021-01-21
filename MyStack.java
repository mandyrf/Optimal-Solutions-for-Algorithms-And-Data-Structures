package stackForGetMin;

import java.util.Stack;

/*
* ���һ����getMin���ܵ�ջ��
* һ��ջ�ڻ������ܵĻ����ϣ� ��ʵ�ַ���ջ����СԪ�صĲ���
* Ҫ��
* 1. pop, push, getMin ������ʱ�临�Ӷȶ���O(1)
* 2. ��Ƶ�ջ���Ϳ���ʹ���ֳɵ�ջ�ṹ
*/


/*
* �������ʹ������ջ��һ���������浱ǰջ�е�Ԫ�أ� �书�ܺ���ͨջû������
* ����stackData�� ��һ��ջ���ڱ���ÿһ������Сֵ������ stackMin
*/
public class MyStack {
	// stack.peek() ����ջ��Ԫ�أ� �����ڶ�ջ��ɾ����
	// stack.pop() ����ջ��Ԫ�أ� ���ڶ�ջ��ɾ����
	
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
