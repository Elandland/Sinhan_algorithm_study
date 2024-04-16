package chansol.boj_1654;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class boj_1654 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int lan_count = sc.nextInt();       //랜선 갯수
        int lan_need = sc.nextInt();        //필요한거 갯수
        int[] lan = new int[lan_count];     //랜선들
        int min, max, mid = 0;
        int answer;

        for (int i = 0; i < lan_count; i++) {
            lan[i] = sc.nextInt();
        }

        //최솟값 을 2부터 최솟값까지 올라가면서 나눠서 최솟값을 구하는 줄 알았는데 재현이가 이분탐색이라고 가르쳐줌
        //개어렵다

        Arrays.sort(lan);

        max = lan[lan.length - 1];        //sort했으니까 제일 마지막 꺼가 제일 큼
        min = 0;        //왜 내가 여기다가 lan[0]이걸 했을까 미친놈.
        //자연스럽게 mid를 여기다가 적었었음

        max++;      //lan.length가 1일때 max=min인 것을 방지.

        while (min < max) {    //이분탐색은 원래 left<=right , 사실 그게 그 말임

            answer =0;
            mid = (max + min) / 2;      //원래 while밖에 써놨었는데 생각해보니까 반복 돌릴때마다 갱신해야되서 안에 적어야되는게 맞다.
            for(int i=0; i<lan_count; i++){
                answer+=(lan[i]/mid);       //가운데 값으로 선을 하나하나 잘라서 나오는 조건만족하는 조각을 answer에
            }

            if(answer <lan_need){
                max = mid; //갯수가 적으면 더 작은 크기로 잘라야 하니까 max값을 줄임.
            }
            else{
                min = mid+1; //mid+1로
            }
            System.out.println(answer);
        }


        System.out.println(min-1);
    }
}
