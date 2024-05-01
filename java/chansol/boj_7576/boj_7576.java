package chansol.boj_7576;
import java.util.*;

public class boj_7576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();   // 상자의 가로 칸 수
        int N = sc.nextInt();   // 상자의 세로 칸 수

        int[][] tomato = new int[M][N];

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                tomato[i][j] = sc.nextInt();
            }
        }

        //bfs
        // tomato[][] ==1인 애부터 시작해서. 전후좌우 배열 검사. -1이면 검사 끝. 0인애들만 검사하도록 해서 visit한게 M*N - (-1이 있는 갯수) 가 다 되도록.



    }


}
