import java.io.*;
import java.util.*;

public class boj_2578 {

    static int[][] board = new int[5][5];
    static boolean[][] correct = new boolean[5][5];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 5; i++) {
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < 5; i++) {
            int[] numbers = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            for (int r = 0; r < 5; r++) {
                markNumber(numbers[r]);
                boolean check = checkBingo();

                if (check) {
                    bw.write(String.valueOf(i * 5 + (r + 1)));
                    bw.flush();
                    bw.close();
                    return;
                }
            }
        }
    }

    static void markNumber(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == num) {
                    correct[i][j] = true;
                    return;
                }
            }
        }
    }

    static boolean checkBingo() {
        int count = 0;

        for (int i = 0; i < 5; i++) {
            if (isRowBingo(i)) count++;
        }

        for (int i = 0; i < 5; i++) {
            if (isColBingo(i)) count++;
        }

        count += countDiagonalBingo();

        return count >= 3;
    }

    static boolean isRowBingo(int row) {
        for (int i = 0; i < 5; i++) {
            if (!correct[row][i]) return false;
        }
        return true;
    }

    static boolean isColBingo(int col) {
        for (int i = 0; i < 5; i++) {
            if (!correct[i][col]) return false;
        }
        return true;
    }

    static int countDiagonalBingo() {
        int diagCount = 0;

        boolean diag1 = true;
        for (int i = 0; i < 5; i++) {
            if (!correct[i][i]) {
                diag1 = false;
                break;
            }
        }
        if (diag1) diagCount++;

        boolean diag2 = true;
        for (int i = 0; i < 5; i++) {
            if (!correct[i][4 - i]) {
                diag2 = false;
                break;
            }
        }
        if (diag2) diagCount++;

        return diagCount;
    }
}
