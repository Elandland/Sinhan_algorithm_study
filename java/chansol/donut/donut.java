package chansol.donut;

class donut{
    public int[] solution(int[][] edges) {
        int[] answer = {};
        int a,b=0;

        for(int i=0; i<edges.length; i++){
            a = edges[i][0];
            b = edges[i][1];

        }
        //막대인지 확인(그냥 막대)

        //8자 인지 확인(한 정점이 들어오는게 2개 나가는게 2개 나머지 1개씩)

        //도넛인지 확인(도넛. 간선 보낸 노드한테 다시 돌아옴)



        //생성한 정점은 그래프의 갯수 만큼 간선을 보낸다.
        return answer;
    }
}
