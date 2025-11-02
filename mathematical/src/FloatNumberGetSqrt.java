public class FloatNumberGetSqrt {

    /**
     *  牛顿迭代法逼近
     * @param a 待开方的参数
     * @return a开方后的结果，以一定的误差收敛
     */
    private static double sqrt(double a){
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


    // Test
    public static void main(String[] args) {
        double a = 26.0;
        double res = sqrt(a);

        System.out.println("the sqrt res of a is : " + res);
    }
}
