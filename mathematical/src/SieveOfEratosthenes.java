import java.util.Arrays;

public class SieveOfEratosthenes {

    /*
        埃氏筛 -- 范围内找质数算法
        基本思想是先标定一个范围内的所有数，然后从最小的数2开始，将2的倍数剔除，剩下的就是2和奇数；接着用下一个未被剔除的数3，剔除它的倍数；
        再对下一个未被剔除的数5，剔除它的倍数……依此类推，直到没有可剔除的数为止。剩下的数即为该范围内所有的素数。
     */
    private static boolean[] GetRangePrime(int n) {
        boolean[] prime = new boolean[n];

        if(n <= 2)
            return prime;

        Arrays.fill(prime, true);
        // 1不是质数，而0无需考虑
        prime[1] = prime[0] = false;

        // 只需要考虑前半段
        for(int i = 2; i*i<n; i++){
           if(prime[i]){
               // 成倍筛 2i 3i 4i 5i .... 以此类推都不是质数
               for(int j = i*2; j<n; j+=i)
                   prime[j] = false;
           }
        }

        return prime;
    }

    // test
    public static void main(String[] args) {
        System.out.println(Arrays.toString(GetRangePrime(100)));
    }
}
