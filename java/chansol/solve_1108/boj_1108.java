package chansol.solve_1108;
import java.io.*;

public class boj_1108 {

    public class Main {
        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));

            int X = Integer.parseInt(br.readLine());
            int tmp_sum =0,cat=0,i,deno,nume;

            for(i=0; i<10000; i++){
                tmp_sum +=i;
                if(X<=tmp_sum){
                    cat=i+1;        //cat = 분모값(deno)+분자(nume)값
                    break;
                }
            }

            int tmp = tmp_sum-X;

            if(i%2==0){     //i가 짝수 (오른쪽->왼쪽) 분모값이 점점 작아지고 분자값이 점점 커짐.

                deno = tmp+1;
                nume = cat-deno;

            }
            else{           //i가 홀수 (왼쪽 -> 오른쪽) 분모값이 점점 커지고 분자값이 점점 작아짐.

                nume = tmp+1;
                deno = cat-nume;

            }

            String str1 = Integer.toString(nume);
            String str2 = Integer.toString(deno);

            String ans = str1+"/"+deno;

            wr.write(ans);
            wr.flush();
            wr.close();
        }
    }
}
