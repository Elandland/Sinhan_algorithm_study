import java.util.*;
import java.io.*;

public class boj_15650 {

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

    dfs(0, 1);

    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  static private void dfs(int depth, int flag) {

    if (depth == m) {
      for (int i : arr) {
        sb.append(i).append(" ");
      }
      sb.append("\n");
      return;
    }

    // i 가 4일 땐 끝까지 못가서(?) 결국 결과값에 담기지 않음
    for (int i = flag; i <= n; i++) {
      arr[depth] = i;
      dfs(depth+1, i+1);
    }
  }
}