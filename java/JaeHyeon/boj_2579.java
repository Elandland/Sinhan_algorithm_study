import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static int[] arr;
  static int[] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    arr = new int[n+1];

    for (int i = 1; i <= n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }

    dp = new int[n+1];

    dp[1] = arr[1];

    if (n > 1) {
      dp[2] = arr[1] + arr[2];
    }

//    if (n > 2) {
//      dp[3] = Math.max(dp[1], dp[2]) + arr[3];
//    }   이거 있으니까 안된다;

    for (int i = 3; i <= n; i++) {
      dp[i] = arr[i] + Math.max(dp[i-2], dp[i-3] + arr[i-1]);
    }

    bw.write(String.valueOf(dp[n]));
    bw.flush();
    bw.close();
  }
}
