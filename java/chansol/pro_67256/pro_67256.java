package chansol.pro_67256;

class pro_67256 {
    public String pro_67256(int[] numbers, String hand) {
        String answer = "";
        int num_len = numbers.length;
        int loc = 0;
        int L=0;
        int R=0;
        int lefthand = 10;
        int righthand = 12;

        for(int i=0; i<num_len; i++){
            if(numbers[i]==1 || numbers[i]==4 || numbers[i]==7){
                answer+= "L";
                lefthand = numbers[i];
            }
            else if(numbers[i] ==3 || numbers[i]==6 || numbers[i] == 9){
                righthand  = numbers[i];
                answer += "R";

            }
            else {
                // lefthand를 3으로 나눈후 몫 : 몇번째 행인가
                // righthand를 3으로 나눈후 몫-1 : 몇번째 행인가 (4로 나누던 2로나누던 그냥 알아서 정하기만 하면 될듯)
                // numbers[i] 도 3으로 나눈 몫이 몇번째 행인가. 근데 여기서 0은 특별 case로 두던가 나머지도 0이던가 로 처리해야될 듯
                loc = numbers[i]/3;
                if(numbers[i] ==0){
                    loc = 3;
                }

                if(lefthand%3==1){
                    L = Math.abs(loc-(lefthand/3))+1; //왼손으로 부터의 거리
                }
                else{
                    L = Math.abs(loc-(lefthand/3));
                }

                if(righthand%3==0){
                    R = Math.abs(loc-((righthand/3)-1))+1;  //오른손으로 부터의 거리
                }
                else{
                    R = Math.abs(loc-(righthand/3));
                }

                if(L>R){
                    if(numbers[i]!=0)
                        righthand = numbers[i];
                    else
                        righthand = 11;
                    answer+="R";
                }
                else if (L<R){
                    if(numbers[i]!=0)
                        lefthand = numbers[i];
                    else
                        lefthand = 11;
                    answer+="L";

                }
                else {
                    if(hand.equals("left")){
                        if(numbers[i]!=0)
                            lefthand = numbers[i];
                        else
                            lefthand = 11;
                        answer+="L";

                    }
                    else{
                        if(numbers[i]!=0)
                            righthand = numbers[i];
                        else
                            righthand = 11;
                        answer+="R";
                    }
                }
            }
        }

        return answer;
    }
}
