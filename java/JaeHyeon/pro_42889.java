import java.util.*;

class Solution {

  static double[][] arr;
  static Map<Integer, Integer> map = new HashMap<>();
  static int[] result;

  public int[] solution(int N, int[] stages) {

    arr = new double[N][2];

    for (int i = 0; i < N; i++) {
      arr[i][0] = i+1;
    }

    result = new int[N];

    for (int i = 0; i < stages.length; i++) {

      int num = stages[i];

      if (map.containsKey(num)) {
        map.put(num, map.get(num) + 1);
      } else {
        map.put(num, 1);
      }
    }

    int players = stages.length;

    for (int i = 1; i <= N; i++) {

      int x;

      if (map.containsKey(i)) {
        x = map.get(i);
      } else {
        continue;
      }

      arr[i-1][1] = (double) x / players;

      players -= x;
    }

    Arrays.sort(arr, Comparator.comparingDouble((double[] a) -> a[1]).reversed()
        .thenComparingDouble((double[] a) -> a[0]).reversed());

    for (int i = 0; i < N; i++) {
      result[i] = (int) arr[N-1-i][0];
    }

    return result;
  }
}