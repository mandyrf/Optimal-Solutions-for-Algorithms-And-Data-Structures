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

	// 堆排序：循环建立堆，然后交换角标0的节点和角标最后的节点。
	// 即排序由两部分组成，建立堆的渗透函数，和通过循环调用渗透函数
	public static void heapSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			buildMaxHeap(a, a.length - 1 - i);
			System.out.println(Arrays.toString(a));
			swap(a, 0, a.length - 1 - i);// 堆建立好后，交换根节点和堆的最后一个节点
			System.out.println("============  " + Arrays.toString(a));
		}

	}

	// 常用的建堆方法主要用于堆元素已经确定好的情况
	// 从0~lastIndex 调整堆
	public static void buildMaxHeap(int[] a, int lastIndex) {
		// 从底向上依次调整节点
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

			// 找到largest需要调整后再对largest的子节点进行调整
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
	 * 插入元素：先将新节点放在堆的末端，再对这个新节点执行向上调整操作
	 * 
	 * @param array
	 * @param data
	 * @return
	 */
	public static int[] insertData(int[] array, int data) {
		array[array.length - 1] = data; // 将新节点放在堆的末端
		buildMaxHeap(array, array.length - 1);
		System.out.println(Arrays.toString(array));
		return array;
	}

	/**
	 * 删除堆顶元素：先将堆的最后一个元素与堆顶元素交换，由于此时堆的性质被破坏， 需对此时的根节点进行向下调整操作。
	 * 
	 * @param array
	 * @return
	 */
	public static int[] deleteMax(int[] array) {
		// 将堆的最后一个元素与堆顶元素交换，堆底元素值设为-99999
		array[0] = array[array.length - 1];
		array[array.length - 1] = -99999;
		// 对此时的根节点进行向下调整
		maxHeapAdjust(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
		return array;
	}

}
