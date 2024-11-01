import java.util.*;

class Solution {

  static int result = 0;
  // static Queue<int[]> q = new LinkedList<>();

  static private int cal(int start, int end, int divide) {

    int count = 0;
    int n = end-start+1;

    count += n/divide;
    if (n%divide > 0) count++;

    return count;
  }

  public int solution(int n, int[] stations, int w) {

    int idx = 1;
    for (int s : stations) {

      if (idx < s-w) {
        result += cal(idx, s-w-1, 2*w+1);
      }

      idx = s+w+1;
    }

    if (idx <= n) {
      result += cal(idx, n, 2*w+1);
    }

//         int[] arr = new int[n];
//         int x = 0;
//         for (int station : stations) {

//             int a = (station-1)-w;
//             int b = (station-1)+w;

//             x = b-a+1;

//             if (a < 0) a = 0;
//             if (b > n-1) b = n-1;

//             q.offer(new int[]{a,b});

//             for (int i = a; i <= b; i++) {
//                 arr[i] = 1;
//             }
//         }

//         for (int i = 0; i < n; i++) {

//             if (arr[i] == 0) {

//                 if (q.isEmpty()) {
//                     result += ((n-i)/x);
//                     if ((n-i)%x > 0) result++;
//                     break;
//                 }

//                 int[] l = q.poll();

//                 if (i > l[0]) {
//                     i--;
//                     continue;
//                 }

//                 int a = l[0] - i;

//                 result += (a/x);
//                 if (a%x > 0) result++;
//                 i = l[1];
//             }
//         }

    // System.out.print(Arrays.toString(arr));

//         int count = 0;
//         for (int i = 0; i < n; i++) {

//             if (arr[i] == 0) {
//                 count++;
//             } else {

//                 if (count == 0) continue;

//                 // System.out.print(count);
//                 result += (count/x);
//                 if (count%x > 0) result++;

//                 count = 0;
//             }
//         }

//         if (count > 0) {
//             result += (count/x);
//             if (count%x > 0) result++;
//         }

    return result;
  }
}
