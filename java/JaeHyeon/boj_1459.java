import java.util.*;
import java.io.*;

public class boj_1459 {

  static long X, Y, W, S;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    X = Long.parseLong(st.nextToken());
    Y = Long.parseLong(st.nextToken());
    W = Long.parseLong(st.nextToken());
    S = Long.parseLong(st.nextToken());

    // 대각선으로 가지 않을 때
    long justStraight = (X+Y) * W;

    // 대각선으로만 갈 때
    long daeGak = 0;
    if ((X+Y) % 2 == 0) { // 짝수일 때
      daeGak = Math.max(X, Y) * S;
    } else {
      daeGak = (Math.max(X, Y) - 1) * S + W;
    }

    // 대각선으로 갈 수 있을 만큼 가고, 직진
    long daeGakAndStraight = Math.min(X, Y) * S + Math.abs(X-Y) * W;

    bw.write(String.valueOf(Math.min(justStraight, Math.min(daeGakAndStraight, daeGak))));
    bw.flush();
    bw.close();
  }
}
