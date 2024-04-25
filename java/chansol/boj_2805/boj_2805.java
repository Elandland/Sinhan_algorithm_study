package chansol.boj_2805;
import java.util.*;


public class boj_2805 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        long cut_tree;

        int [] tree = new int [N];

        for(int i=0; i<N; i++){
            tree[i] = sc.nextInt();
        }
        Arrays.sort(tree);

        int min = 0;      //
        int max = tree[N-1];

        while (min <max){           //두개 같아질때가 답. 마지막에 min= mid+1하고 나오니까 min= max+1 , min=max일때가 답이니까 출력할 때 1빼라
            cut_tree = 0;

            int mid = (min+max)/2;
            for(int i=0; i<N; i++){
                if(tree[i]>mid) {
                    cut_tree += (tree[i] - mid);
                }
            }

            if(cut_tree<M){           //더 낮은 높이에서 잘라야함.
                max = mid;
            }
            else {          //잘리면 min을 높여서 좀 더 높게 자름(낭비가 없도록)
                min = mid + 1;
            }
        }
        System.out.println(min-1);

    }
}
