import java.io.*;
import java.util.*;

class boj_1039 {

  static class Num {
    int num;
    int count;

    Num(int num, int count) {
      this.num = num;
      this.count = count;
    }
  }

  static int n, k;
  static int result = -1;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");

    n = Integer.parseInt(input[0]);
    k = Integer.parseInt(input[1]);

    bfs();
    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
  }

  static private void bfs() {
    Queue<Num> q = new LinkedList<>();

    // 주어지는 숫자 최대 크기가 1,000,000이기 때문에 아래와 같이 길이 설정
    boolean[][] visit = new boolean[1000001][k+1];

    q.add(new Num(n, 0));
    visit[n][0] = true;

    while (!q.isEmpty()) {
      Num num = q.poll();

      if (num.count == k) {
        result = Math.max(result, num.num);
        continue;
      }

      // 만약 90이면 스왑했을 때, 9로 길이가 1이 되기 때문에 이러한 과정 필요
      int length = String.valueOf(num.num).length();

      // 완전 탐색 느낌으로다가 체크
      for (int i = 0; i < length-1; i++) {
        for (int j = i+1; j < length; j++) {
          int check = swap(num.num, i, j);

          if (check != -1 && !visit[check][num.count+1]) {
            q.add(new Num(check, num.count+1));
            visit[check][num.count+1] = true;
          }
        }
      }
    }
  }

  static private int swap(int num, int i, int j) {

    // 스왑을 위한 char 배열
    char[] numArr = String.valueOf(num).toCharArray();

    // i가 0이라는 건 첫 번째 인덱스의 숫자를 의미하는데,
    // j 인덱스의 숫자가 0이라면
    // 스왑했을 때, 0으로 시작하기 때문에 -1 리턴
    if (i == 0 && numArr[j] == '0') {
      return -1;
    }

    char temp;
    temp = numArr[i];
    numArr[i] = numArr[j];
    numArr[j] = temp;

    return Integer.parseInt(new String(numArr));
  }
}
