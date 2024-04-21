package chansol.boj_2579;

import java.util.*;

public class boj_2579아무생각없이함 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int floor = sc.nextInt();
        int[] floors = new int[floor];
        int max=0;

        for(int i=0; i<floor; i++){
            floors[i] = sc.nextInt();
        }

        Arrays.sort(floors);

        for(int j=0; j<floor/4; j++){
            floors[j] =0;
        }

        for(int k=0; k<floor; k++){
            max+=floors[k];
        }

        System.out.println(max);

    }

    //마지막 계단을 무조건 밟아야함.
    //느낌이 dp이긴한데
}
