import java.util.Scanner;

public class BOJ1463 {
    static int MAX_N = 1000001;
    static int[] dp = new int[MAX_N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1];
            if(i%2 == 0) dp[i] = Integer.min(dp[i], dp[(int)(i/2)]);
            if(i%3 == 0) dp[i] = Integer.min(dp[i], dp[i/3]);
            dp[i]++;
        }
        System.out.println(dp[n]);
    }
}
