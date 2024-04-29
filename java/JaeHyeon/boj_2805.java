import java.io.*;

public class boj_2805 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");

    int k = Integer.parseInt(input[0]);
    int n = Integer.parseInt(input[1]);

    String[] t = br.readLine().split(" ");

    int[] trees = new int[k];
    int max = 0;
    int min = 0;
    for (int i = 0; i < k; i++) {
      trees[i] = Integer.parseInt(t[i]);
      if (max < trees[i])
        max = trees[i];
    }

    while (min < max) {
      int mid = (min + max) / 2;
      long count = 0;

      for (int i = 0; i < k; i++) {
        if (trees[i] < mid)
          continue;

        count += (trees[i] - mid);
      }

      if (count < n)
        max = mid;
      else
        min = mid + 1;
    }

    bw.write(String.valueOf(min-1));
    bw.flush();
    bw.close();
  }
}
