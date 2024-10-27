import java.util.*;

class Solution {
  public int solution(String skill, String[] skill_trees) {
    int answer = 0;

    for (String s : skill_trees) {

      String a = "";
      for (int i = 0; i < s.length(); i++) {
        String x = String.valueOf(s.charAt(i));
        if (skill.contains(x)) {
          a += x;
        }
      }

      if (skill.startsWith(a)) answer++;
    }

    return answer;
  }
}
