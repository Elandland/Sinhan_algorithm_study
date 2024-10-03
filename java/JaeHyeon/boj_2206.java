import java.io.*;
import java.util.*;

public class boj_2206 {

    static int x, y;
    static int[] X = {1, -1, 0, 0};
    static int[] Y = {0, 0, -1, 1};
    static int[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);

        board = new int[x][y];

        for (int i = 0; i < x; i++) {
            board[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int result = bfs();

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    static private int bfs() {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});  // {x좌표, y좌표, 벽을 부순 여부}
        int[][][] visit = new int[x][y][2];

        visit[0][0][0] = 1; // 초기 위치 방문 처리

        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int a = cur[0];
            int b = cur[1];
            int broken = cur[2];

            if (a == x - 1 && b == y - 1) {
                return visit[a][b][broken];
            }

            for (int i = 0; i < 4; i++) {
                int aCheck = a + X[i];
                int bCheck = b + Y[i];

                if (aCheck >= 0 && aCheck < x && bCheck >= 0 && bCheck < y) {
                    // 빈 칸일 경우
                    if (board[aCheck][bCheck] == 0 && visit[aCheck][bCheck][broken] == 0) {
                        visit[aCheck][bCheck][broken] = visit[a][b][broken] + 1;
                        q.offer(new int[]{aCheck, bCheck, broken});
                    }
                    // 벽일 경우
                    else if (board[aCheck][bCheck] == 1 && broken == 0 && visit[aCheck][bCheck][1] == 0) {
                        visit[aCheck][bCheck][1] = visit[a][b][broken] + 1;
                        q.offer(new int[]{aCheck, bCheck, 1});
                    }
                }
            }
        }

        return -1; // 도달할 수 없는 경우
    }
}
