import java.util.Arrays;

public class BubbleSort {

    /**
     *  冒泡排序，时间复杂度O(n^2)
     * @param arr 待排序数组
     */
    private static void bubbleSort(int[] arr){
        int n = arr.length;
        for(int i = 0;i<n-1;i++){
            // 判断当前是否有交换的标志位
            boolean swap = false;

            // 每一次替换到最末尾，有序的数字会往最末尾沉淀
            for(int j = 0;j<n-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }

            // 已经有序了
            if(!swap)
                break;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 4, 7, 2,  5, 1, 9 };
        bubbleSort(arr1);

        System.out.println(Arrays.toString(arr1));
    }
}