import java.util.*;

public class ppp {

  // 할인률이 10, 20, 30, 40으로 정해져 있으니
  // 할인률 적용한 것을 재귀로 다 계산해보면 될듯...?

  static int subscriber = 0, maxProfit = 0;

  static private int[] solution(int[][] users, int[] emoticons) {

    // 임티 할인율 배열
    int[] rate = new int[emoticons.length];

    dfs(users, emoticons, rate, 0);

    return new int[]{subscriber, maxProfit};
  }

  static private void dfs(int[][] users, int[] emoticons, int[] rate, int depth) {
    if (depth == rate.length) {
      calculation(users, emoticons, rate);
      return;
    }

    for (int i = 10; i <= 40; i+=10) {

      rate[depth] = i;
      dfs(users, emoticons, rate, depth+1);

      // 이전 코드
//      for (int j = 0; j < rate.length; j++) {
//        int r = rate[j];
//        rate[j] = i;
//        dfs(users, emoticons, rate, depth+1);
//        rate[j] = r;
//      }
    }
  }

  static private void calculation(int[][] users, int[] emoticons, int[] rate) {

    int sub = 0, profit = 0;

    for (int[] user : users) {

      int sum = 0;

      int userRate = user[0];
      int cutLine = user[1];

      for (int i = 0; i < emoticons.length; i++) {

        if (userRate <= rate[i]) {

          // a - ((a/100) * 40)

          sum += (emoticons[i] - ((emoticons[i]/100) * rate[i]));
          // System.out.println(userRate + " / " + sum + " / " + rate[i] + " / " + emoticons[i]);
        }
      }

      System.out.println(userRate + " / " + "cutLine = " + cutLine + " / sum = " + sum);

      if (cutLine <= sum) {
        sub++;
      } else {
        profit += sum;
      }
    }

    // 리턴 값 갱신
    if (subscriber < sub) {
      subscriber = sub;
      maxProfit = profit;
      System.out.println("--------" + sub + " / " + profit);
    } else if (subscriber == sub) {
      maxProfit = Math.max(maxProfit, profit);
      System.out.println("--------" + sub + " / " + profit);
    }
  }

  public static void main(String[] args) {
    int[][] u = {{40, 10000}, {25, 10000}};
    int[] e = {7000, 9000};

    System.out.println(Arrays.toString(solution(u, e)));
  }
}