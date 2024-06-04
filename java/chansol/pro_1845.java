package chansol;
import java.util.*;
public class pro_1845 {
    class Solution {
        public int solution(int[] nums) {
            int answer = 0;

            int len = nums.length;
            int select = len/2;
            HashSet<Integer> set = new HashSet<>();      //중복 허용 x

            for(int i=0; i<len; i++){
                set.add(nums[i]);       //nums에 있는 값 넣음.
            }

            if(select > set.size()){
                answer = set.size();
            }
            else {
                answer = select;
            }


            return answer;
        }
    }
}
