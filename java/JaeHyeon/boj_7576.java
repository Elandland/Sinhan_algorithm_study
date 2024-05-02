import java.io.*;
import java.util.*;

public class boj_7576 {

  static int n;
  static int m;
  static int[][] box;
  static int[] x = {0, 0, 1, -1};
  static int[] y = {1, -1, 0, 0};
  static boolean[][] visit;
  static Queue<int[]> queue = new LinkedList<>();
  static int result = 0;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());

    box = new int[m][n];
    visit = new boolean[m][n];

    for (int i = 0; i < m; i++) {
      box[i] = Arrays.stream(br.readLine().split(" "))
          .mapToInt(Integer::parseInt).toArray();

      for (int j = 0; j < n; j++) {
        if (box[i][j] == 1) {
          visit[i][j] = true;
          queue.offer(new int[]{i, j});
        }
      }
    }

    bfs();

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        result = Math.max(result, box[i][j]);

        if (box[i][j] == 0) {
          bw.write(String.valueOf(-1));
          bw.flush();
          bw.close();
          return;
        }
      }
    }

    bw.write(String.valueOf(result-1));
    bw.flush();
    bw.close();
  }

  private static void bfs() {

    while (!queue.isEmpty()) {

      int[] start = queue.poll();

      for (int i = 0; i < 4; i++) {
        int X = start[0] + x[i];
        int Y = start[1] + y[i];

        if (X >= 0 && X < m && Y >= 0 && Y < n
            && box[X][Y] == 0 && !visit[X][Y]) {

          queue.offer(new int[]{X, Y});
          visit[X][Y] = true;
          box[X][Y] = box[start[0]][start[1]] + 1;
        }
      }
    }
  }
}
