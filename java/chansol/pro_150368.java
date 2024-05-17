package chansol;

public class pro_150368 {
// class Solution {

// static int[] answer= new int[2];
// static int user_num;
// static int[] user_money;
// static int user_money_sum;
// static int emoticons_num;
// static int emo_plus;
// static int discount;
// static int prev_emo_plus;

//     public int[] solution(int[][] users, int[] emoticons) {
//         //이모티콘 플러스 먼저, 그 다음 판매액
//         user_num = users.length;
//         user_money = new int[user_num];
//         user_money_sum =0;
//         emoticons_num = emoticons.length;
//         emo_plus =0;
//         discount =0;
//         prev_emo_plus =0;
//         //일단 할인율 적용하면서 가입시킬 수 있는지 확인, 안되면 판매
//         //할인율 10,20,30,40 적용시키는 함수 1개 만들어야 될 듯.

//         for(int i=4; i>=1; i--){
//             for(int j=0; j<emoticons_num; j++){
//             buy_one(users,emoticons,i*10,j);
//             }

//             for(int k=0; k<user_num; k++){
//                 user_money_sum+=user_money[k];
//                 if(user_money[k]>=users[k][1]){
//                     emo_plus++;
//                     user_money_sum -=user_money[k];
//                 }
//             }
//             if(prev_emo_plus>emo_plus){

//             }
//         }

//         answer[0] = emo_plus;
//         answer[1] = user_money_sum;


//         return answer;
//     }

//     private static int[] buy_one(int[][] users, int[] emoticons,int discount, int emo_num){
//         for(int i=0; i<user_num; i++){
//             if(users[i][0]<=discount){
//                 user_money[i]+=(discount*emoticons[emo_num]/100);     //discount/100먼저 하면 걍 0됨. 귀찮음
//             }
//         }
//         return user_money;
//     }


// }

    class Solution {
        static int[] discount = {10,20,30,40};
        static int maxOfSubscribe;
        static int maxOfCost;
        public int[] solution(int[][] users, int[] emoticons) {
            findResult(0,emoticons.length, new int[emoticons.length],users,emoticons);
            return new int[]{maxOfSubscribe,maxOfCost};
        }

        public void findResult(int index,int emoticonsLength, int[] discounts,int[][] users, int[] emoticons){
            if (index == emoticonsLength){
                int subscribe = 0;
                int cost = 0;

                for (int[] user: users){
                    int userDiscountRate = user[0];
                    int userMaxCost = user[1];

                    int sum = 0;

                    for (int i = 0; i < emoticons.length; i++){
                        if (discounts[i]>=userDiscountRate){
                            sum += emoticons[i]/100*(100-discounts[i]);
                        }
                    }
                    if (sum>=userMaxCost)subscribe++;
                    else cost+=sum;
                }
                if (subscribe>maxOfSubscribe){
                    maxOfSubscribe = subscribe;
                    maxOfCost = cost;
                }else if (subscribe == maxOfSubscribe){
                    maxOfCost = Math.max(maxOfCost,cost);
                }
                return;
            }
            for (int i = 0; i < 4; i++){
                discounts[index] = discount[i];
                findResult(index+1,emoticonsLength,discounts,users,emoticons);
            }
        }
    }
}
