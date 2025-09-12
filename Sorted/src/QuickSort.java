import java.util.Arrays;


public class QuickSort {

    /**
     * 快速排序  -  以右端点为基准，比右端点小的往左边移动，而比右端点打的往右边移动，这样在循环结束后的位置就是基准的位置，采用递归解决更小规模的问题
     *
     *      时间复杂度 O(n*logn)  当逆序的时候最坏O(n*n)
     */
    private static void qSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        // 获取分区点索引
        int pivotIndex = partition(arr, left, right);

        qSort(arr, left, pivotIndex - 1);
        qSort(arr, pivotIndex + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];

        // i 指向小于基准的元素区域的最后一个位置
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // 将基准元素放到正确位置
        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 9, 1, 8, 3, 6, 2, 7};
        qSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}