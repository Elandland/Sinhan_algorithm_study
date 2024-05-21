import java.util.*;
class Solution {
  static int[] scores = new int[3];
  static Map<Character, Integer> area = Map.of(
      'S', 1,
      'D', 2,
      'T', 3
  );

  public int solution(String dartResult) {

    int idx = -1;

    for (int i = 0; i < dartResult.length(); i++) {

//      System.out.println("idx = " + idx);
//      System.out.println("dartResult = " + dartResult.charAt(i));

      try {

        int score = Integer.parseInt(String.valueOf(dartResult.charAt(i)));

        if (dartResult.charAt(i+1) == '0') {
          scores[++idx] = 10;
          i++;
          continue;
        }

        scores[++idx] = score;

      } catch (NumberFormatException e) {

        char x = dartResult.charAt(i);

        if (x == '*') {

          for (int j = idx-1; j <= idx; j++) {

            if (j < 0) {
              continue;
            }

            scores[j] *= 2;
          }

        } else if (x == '#') {

          scores[idx] *= -1;

        } else {
          scores[idx] = (int) Math.pow(scores[idx], area.get(x));
        }
      }
    }

//    System.out.println("scores = " + Arrays.toString(scores));

    return Arrays.stream(scores).sum();
  }
}