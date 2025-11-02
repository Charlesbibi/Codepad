/**
 * 给定一个浮点数a，计算该数的开方值，不能使用库函数
 */
public class FloatNumberGetSqrt {

    /**
     *  牛顿迭代法逼近
     * @param a 待开方的参数
     * @return a开方后的结果，以一定的误差收敛
     */
    private static double sqrtND(double a){
        if(a<0)
            throw new IllegalArgumentException("输入不能为负数");

        if(a == 0)
            return 0;

        // 可以接受的精度
        double epsilon = 1e-10;

        double x = a;

        while(Math.abs(x*x - a) > epsilon){
            x = (x + a/x) / 2.0;
        }

        return x;
    }

    /**
     *  二分查找法
     * @param a 待开方的参数
     * @return a开方后的结果，以一定的误差收敛
     */
    private static double sqrtBS(double a){
        if (a < 0) {
            throw new IllegalArgumentException("输入不能为负数");
        }
        if (a == 0 || a == 1) {
            return a;
        }

        double epsilon = 1e-10;
        double left, right;

        // 确定搜索范围
        if (a < 1) {
            left = a;
            right = 1;
        } else {
            left = 1;
            right = a;
        }

        // 二分查找
        while (right - left > epsilon) {
            double mid = (left + right) / 2;
            double square = mid * mid;

            if (Math.abs(square - a) < epsilon) {
                return mid;
            } else if (square < a) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return (left + right) / 2;
    }


    // Test
    public static void main(String[] args) {
        double a = 0.50;
        double res1 = sqrtND(a);
        double res2 = sqrtBS(a);

        System.out.println("the 牛顿sqrt res of a is : " + res1 + " and the 二分sqrt res of a is : " + res2);
    }
}
