package chansol;
import java.util.*;

public class pro_12906 {
        public int[] solution(int []arr) {

            Stack<Integer> stack = new Stack<>();

            stack.add(arr[0]);
            for(int i=1; i<arr.length; i++){
                if(stack.peek()!=arr[i]){       //가장 최근에 들어온 애가 배열값이랑 같으면 연속된 거.
                    stack.add(arr[i]);
                }
            }
            int s_size = stack.size();

            int[] answer = new int[s_size];

            for(int i =0; i<s_size; i++){

                answer[s_size-i-1] = stack.pop();
            }

            return answer;
        }

        //아니 이거 다하고 다른 사람 코드 봤는데 그냥 return을 stack 형으로 바꿨네.. 미친 사람들

}
