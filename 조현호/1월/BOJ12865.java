import java.util.Scanner;

class BOJ12865{
    static int MAX_N = 101;
    static int MAX_K = 100000;
    static int[] weights = new int[MAX_N];
    static int[] values = new int[MAX_N];
    static int[][] dp = new int[MAX_N][MAX_K];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for(int i = 0; i < n; i++){
            weights[i] = sc.nextInt();
            values[i] = sc.nextInt();
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if(j-weights[i] >= 0)
                    dp[i][j] = Math.max(dp[i-1][j-weights[i]]+values[i], dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println(dp[n][k]);

    }
}