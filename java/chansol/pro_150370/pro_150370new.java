package chansol.pro_150370;

public class pro_150370new {
    public int[] solution(String today, String[] terms, String[] privacies) {
        //split으로 . 기준으로 나눠서 년/월/일 저장하고 마지막 일 저장되있는거 다시 스페이스 기준으로 스플릿해서 나누면 될듯.
        int pr_length = privacies.length;
        int term_length = terms.length;

        String[] today_dateS = today.split("[.]");
        int today_date =0;

        String[][] privacies_dateS = new String[pr_length][4];
        int[] privacies_date = new int[pr_length];
        String[][] term_date = new String[term_length][2];
        int cnt=0;

        today_date += Integer.parseInt(today_dateS[0])*12*28;
        today_date += Integer.parseInt(today_dateS[1])*28;
        today_date += Integer.parseInt(today_dateS[2]);

        for(int i=0; i<term_length; i++){
            term_date[i] = terms[i].split("[` `]");
        }


        for(int i=0; i<pr_length; i++){
            privacies_dateS[i] = privacies[i].split("[` `.]");       //공백과 .으로 스플릿


            privacies_date[i] += Integer.parseInt(privacies_dateS[i][0])*12*28;
            privacies_date[i] += Integer.parseInt(privacies_dateS[i][1])*28;
            privacies_date[i] += Integer.parseInt(privacies_dateS[i][2]);


            for(int j=0; j<term_length; j++){
                if(privacies_dateS[i][3].equals(term_date[j][0])){
                    privacies_date[i] += Integer.parseInt(term_date[j][1])*28;

                }
            }

            privacies_date[i] -= today_date;




            if(privacies_date[i]<=0){
                cnt++;
            }
        }

        int[] answer = new int [cnt];
        int idx=0;
        for(int i=0; i<pr_length; i++){
            if(privacies_date[i]<=0){
                answer[idx] = i+1;
                idx++;
                continue;
            }

        }

        return answer;
    }
}