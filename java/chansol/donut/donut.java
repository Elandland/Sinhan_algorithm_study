package chansol.donut;

class donut{
    public int[] solution(int[][] edges) {
        int[] answer = {};
        int a,b,max=0,point=0;
        int cnt =0;

        for(int i=0; i<edges.length; i++){
            a = edges[i][0];
            b = edges[i][1];

            if(max<a){
                max=a;
            }
            if(max<b){
                max=b;
            }
        }
        int size = max;     //도대체 그래프 사이즈를 어케 구해야 될지 나는 모르겠어

        int[][] graph = new int[size+1][size+1];

        for(int i=0; i<edges.length; i++){
            a = edges[i][0];
            b = edges[i][1];

            graph[a-1][b-1]=1;  //단방향 이면 하나만 해도 되지 않나? (2차원 배열로 생각해서 각 열이랑 행 1씩 빼줘라)
        }
        max =0;
        for(int i=0; i<size; i++){
            cnt =0;
            for(int j=0; j<size; j++){
                if(graph[i][j]==1){
                    cnt++;
                }
            }
            if(max<cnt){
                max = cnt;
                point = i;      //노드의 인덱스 ex) point가 1이면 2번 노드가 정점.
            }

        }
        //max는 그래프들의 합.


        //막대인지 확인(그냥 막대)

        //8자 인지 확인(한 정점이 들어오는게 2개 나가는게 2개 나머지 1개씩)

        //도넛인지 확인(도넛. 간선 보낸 노드한테 다시 돌아옴)
        if(edge[i][j]==1&&i==j){
            donut++;
        }

        //정점이 가리키는 노드로 이동해서 3가지의 경우 검사함.


        //생성한 정점은 그래프의 갯수 만큼 간선을 보낸다.
        return answer;
    }
}

