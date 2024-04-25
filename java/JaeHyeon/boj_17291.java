import java.io.*;
import java.util.*;

public class Main {

  static int n;
  static int[] year;

  /**
   * 진짜 도저히 모르겠다. DP랑 손절한다.
   * **/

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());

    year = new int[n+1];

    // 1일
    year[1] = 1;

    // 2일
    if (n > 1) {
      year[2] = 2;
    }

    // 3일은 4, 4일은 7, 5일 13, ...

    // 1 2 4 7 13

    for (int i = 3; i < year.length; i++) {

      if (i % 2 != 0) {
        year[i] = year[i-1] * 2;
      } else {
        year[i] = year[i-3] + year[i-2] + year[i-1];
      }
    }

    bw.write(String.valueOf(year[n]));
    bw.flush();
    bw.close();
  }
}
