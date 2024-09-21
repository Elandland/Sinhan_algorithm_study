package chansol;

import java.util.*;

public class pro_154538 {

    class Solution {
        int answer =0;
        class Count{
            int num;
            int count;

            Count(int num,int count){
                this.num = num;
                this.count = count;
            }
        }

        public int solution(int x, int y, int n) {
            Queue<Count> queue = new LinkedList<>();

            boolean[] visited = new boolean[y + 1];     //시간 초과 방지용 , 미리 체크한 거는 체크 안하게

            queue.add(new Count(x,0));
            visited[x] = true;

            while (!queue.isEmpty()) {
                Count cnt = queue.poll();

                if (cnt.num == y) {
                    answer = cnt.count;
                    return answer ;
                }

                if (cnt.num + n <= y&&!visited[cnt.num + n]) {
                    queue.add(new Count(cnt.num+n,cnt.count+1));
                    visited[cnt.num + n] = true;
                }
                if (cnt.num * 2 <= y&&!visited[cnt.num *2]) {
                    queue.add(new Count(cnt.num*2,cnt.count+1));
                    visited[cnt.num *2] = true;
                }
                if (cnt.num * 3 <= y&&!visited[cnt.num *3]) {
                    queue.add(new Count(cnt.num * 3, cnt.count + 1));
                    visited[cnt.num *3] = true;
                }

            }
            return -1;
        }
    }
}
