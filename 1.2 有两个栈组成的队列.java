package queue;

import java.util.Stack;

/*
 * 用两个栈实现队列， 支持队列的基本操作（add, poll, peek）
 * */
public class QueueByStack {
	public Stack<Integer> stackPush;
	public Stack<Integer> stackPop;

	public QueueByStack() {
		stackPush = new Stack<Integer>();
		stackPop = new Stack<Integer>();
	}

	public void add(int pushInt) {
		stackPush.push(pushInt);
	}

	public int poll() {
		if (stackPop.empty() && stackPush.empty()) {
			throw new RuntimeException("Queue is empty");
		} else if (stackPop.empty()) {
			while (!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}

		return stackPop.pop();
	}

	public int peek() {
		if (stackPop.empty() && stackPush.empty()) {
			throw new RuntimeException("Queeu is empty");
		} else if (!stackPush.empty()) {
			stackPop.push(stackPush.pop());
		}

		return stackPop.peek();    
	}
}
