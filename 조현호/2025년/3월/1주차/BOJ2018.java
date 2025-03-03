// 어떤 자연수 n은 몇 개의 연속된 자연수의 합으로 나타낼 수 있다 당신은 어떤 자연수를 몇 개의 
// 연속된 자연수의 합으로 나타내는 가짓수를 알고 싶다.
// 이때 사용하는 자연수는 n이어야 한다. 예를 들어 15를 나타내는 방법은
// 15, 7 + 8, ~~~이다.
//  반면 10을 나타내는 방법은 10, 1 + 2 + 3 + 4이다.
// 연속된 자연수니까 5+5는 안 된다.
// 투 포인터로 푸는 거니까
// 10에 대해서
// 1 2 3 4 5 6 7 8 9 10
// 투포인터하고 뭔 상관인지 잘 모르겠다.
// 시도 1. 포인터로 작은 값을 하나 잡고, 그 다음 값을 잡고, 그 다음 값을 잡아? 
//  아니, 애초에 연속된 등차수열의 합은 정해져있잖아. 
// 아
// (1 + 4)*4//2 = 10 그러네.
// 이건 다시 풀어서
//  ((1 + 4) * (4 - 1 + 1)) // 2 = 10
// 그러니까 arr = [1, 2, 3, 4, 5,...,n]일떄
// (arr[ptr1] + arr[ptr2]) * (arr[ptr2] - arr[ptr1] + 1) // 2 = n
// 그러면 포인터는 어떻게 움직여야 해?
// n보다 부분 배열의 합이 크면: ptr1을 증가. 
// (증가 시키다가 배열의 합이 작아지면 다시 ptr2가 알아서 증가할 것이므로 겹치지는 않을 거 같음)
// n보다 부분 배열의 합이 작으면: ptr2를 증가. 
// n과 부분 배열의 합이 같으면: 둘 다 증가. -> 이게 맞는지는 잘 모르겠다

import java.util.Scanner;

class BOJ2018 {

    public static int MAX_N = 10000000;
    public static int[] arr = new int[MAX_N];

    public static void main(String[] args) {
        int ptr1 = 0;
        int ptr2 = 0;
        int tmp;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        int ans = 1;
        while (ptr1 < n - 1 && ptr2 < n) {
            tmp = ((arr[ptr1] + arr[ptr2]) * (arr[ptr2] - arr[ptr1] + 1)) / 2;
            if (tmp == n) {
                ans++;
                ptr1++;
                ptr2++;
            } else if (tmp > n) {
                ptr1++;
            } else if (tmp < n) {
                ptr2++;
            }
        }
        System.out.println(ans);

    }
}
