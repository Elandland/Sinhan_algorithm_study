package chansol.boj_2579;

import java.util.Scanner;

public class boj_2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int floor = sc.nextInt();
        int[] floors = new int[floor];
        int[] max_score = new int[floor];

        for(int i=0; i<floor; i++){
            floors[i] = sc.nextInt();
        }

        //설명에서 전부 index-1하면 될듯
        //1개일때 최대 = floors[1] -> max(1)이라고 가정
        //2개일때 최대 = floors[1]+floors[2]
        //3개일때 최대 = floors[1]+floors[3] or floors[2]+floors[3]
        //4개일때 최대 = floors[4]+(floors[3]+floor[1] or floors[1]+floors[2])
        //5개일때 최대 = floors[5]+(floors[4]+floor[2]+floors[1] or floors[3]+floors[2] or floors[3]+floors[1]) -> 전꺼 밟는거, 전전꺼 밟는거 경우만 세면 될듯?
        //6개일때 최대 = floors[6]+(floors[5]+floors[3]+floor[2] or 5,3,1 or 4,3,1 )

        //n개일때 최대 = floors[n]+ (floors[n-1]+max[n-3] or max[n-2]) ->4개일때부터

        max_score[0] += floors[0];
        if(floor >=2) {                     //   index참조 오류 때문에 if걸어줘야 되는데 꼭 걸어야되나
            max_score[1] += floors[0] + floors[1];
        }
        if(floor >=3) {
            max_score[2] += Math.max(floors[0] + floors[2], floors[1] + floors[2]);
        }
        if(floor >=4)
            for (int i = 3; i < floor; i++) {
                max_score[i] = floors[i] + Math.max(floors[i - 1] + max_score[i - 3], max_score[i - 2]);
            }

        System.out.println(max_score[floor-1]);

    }
}
