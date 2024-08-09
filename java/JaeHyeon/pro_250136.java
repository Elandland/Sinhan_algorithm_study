import java.util.*;

class Solution {

  static int[] x = {0, 0, 1, -1};
  static int[] y = {1, -1, 0, 0};
  static int answer = 0;
  static boolean[][] visit;
  static int[] check;

  public int solution(int[][] land) {
    visit = new boolean[land.length][land[0].length];
    check = new int[land[0].length];

    for (int i = 0; i < land.length; i++) {
      for (int j = 0; j < land[0].length; j++) {
        if (land[i][j] == 0) {
          visit[i][j] = true;
        }
      }
    }

    for (int j = 0; j < land[0].length; j++) {
      for (int i = 0; i < land.length; i++) {

        if (!visit[i][j] && land[i][j] == 1) {
          bfs(j, i, visit, land);
        }
      }
    }

    answer = Arrays.stream(check).max().getAsInt();
    return answer;
  }

  static void bfs(int j, int i, boolean[][] visit, int[][] land) {
    visit[i][j] = true;
    int count = 1;

    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{j, i});

    Set<Integer> set = new HashSet<>();

    while (!q.isEmpty()) {

      int[] a = q.poll();

      set.add(a[0]);

      for (int k = 0; k < 4; k++) {

        int newJ = x[k] + a[0];
        int newI = y[k] + a[1];

        if (newJ >= 0 && newJ < visit[0].length &&
            newI >= 0 && newI < visit.length &&
            land[newI][newJ] == 1 &&
            !visit[newI][newJ]) {

          visit[newI][newJ] = true;
          count++;
          q.offer(new int[]{newJ, newI});
        }
      }
    }

    for (int s : set) {
      check[s] += count;
    }
  }
}