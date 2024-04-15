package JaeHyeon;

import java.io.*;
import java.util.*;

// 이분탐색 문제라고 함
public class CuttingLAN {
  static int k;
  static int n;
  static long[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    k = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());

    arr = new long[k];
    for (int i = 0; i < k; i++) {
      arr[i] = Long.parseLong(br.readLine());
    }

    Arrays.sort(arr);

    long max = arr[k-1];
    long min = 0;
    max++;  // max 가 1일 때를 방지

    while (min < max) {
      long mid = (max + min) / 2;
      long count = 0;
      for (int i = 0; i < k; i++) {
        if (arr[i] >= mid) {
          count += arr[i] / mid;
        }
      }

      // 사이트 예시를 볼 때, 199일 때도 11이기 때문에
      // min 값을 증가시켜주면서 확인해야 함...?
      if (count < n) {
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
