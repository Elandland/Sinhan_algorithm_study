import java.util.*;
import java.io.*;

public class boj_12865 {

  static int n, k;
  static int[][] dp;
  static int[] w, v;

  public static void main(String[] args) throws IOException {

    // 이 문제... 백트래킹인가?
    // 전부 탐색해보면서 최고의 가치를 나타내면 되는 거 같다고 생각함

    // 시간초과가 나오는 걸 보니 메모이제이션 문제인 것 같다.
    // 결국 DP 인가..?

    // 찾아보니 냅색 알고리즘이라고 한다.
    // 오늘 또 벽을 느꼈다.

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    // 여행에 필요하다고 생각하는 물품의 수
    n = Integer.parseInt(st.nextToken());

    // 버틸 수 있는 무게
    k = Integer.parseInt(st.nextToken());

    dp = new int[n+1][k+1];

    w = new int[n+1];
    v = new int[n+1];

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());

      w[i] = Integer.parseInt(st.nextToken());
      v[i] = Integer.parseInt(st.nextToken());
    }

    for(int i=1;i<=n;i++) {
      for(int j=1;j<=k;j++) {
        dp[i][j] = dp[i-1][j]; // 기본적으로 이전 아이템의 가치를 저장한다.
        if(j - w[i]>=0) { // 무게에서 자신의 무게를 뺐을 때 남는 무게가 존재하면,
          dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]]+v[i]); // 이전 아이템에서 구한 가치와 남은 무게의 가치 + 자신의 가치 중 큰 값을 취한다.
        }
      }
    }

    /*
     * 47번째 줄이 왜 필요한가... 하며
     * 반례를 찾아봄
     * 이해가 덜 돼서인지 반례 찾으려고 1시간 태운듯
     *
     * 2 3
     * 3 7
     * 6 1
     *
     * 이거 값이 0이 되어 버림
     * */

//    for (int i = 1; i <= n; i++) {
//      for (int j = 1; j <= k; j++) {
//        System.out.print(dp[i][j] + " ");
//      }
//      System.out.println();
//    }

    bw.write(String.valueOf(dp[n][k]));
    bw.flush();
    bw.close();
  }
}
