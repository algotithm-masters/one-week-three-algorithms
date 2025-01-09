import java.util.Scanner;

public class FillingSquare {
    static int MAX_N = 1001;
    static long[] dp = new long[MAX_N];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i <= n; i++){
            int tmp = 0;
            for(int j = 0; j < i-2; j++){
                tmp += (2*dp[j])%1000000007;
            }
            dp[i] = (2*dp[i-1]+3*dp[i-2]+tmp)%1000000007;
        }

        System.out.println(dp[n]);
    }
}