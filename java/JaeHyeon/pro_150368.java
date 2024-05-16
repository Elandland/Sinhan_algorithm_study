import java.util.*;

public class pro_150368 {

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

    // 이모티콘 개수 만큼 depth가 차면
    // 계산을 하는 함수 실행
    if (depth == rate.length) {
      calculation(users, emoticons, rate);
      return;
    }

    for (int i = 10; i <= 40; i+=10) {

      rate[depth] = i;
      dfs(users, emoticons, rate, depth+1);

      // 굳이 이렇게 값을 되돌려 주면서 탐색을 할 필요가 없었음...
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

    O: for (int[] user : users) {

      int sum = 0;

      // 사용자의 할인율, 금액 커트라인? 을 받음
      int userRate = user[0];
      int cutLine = user[1];

      for (int i = 0; i < emoticons.length; i++) {

        if (userRate <= rate[i]) {

          sum += (emoticons[i] - ((emoticons[i]/100) * rate[i]));

          // 만약 한 사용자의 각 이모티콘 계산의 합이 커트라인 이상이면
          // 가입자를 올리고 반복문 continue로 탈출
          if (cutLine <= sum) {
            sub++;
            continue O;
          }
        }
      }

      profit += sum;
    }

    // 리턴(결과) 값 갱신
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