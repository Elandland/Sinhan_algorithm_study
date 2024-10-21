import java.util.*;

class Solution {
  static int count = 0;
  static int[] arr = new int[2];
  static Set<String> set = new HashSet<>();

  public int solution(String dirs) {

    for (int i = 0; i < dirs.length(); i++) {
//            System.out.println("arr = " + arr[0] + ", " + arr[1]);
//            System.out.println("set = " + set);
//            System.out.println("count = " + count);
//            System.out.println("-------------");

      String dir, rDir;
      switch (dirs.charAt(i)) {
        case 'U':
          if (!go('U')) {
            continue;
          }

          dir = arr[0] + " " + arr[1] + " " + 1 + " U";
          rDir = arr[0] + " " + (arr[1]+1) + " " + (-1) + " D";

          if (!set.contains(dir)) {
            set.add(dir);
            set.add(rDir);
            count++;
          }
          arr[1]++;
          break;

        case 'D':
          if (!go('D')) {
            continue;
          }

          dir = arr[0] + " " + arr[1] + " " + (-1) + " D";
          rDir = arr[0] + " " + (arr[1]-1) + " " + 1 + " U";

          if (!set.contains(dir)) {
            set.add(dir);
            set.add(rDir);
            count++;
          }
          arr[1]--;
          break;

        case 'R':
          if (!go('R')) {
            continue;
          }

          dir = arr[0] + " " + arr[1] + " " + 1 + " R";
          rDir = (arr[0]+1) + " " + arr[1] + " " + (-1) + " L";

          if (!set.contains(dir)) {
            set.add(dir);
            set.add(rDir);
            count++;
          }
          arr[0]++;
          break;

        case 'L':
          if (!go('L')) {
            continue;
          }

          dir = arr[0] + " " + arr[1] + " " + (-1) + " L";
          rDir = (arr[0]-1) + " " + arr[1] + " " + 1 + " R";

          if (!set.contains(dir)) {
            set.add(dir);
            set.add(rDir);
            count++;
          }
          arr[0]--;
          break;
      }
    }

    return count;
  }

  static private boolean go(char dir) {

    switch (dir) {
      case 'U':
        if (arr[1] == 5) return false;
        break;

      case 'D':
        if (arr[1] == -5) return false;
        break;

      case 'R':
        if (arr[0] == 5) return false;
        break;

      case 'L':
        if (arr[0] == -5) return false;
        break;
    }

    return true;
  }
}
