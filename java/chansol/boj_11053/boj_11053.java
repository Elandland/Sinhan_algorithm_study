package chansol.boj_11053;

import java.io.*;
import java.util.*;

public class boj_11053 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int answer = 0;
        int[] arr = new int[size];
        int[] dp = new int[size];
        dp[0] = 1;   //첫번째 원소는 자기 자신만을 부분 수열로 참고할 수 있으므로 길이 1
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        /*
        원래 아래와 같이 처음부터 끝까지 긁는 방법으로 dp배열 값을 상승시켜서
        자기보다 작은 배열값을 세려고 했는데 이러니까
         */
        /*
        for(int j=0; j<size-1; j++){
            for(int k=j+1; k<size; k++){
                if(arr[j]<arr[k]){

                }
            }
        }
         */
        if (size > 1) {
            for (int i = 1; i < size; i++) {
                dp[i] = 1;   //감소 수열이라고 해도 자기자신만을 부분 수열로 잡으면 되니까 최소한 ans =1
                for (int j = 0; j < i; j++) {       //0부터 자기까지 쭉 조사
                    if(arr[i]>arr[j]&&dp[i]>=dp[j]){     //자기 보다 작은 수가 있음 and dp[]값이 자기보다 작거나 같음(부분수열을 만족)
                        //여기서 이제 중복되는걸 수열로 포함 안하면 됨.
                        dp[i]++;
                        System.out.println("dp["+i+"]"+"="+dp[i]);
                    }
                }

            }
        }
        for (int l = 0; l < size; l++) {
            System.out.printf(dp[l] + "  ");
        }
        System.out.println(" ");
        System.out.print(answer);
    }

}
