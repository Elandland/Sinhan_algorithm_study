package chansol.pro_150370;
import java.util.*;

//그냥 코드 망함

public class pro_150370 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        //split으로 . 기준으로 나눠서 년/월/일 저장하고 마지막 일 저장되있는거 다시 스페이스 기준으로 스플릿해서 나누면 될듯.
        int[] answer = {};
        int pr_length = privacies.length;
        int term_length = terms.length;

        String[] today_date = today.split("[.]");
        String[][] privacies_date = new String[pr_length][3];
        String[] privacies_type = new String[pr_length];
        String[][] term_date = new String[term_length][2];


        for(int i=0; i<pr_length; i++){
            privacies_date[i] = privacies[i].split("[` `.]");       //공백과 .으로 스플릿

        }

        for(int i=0; i<term_length; i++){
            term_date[i] = terms[i].split("[ ]");
        }

        for(int i=0; i<pr_length; i++){
            for(int j=0; j<term_length; j++){
                if(privacies_date[i][3].equals(term_date[j][0])){
                    privacies_date[i][0]+= Integer.parseInt(term_date[j][1])/12;      //년을 더함
                    privacies_date[i][1]+= Integer.parseInt(term_date[j][1])%12;      //월을 더함
                }
            }
        }

        for(int i=0; i<pr_length; i++){
            if(Integer.parseInt(privacies_date[i][0])<Integer.parseInt(today_date[0])
                    ||(privacies_date[i][0].equals(today_date[0])&&Integer.parseInt(privacies_date[i][1])<Integer.parseInt(today_date[1]))
                    ||(privacies_date[i][0].equals(today_date[0])&&privacies_date[i][1].equals(today_date[1])&&Integer.parseInt(privacies_date[i][2])<Integer.parseInt(today_date[2])))
            {
                System.out.println(i);
            }
        }


        return answer;
    }
}

