package chansol;

public class pro_43165 {
    class Solution {
        //어차피 앞에 부호를 마음대로 바꿀 수 있으니 numbers는 그냥 냅두고 앞에 부호만 바꿔주면 됨.
        //+,-경우만 구해주면 되니까 최대의 경우수 2^20 = 1024*1024 니까 100만이면 적음
        private int calculate_cnt;
        private int[] arr;
        private int answer;
        private int dfs_target;
        public int solution(int[] numbers, int target) {
            answer = 0;
            arr = numbers;
            calculate_cnt = numbers.length;
            dfs_target = target;

            dfs(0,0);
            return answer;
        }

        public void dfs(int depth, int numbers_sum){
            if(depth==calculate_cnt){
                if(dfs_target==numbers_sum){
                    answer++;
                }
                return;
            }

            dfs(depth+1,numbers_sum+arr[depth]);    //더할때
            dfs(depth+1,numbers_sum-arr[depth]);    //뺄때
        }


    }
}
