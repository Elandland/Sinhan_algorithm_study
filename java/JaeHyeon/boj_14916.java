package JaeHyeon;

import java.io.*;
import java.util.*;

public class boj_14916 {
  static int n;
  static int result = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());

    if (n < 5) {
      if (n%2 == 1) {
        result = -1;
      } else {
        result = n/2;
      }
    } else if (n > 5) {

      int five = n/5;
      int left = n%5;

      if (left == 0) {
        result = n / 5;
      } else {

        while (true) {

          if (five < 0) {
            result = -1;
            break;
          }

          if (left % 2 == 0) {
            result = (five + (left / 2));
            break;
          }

          five--;
          left += 5;
        }
      }
    } else {
      result = 1;
    }

    bw.write(String.valueOf(result));
    bw.flush();
    bw.close();
  }
}
