import java.util.*;
class Solution {
  static Map<Character, Integer> map = new HashMap<>();
  static StringBuilder sb = new StringBuilder();
  static String[] indicator = {"RT",  "CF", "JM", "AN"};

  public String solution(String[] survey, int[] choices) {
    map.put('R', 0);
    map.put('T', 0);
    map.put('C', 0);
    map.put('F', 0);
    map.put('J', 0);
    map.put('M', 0);
    map.put('A', 0);
    map.put('N', 0);

    for (int i = 0; i < survey.length; i++) {

      char first = survey[i].charAt(0);
      char second = survey[i].charAt(1);

      if (choices[i] > 4) {
        map.put(second, map.get(second) + (choices[i] % 4));

      } else if (choices[i] < 4) {
        map.put(first, map.get(first) + (4 - choices[i]));
      }
    }

//    map.forEach((key, value) -> {
//      System.out.println(key + ": " + value);
//    });

    for (String s : indicator) {

      char first = s.charAt(0);
      char second = s.charAt(1);

      if (map.get(first) > map.get(second)) {
        sb.append(first);

      } else if (map.get(first) < map.get(second)){
        sb.append(second);

      } else {
        sb.append(first);
      }
    }

    return sb.toString();
  }
}