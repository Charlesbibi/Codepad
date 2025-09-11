public class FastExponentiation {

    /**
     *  方法
     *     带取模的快速幂算法，防止大整数溢出
     *  时间复杂度 O(logn)
     * */
    private static long FastExponent(long base, long power, int mod) {
        long result = 1;

        while (power > 0) {

            // 最低数位为1时才做乘法
            if ((power & 1) == 1)
                result = (result * base) % mod;

            // 10  -  1010二进制
            // 倍数增长
            base = (base * base) % mod;

            // 左移一位相当于除以二
            power >>= 1;
        }

        return result;
    }

    // test
    public static void main(String[] args) {
        System.out.println(FastExponent(10, 2 ,1000_000_007));
    }
}
