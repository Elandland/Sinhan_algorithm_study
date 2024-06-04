import java.util.*;
import java.io.*;

public class boj_15651 {

  static int n, m;
  static int[] arr;
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    arr = new int[m];

    dfs(0);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  static private void dfs(int depth) {

    if (depth == m) {
      for (int i : arr) {
        sb.append(i).append(" ");
      }
      sb.append("\n");
      return;
    }

    for (int i = 1; i <= n; i++) {
      arr[depth] = i;
      dfs(depth+1);
    }
  }
}