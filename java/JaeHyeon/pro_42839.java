import java.util.*;

class Solution {
  static String num;
  static Set<Integer> set = new HashSet<>();
  static String[] numArr;
  static boolean[] visit;
  static int answer = 0;

  public int solution(String numbers) {
    num = numbers;
    numArr = num.split("");
    visit = new boolean[numbers.length()];
    dfs(0, "");

    for (int i : set) {
      int n = 0;

      for (int j = 1; j <= i; j++) {
        if (i % j == 0) {
          n++;
        }
      }

      if (n == 2) {
        answer++;
      }
    }

    return answer;
  }

  static private void dfs(int depth, String n) {
    if (depth == numArr.length) {
      return;
    }

    for (int i = 0; i < numArr.length; i++) {
      if (!visit[i]) {
        visit[i] = true;
        set.add(Integer.parseInt(n + numArr[i]));
        dfs(depth+1, n + numArr[i]);
        visit[i] = false;
      }
    }
  }
}
