import java.util.*;

class Solution {

  public int solution(int[] people, int limit) {
    int answer = 0;

    Arrays.sort(people);

    int idx = 0;

    for (int i = people.length-1; i >= 0; i--) {

      if (idx > i) {
        break;
      }

      int sum = people[i] + people[idx];

      if (sum <= limit) {
        idx++;
      }
      answer++;
    }

    return answer;
  }
}
