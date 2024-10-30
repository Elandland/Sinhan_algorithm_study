class Solution {

  static int[][] dp;
  static int div = 1000000007;

  public int solution(int m, int n, int[][] puddles) {
    dp = new int[n+1][m+1];

    for (int[] puddle : puddles) {
      dp[puddle[1]][puddle[0]] = -1;
    }

    dp[1][1] = 1;

    for (int i = 1; i < n+1; i++) {

      for (int j = 1; j < m+1; j++) {

        // for (int k = 0; k <= n; k++) {
        //     for (int r = 0; r <= m; r++) {
        //         System.out.print(dp[k][r] + " ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        if (dp[i][j] == -1) {
          continue;
        }

        if (dp[i-1][j] > 0) {
          dp[i][j] = (dp[i][j] + dp[i-1][j]) % div;
        }

        if (dp[i][j-1] > 0) {
          dp[i][j] = (dp[i][j] + dp[i][j-1]) % div;
        }
      }
    }

    return dp[n][m];
  }
}
