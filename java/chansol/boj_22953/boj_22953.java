package chansol.boj_22953;
import java.util.*;

public class boj_22953 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();       //요리사의 수
        int K = sc.nextInt();       //만들어야 할 음식의 갯수
        int C = sc.nextInt();       //격려할 수 있는 횟수

        int[] arr = new int[N];     //인덱스번에 있는 요리사가 요리를 하는데에 걸리는 시간.

        /*
        일단 처음 생각 = 음식 걸리는 시간의 평균값이 낮아지는 쪽으로 격려-> 음식시간 최대인 걸 기준으로 이분탐색 진행 -> 하면서 최소공배수 체크도 진행하면 될듯?
         */


    }


}