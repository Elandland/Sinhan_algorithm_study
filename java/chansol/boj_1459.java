package chansol;
import java.util.*;

public class boj_1459 {
    //그리디 근데 왜 이게 그리디지..?
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();       //x좌표
        int Y = sc.nextInt();       //y좌표
        int W = sc.nextInt();       //한개
        int S = sc.nextInt();       //대각선

        long ans =0;
        long real_ans = 0;
        long sol3=0;

        int diagonal = Math.min(X,Y);
        long sol1 = (long)diagonal*S + (long)(Math.max(X,Y) - diagonal)*W;       //대각선으로 최대한 이동하고 그냥이동. -> 이게 대각선+직선 이동인데 이동과정에서 대각선을 싹 다 앞으로 땡겨서 이동하는 느낌

        long sol2 = (long)(X+Y)*W;         //전부 그냥 이동      ->직선 이동만

        if((X+Y)%2==0){     //대각선으로만 이동. // ->그럼 당연히 남은 경우는 대각선 이동만.
            sol3 = (long)Math.max(X,Y)*S;
        }
        else{
            sol3 = (long)(Math.max(X,Y)-1)*S+W;
        }

        ans = Math.min(sol1,sol2);
//        System.out.println(sol1);
//        System.out.println(sol2);
//        System.out.println(sol3);
        real_ans = Math.min(ans,sol3);

        System.out.println(real_ans);

        //예제입력 6에서 오류 => overflow난듯
    }
}
