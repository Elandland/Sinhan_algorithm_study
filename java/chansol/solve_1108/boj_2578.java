package chansol.solve_1108;

import java.util.*;

public class boj_2578 {

    static int[][] board = new int[5][5];
    static boolean[][] marked = new boolean[5][5];
    static int[] rowCount = new int[5];
    static int[] colCount = new int[5];
    static int diagonal1 = 0;
    static int diagonal2 = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < 25; i++) {      //25번째 까지만 부르면 됨 그럼 무조건 빙고임
            int num = scanner.nextInt();
            markNumber(num);

            int bingoCnt = 0;

            for (int j = 0; j < 5; j++) {
                if (rowCount[j] == 5){
                    bingoCnt++;
                }
                if (colCount[j] == 5){
                    bingoCnt++;
                }
            }

            if (diagonal1 == 5) {
                bingoCnt++;
            }
            if (diagonal2 == 5) {
                bingoCnt++;
            }

            if (bingoCnt >= 3) {
                System.out.println(i + 1);
                break;
            }
        }
    }

    public static void markNumber(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == num) {
                    marked[i][j] = true;
                    rowCount[i]++;
                    colCount[j]++;
                    if (i == j) {
                        diagonal1++;    //좌측 위에서 우측 아래로 대각선
                    }
                    if (i + j == 4){
                        diagonal2++;    //우측 위에서 좌측 아래로 대각선
                    }
                    return;
                }
            }
        }
    }
}

