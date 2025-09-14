public class BinarySearch {

    /**
     *  二分查找 - 闭区间
     * @param arr  数组
     * @param key  查找的键值
     * @return     返回指定键值的下标，如果没有则返回-1
     */
    private static int binSearchClose(int[] arr, int key){
        int left = 0;
        int right = arr.length - 1;  // 闭区间 [left, right]

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(arr[mid] == key)
                return mid;
            else if(arr[mid] > key)
                right = mid - 1;
            else
                left = mid + 1;
        }

        //找不到
        return -1;
    }

    /**
     *  二分查找 - 左闭右开区间
     * @param arr  数组
     * @param key  查找的键值
     * @return     返回指定键值的下标，如果没有则返回-1
     */
    // 左闭右开区间写法
    private static int binSearchLeftOpen(int[] arr, int key) {
        int left = 0;
        int right = arr.length; // 左闭右开区间 [left, right)
        while (left < right) { // 区间不为空
            // 循环不变量：
            // nums[left-1] < target
            // nums[right] >= target
            int mid = left + (right - left) / 2;

            if(arr[mid] == key)
                return mid;
            else if (arr[mid] < key) {
                left = mid + 1; // 范围缩小到 [mid+1, right)
            } else {
                right = mid; // 范围缩小到 [left, mid)
            }
        }

        return -1;
    }

    /**
     *  二分查找 - 开区间
     * @param arr  数组
     * @param key  查找的键值
     * @return     返回指定键值的下标，如果没有则返回-1
     */
    private static int binSearchLeftRightOpen(int[] arr, int key){
        int left = 0;
        int right = arr.length; // 开区间 (left, right)

        while(left + 1 < right){
            int mid = left + (right - left) / 2 ;

            if(arr[mid] == key)
                return mid;
            else if(arr[mid] > key)
                right = mid;
            else
                left = mid;
        }

        //找不到
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,7,8,10,13,19,26};
        int key = 14;

        int index = binSearchClose(arr, key);
        System.out.println("binSearchClose index of : " + index);

        index = binSearchLeftOpen(arr, key);
        System.out.println("binSearchLeftOpen index of : " + index);

        index = binSearchLeftRightOpen(arr, key);
        System.out.println("binSearchLeftRightOpen index of : " + index);
    }
}