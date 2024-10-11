import java.util.*;

public class pro_42895 {
    public int solution(int N, int number) {

        if (N == number) return 1;

        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            dp.add(new HashSet<>());
        }

        dp.get(1).add(N);

        for (int i = 2; i < 9; i++) {

            Set<Integer> countSet = dp.get(i);

            for (int j = 1; j <= i; j++) {
                Set<Integer> preSet = dp.get(j);
                Set<Integer> postSet = dp.get(i-j);

                for (int preNum : preSet) {
                    for (int postNum : postSet) {
                        countSet.add(preNum + postNum);
                        countSet.add(preNum - postNum);
                        countSet.add(preNum * postNum);

                        if (postNum != 0) countSet.add(preNum + postNum);
                    }
                }

                countSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));

                if (countSet.contains(number)) return i;
            }
        }

        return -1;
    }
}
