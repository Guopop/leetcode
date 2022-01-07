import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class ZuiXiaoDeKgeShuLcof {
	/**
	 * 时间复杂度: O(nlogn)
	 * 空间复杂度: O(n)
	 */
	public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    private void quickSort(int[] a, int s, int e) {
        if (e <= s) {
            return;
        }
        int pivot = partition(a, s, e);

        quickSort(a, s, pivot - 1);
        quickSort(a, pivot + 1, e);
    }

    private int partition(int[] a, int s, int e) {
        int pivot = e;
        int index = s;

        for (int i = s; i < e; i++) {
            if (a[i] < a[pivot]) {
                swap(a, i, index);
                index++;
            }
        }
        swap(a, pivot, index);
        return index;
    }

    private void swap(int[] a, int s, int e) {
        int tmp = a[e];
        a[e] = a[s];
        a[s] = tmp;
    }	
}
