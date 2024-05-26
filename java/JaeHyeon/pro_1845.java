import java.util.*;
import java.util.stream.Collectors;

class Solution {

  public int solution(int[] nums) {

    int maxPick = nums.length / 2;

    Set<Integer> set = Arrays.stream(nums)
        .boxed()
        .collect(Collectors.toSet());

        /*
            HashSet을 int 배열의 값으로 간편하게 초기화 하는 방법
            (몇 개만 추려봄)

            1. int[] array = {1, 2, 3, 4, 5};
               Set<Integer> set = Set.of(1, 2, 3, 4, 5);

            ※ 1번은 Java 9 이상에서 사용 가능,
            배열의 크기가 작을 때 유용한 방법.

            2. Set<Integer> set = Arrays.stream(array)
                                        .parallel()
                                        .boxed()
                                        .collect(Collectors.toSet());

            parallel() -> 배열이 매우 큰 경우 병렬 스트림을 사용하여, 변환 작업을 별령로 처리함
            boxed() -> Set은 int의 값을 Integer 객체로 변환해주는 메서드 (int 값은 저장 x, Integer 객체 저장 가능)
            import java.util.stream.Collectors; 이거 임포트 해줘야 함

            느낀점:
                그냥 for문 돌려서 넣는게 편할듯;;
        */

    return set.size() < maxPick ? set.size() : maxPick;
  }
}

// 예전 코드
//    import java.util.HashSet;
//    import java.util.Set;

//    class Solution {
//      public int solution(int[] nums) {
//        int n = nums.length/2;
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums)
//          set.add(num);
//
//        int s = set.size();
//
//        if (n <= 1) {
//          return 1;
//        } else if (n <= s) {
//          return n;
//        } else {
//          return s;
//        }
//      }
//    }