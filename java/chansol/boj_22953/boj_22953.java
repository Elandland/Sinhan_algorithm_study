package chansol.boj_22953;
import java.util.*;

public class boj_22953 {

    private static long binary_search(int[] arr,int k){
        long min_time = 0;
        long max_time = 1000000*1000000/10;
        long food_cnt;
        long ans;

        while (min_time <max_time){
            food_cnt =0;
            long mid_time = (min_time+max_time)/2;

            for(int i=0; i<arr.length; i++){
                food_cnt += mid_time/arr[i];            //걸리는 시간 / 1개 만드는 데 걸리는 시간 = i번째 인간이 만드는 총 음식 갯수
            }

            if(food_cnt<k){         //음식을 더 만들어야 함 ->총 시간 늘려야 함
                min_time = mid_time;
            }
            else{                   //음식이 남을때 -> 시간을 줄여야함.
                max_time = mid_time+1;
            }

        }
        ans = min_time;
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();       //요리사의 수
        int K = sc.nextInt();       //만들어야 할 음식의 갯수
        int C = sc.nextInt();       //격려할 수 있는 횟수
        int ans = 0;

        int[] arr = new int[N];     //인덱스번에 있는 요리사가 요리를 하는데에 걸리는 시간.

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }
        /*
        일단 처음 생각 = 음식 걸리는 시간의 평균값이 낮아지는 쪽으로 격려-> 음식시간 최대인 걸 기준으로 이분탐색 진행 -> 하면서 최소공배수 체크도 진행하면 될듯?
        double average = Arrays.stream(arr).average().orElse(0);   // 평균값 구하기. 없으면 o을 출력
        이러면 안될듯?
         */

        /*
        요리의 시간이 가장 짧은 애가 전체를 만드는 시간이 오래 걸리느 놈의 1개 보다 많으면 적은애를 격려? 아니면 큰애를 격려
        예쩨 2의 경우 101을 줄였고 3의 경우100을 줄임...
         */

        /*
        격려 횟수를 정하는데에는 규칙이 없데 -> 격려 횟수가 5번밖에 안됨. -> 경우의 수를 모두 구해서 그냥 이분탐색을 다 돌려버리자
         */


        for(int i=0; i<C; i++){

        }




    }


}
