import java.util.*;
import java.io.*;

public class boj_4963 {
  static int w, h;      // 너비, 높이
  static int[][] map;   // 지도
  static int count = 0; // 섬의 개수
  static StringBuilder sb = new StringBuilder();  // 결과

  // 탐색할 좌표 배열 (8개)
  static int[] X = {0, 0, 1, -1, 1, 1, -1, -1};
  static int[] Y = {1, -1, 0, 0, 1, -1, 1, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // w, h 값이 둘 다 0이면 while문 탈출
    do {

      // 너비, 높이 값 받기
      StringTokenizer st = new StringTokenizer(br.readLine());
      w = Integer.parseInt(st.nextToken());
      h = Integer.parseInt(st.nextToken());

      // 지도(배열) 생성
      map = new int[h][w];
      for (int i = 0; i < h; i++) {
        map[i] = Arrays.stream(br.readLine().split(" "))
            .mapToInt(Integer::parseInt).toArray();
      }

      // dfs 탐색. '1'인 좌표(?)를 찾으면 탐색 후 count 증가
      for (int i = 0; i < h; i++) {
        for (int j = 0; j < w; j++) {
          if (map[i][j] == 1) {
            dfs(i, j);
            count++;
          }
        }
      }

      // 섬의 개수 달아주기
      sb.append(count).append("\n");

      // 섬 개수 초기화
      count = 0;

    } while(!(w == 0 && h == 0));

    // '개행'과 '너비와 높이가 0'일 때의 '두 문자열'을 지워주어야 함
    sb.deleteCharAt(sb.length() - 2);

    // 결과 출력
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  static private void dfs(int nowX, int nowY) {

    // '1'이었던 값을 0으로 바꿔줌
    map[nowX][nowY] = 0;

    for (int i = 0; i < 8; i++) {
      int x = nowX + X[i];
      int y = nowY + Y[i];

      if (x >= 0 && x < h && y >= 0 && y < w && map[x][y] == 1) {
        dfs(x, y);
      }
    }
  }
}
