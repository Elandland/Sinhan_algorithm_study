import java.util.*;

class Solution {
  public int solution(int[][] routes) {

    Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0]);

    // System.out.println(Arrays.deepToString(routes));

    Integer camera = null;

    int count = 0;

    for (int[] route : routes) {

      if (camera == null) {
        camera = route[1];
        count++;
        continue;
      }

      if (camera < route[0]) {
        count++;
        camera = Math.max(camera, route[1]);
      } else {
        camera = Math.min(camera, route[1]);
      }
    }

    return count;
  }
}
