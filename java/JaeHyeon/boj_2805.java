import java.io.*;
import java.util.*;

public class Main {

  static int n, k;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());

    arr = Arrays.stream(br.readLine().split(" "))
        .mapToInt(Integer::parseInt).toArray();

    Arrays.sort(arr);

    int max = arr[n-1];
    int min = 0;

    while (min < max) {

      int mid = (max + min) / 2;
      int count = 0;

      for (int i : arr) {
        if (i < mid) {
          continue;
        }

        count += (i - mid);
      }

      if (count < k) {

        // 맥스 값을 mid로 낮춰줌
        max = mid;
      } else {
        min = mid + 1;
      }
    }

    bw.write(String.valueOf(min-1));
    bw.flush();
    bw.close();
  }
}
