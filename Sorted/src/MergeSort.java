import java.util.Arrays;


public class MergeSort {

    /***
     * 归并排序  - 合并两个有序数组，注意处理边界情况
     *
     *          时间复杂度 O(n*logn)
      */

    private static int[] mergeSort(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int index = 0;
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] <= arr2[j]) {
                res[index++] = arr1[i++];
            }else
                res[index++] = arr2[j++];
        }

        // 对于剩下元素的判断
        while(i < arr1.length) {
            res[index++] = arr1[i++];
        }

        while(j < arr2.length) {
            res[index++] = arr2[j++];
        }

        return res;
    }


    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 4, 5, 9 };
        int[] arr2 = new int[]{2, 3, 6, 7, 8};
        int[] arr3 = mergeSort(arr1, arr2);
        System.out.println(Arrays.toString(arr3));
    }
}