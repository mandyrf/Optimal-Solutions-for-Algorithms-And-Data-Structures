package stackForGetMin;

import java.util.Stack;

/*
* ��һ��ջʵ����һ��ջ������
* 
* �ı��ջ����ջ�׵�˳��
* 
*/

public class SortStack {

	private Stack<Integer> stack;

	public SortStack() {
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
	 *   i=1, ��1���¼���
	 *       |     ^ 
	 *   i=2, ��2���¼���
	 *       |     ^
	 *   i=3, ��3���¼���
	 *       |     ^
	 *   ջΪ�գ����Ϸ���
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

	// �ݹ麯��1������ջ��Ԫ�ز���ɾ��
	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result; // ��ջ��Ԫ��
		} else {
			// ��Ϊ�գ� ����ջ��Ԫ�أ��ݹ��ȡջ��
			int temp = getAndRemoveLastElement(stack);
			stack.push(result);// �Ѳ���ջ�׵�������ջ
			return temp;
		}
	}

	public static void main(String[] args) {
		SortStack stack = new SortStack();
		for (int i = 0; i < 10; i++) {
			stack.stack.push(i);
		}
		reverse(stack.stack);
		while (!stack.stack.isEmpty()) {
			System.out.println(stack.stack.pop());
		}
	}

}
