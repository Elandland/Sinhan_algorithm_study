package chansol.boj_2239;

import java.util.*;
public class boj_2239 {



    private static int[][] solve_sudoku(int[][] sudoku) {
        int[][] check_write = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    check_write[i][j]++;

                    // i를 0~9 까지 , j를 0에서 9까지 (한줄 판정)


                }
            }
        }
        return check_write;
    }




    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int[][] sudoku = new int[9][9];

        for(int i=0; i<9; i++){
            for(int j =0; j<9; j++){
                sudoku[i][j] = sc.nextInt();
            }
        }

        solve_sudoku(sudoku);


    }
}
