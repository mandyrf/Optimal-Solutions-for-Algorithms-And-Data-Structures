package stackForGetMin;

import java.util.Arrays;

public class HeapSort {

	static int arr[] = { 49, 38, 65, 97, 76, 13, 27, 49 };

	public static void main(String[] args) {
		buildMaxHeap(arr, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		insertData(arr, 63);
		deleteMax(arr);
		heapSort(arr);
	}

	// ������ѭ�������ѣ�Ȼ�󽻻��Ǳ�0�Ľڵ�ͽǱ����Ľڵ㡣
	// ����������������ɣ������ѵ���͸��������ͨ��ѭ��������͸����
	public static void heapSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			buildMaxHeap(a, a.length - 1 - i);
			System.out.println(Arrays.toString(a));
			swap(a, 0, a.length - 1 - i);// �ѽ����ú󣬽������ڵ�Ͷѵ����һ���ڵ�
			System.out.println("============  " + Arrays.toString(a));
		}

	}

	// ���õĽ��ѷ�����Ҫ���ڶ�Ԫ���Ѿ�ȷ���õ����
	// ��0~lastIndex ������
	public static void buildMaxHeap(int[] a, int lastIndex) {
		// �ӵ��������ε����ڵ�
		for (int i = lastIndex; i >= 0; i--) {
			maxHeapAdjust(a, i, lastIndex);
		}
	}

	/**
	 * parent = i; left = 2*i + 1 right = 2*i + 2
	 * 
	 * @param a
	 * @param i
	 * @param lastIndex
	 */
	public static void maxHeapAdjust(int[] a, int i, int lastIndex) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largest = i;

		while (true) {
			if (left <= lastIndex && a[left] > a[i]) {
				largest = left;
			}
			if (right <= lastIndex && a[right] > a[largest]) {
				largest = right;
			}
			if (i != largest) {
				swap(a, i, largest);
			} else {
				break;
			}

			// �ҵ�largest��Ҫ�������ٶ�largest���ӽڵ���е���
			i = largest;
			left = 2 * largest + 1;
			right = 2 * largest + 2;
		}
	}

	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	/**
	 * ����Ԫ�أ��Ƚ��½ڵ���ڶѵ�ĩ�ˣ��ٶ�����½ڵ�ִ�����ϵ�������
	 * 
	 * @param array
	 * @param data
	 * @return
	 */
	public static int[] insertData(int[] array, int data) {
		array[array.length - 1] = data; // ���½ڵ���ڶѵ�ĩ��
		buildMaxHeap(array, array.length - 1);
		System.out.println(Arrays.toString(array));
		return array;
	}

	/**
	 * ɾ���Ѷ�Ԫ�أ��Ƚ��ѵ����һ��Ԫ����Ѷ�Ԫ�ؽ��������ڴ�ʱ�ѵ����ʱ��ƻ��� ��Դ�ʱ�ĸ��ڵ�������µ���������
	 * 
	 * @param array
	 * @return
	 */
	public static int[] deleteMax(int[] array) {
		// ���ѵ����һ��Ԫ����Ѷ�Ԫ�ؽ������ѵ�Ԫ��ֵ��Ϊ-99999
		array[0] = array[array.length - 1];
		array[array.length - 1] = -99999;
		// �Դ�ʱ�ĸ��ڵ�������µ���
		maxHeapAdjust(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
		return array;
	}

}
