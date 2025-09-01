public class Gcd_Lcm {
    // 最大公约数
    private static int gcd(int a, int b) {
        if(b == 0)
            return a;

        // 递归实现
        return gcd(b, a%b);
    }

    // 最小公倍数
    private static int lcm(int a, int b) {
        int gcd = gcd(a, b);

        // 防止大数乘法溢出
        return Math.abs(a) / gcd * Math.abs(b);
    }


    // test
    public static void main(String[] args) {
        int a = 240;
        int b = 124;

        System.out.println(lcm(a,b));
        System.out.println(gcd(a,b));
    }
}
