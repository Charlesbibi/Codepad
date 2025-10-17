public class LCS {

    /**
     * 找到两个字符串中的最大公共字串
     * @param str1 字符串1
     * @param str2 字符串2
     * @return
     */
    private static String find_lcs(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];
        int maxLen = 0;
        int maxEnd = 0; // 记录str1 的最大相同右字串节点

        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;

                    // 找到一个更大的
                    if(dp[i][j] > maxLen){
                        maxLen = dp[i][j];
                        maxEnd = i;  // 注意是更新str1的最大end，end-maxLen即是整个最大的范围
                    }
                }else
                    dp[i][j] = 0;
            }
        }

        if(maxLen == 0)
            return "";

        return str1.substring(maxEnd - maxLen, maxEnd);
    }

    // TEST
    public static void main(String[] args) {

        String str1 = "1AB2345CD";
        String str2 = "12345EF";
        String res = find_lcs(str1, str2);

        System.out.println(res);
    }
}
