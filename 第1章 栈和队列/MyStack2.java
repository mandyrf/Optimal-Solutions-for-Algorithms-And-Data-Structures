package stackForGetMin;

import java.util.Stack;

/*
* 如何仅用递归函数和栈操作逆序一个栈：
* 
* 改变从栈顶到栈底的顺序
* 
*/

public class MyStack2 {

	private Stack<Integer> stack;

	public MyStack2() {
		this.stack = new Stack<Integer>();
	}

	/**
	 *   *  3  *
	 *   *     *
	 *   *  2  *
	 *   *     *
	 *   *  1  *
	 *   * * * *
	 * 
	 *   i=1, 将1重新加入
	 *       |     ^ 
	 *   i=2, 将2重新加入
	 *       |     ^
	 *   i=3, 将3重新加入
	 *       |     ^
	 *   栈为空，向上返回
	 *   
	 * @param stack
	 */
	public static void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int i = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.push(i);
	}

	// 递归函数1：返回栈底元素并且删除
	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result; // 是栈底元素
		} else {
			// 不为空， 不是栈底元素，递归获取栈底
			int temp = getAndRemoveLastElement(stack);
			stack.push(result);// 把不是栈底的重新入栈
			return temp;
		}
	}

	public static void main(String[] args) {
		MyStack2 stack = new MyStack2();
		for (int i = 0; i < 10; i++) {
			stack.stack.push(i);
		}
		reverse(stack.stack);
		while (!stack.stack.isEmpty()) {
			System.out.println(stack.stack.pop());
		}
	}

}
