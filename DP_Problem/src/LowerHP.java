import java.util.*;

public class LowerHP {
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        int n = in.nextInt();
        int m = in.nextInt();
        int[][] rooms = new int[n][m];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                rooms[i][j] = in.nextInt();
            }
        }
        in.close();

        int res = reverse_dp_find_lower_hp(n, m, rooms);

        System.out.println(res);
    }

    /**
     *  一个二维矩阵 grid，大小为 n x m
     * 每个格子有三种情况：
     * 值 > 0：加血
     * 值 < 0：扣血
     * 值 = 0：不影响血量
     *
     * 英雄从 (0,0) 出发，到 (n-1, m-1)，只能向右或向下走
     * 要求：路径中任意时刻血量不能 ≤ 0（即必须保持 > 0 才能活着）。
     * 问：英雄出发时最少需要多少初始血量，才能保证走到终点。
     *
     * @param n 二维数组长度
     * @param m 二维数组宽度
     * @param rooms 当前每一个房间的值
     * @return 最少初始血量
     */
    private static int reverse_dp_find_lower_hp(int n, int m, int[][] rooms) {
        int[][] dp = new int[n][m];

        // 从右下角开始, 每一个房间最低hp就是1了，从末尾开始临界值就是1
        dp[n-1][m-1] = Math.max(1, 1-rooms[n-1][m-1]);

        // 处理行和列的边界， 如果说上一个房间的血量小于这个房间的加血量，则进入这个房间的最小HP就是1
        for(int i = n-2;i>=0;i--){
            dp[i][m-1] = Math.max(1, dp[i+1][m-1] - rooms[i][m-1]);
        }

        for(int i = m-2;i>=0;i--){
            dp[n-1][i] = Math.max(1, dp[n-1][i+1] - rooms[n-1][i]);
        }

        for(int i = n-2;i>=0;i--){
            for(int j = n-2;j>=0;j--){
                // 对于中间的房间，需要判断右边或者下面走哪一个代价更小
                int need = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(1, need - rooms[i][j]);
            }
        }

        return dp[0][0];
    }
}
