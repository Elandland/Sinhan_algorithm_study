package chansol.donut;

import java.util.ArrayList;

class donut {

    static ArrayList<Integer>[] graph;      //interger를 인자로 갖는 arraylist를 인자로 갖는 graph 배열
    static ArrayList<Integer>[] graph_rev;

    public int[] solution(int[][] edges) {

        int[] answer = new int[4];
        int a, b, max = 0, point = 0;
        int stick=0;
        int eight =0;
        int donut =0;

        for (int i = 0; i < edges.length; i++) {
            a = edges[i][0];
            b = edges[i][1];

            max = Math.max(max,a);
            max = Math.max(max,b);

        }
        int size = max;     //도대체 그래프 사이즈를 어케 구해야 될지 나는 모르겠어

        graph =  new ArrayList[size+1];     //그래서 그래프는 size+1의 배열
        graph_rev =  new ArrayList[size+1];

        for(int i=0; i<size+1; i++){
            graph[i] = new ArrayList<>();     //배열 안의 인자를 Arraylist로
            graph_rev[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            a = edges[i][0];
            b = edges[i][1];

            graph[a].add(b);            //해당 노드에서 간선뻗은 애들을 인자값으로 가짐.    a번 노드에서 b번 노드로 간다.
            graph_rev[b].add(a);        //얘는 b번 노드에 a노드가 들어온다.
        }

        for(int i=0; i< size+1; i++){           //1번 노드의 인덱스는 0이 아니라 1임

            //막대인지 확인(그냥 막대)    //그래프를 구성하는 노드 중 들어오는 간선이 있고, 나가는건 없는 노드가 있을 때
            if(graph_rev[i].size()!=0&&graph[i].size()==0){
                stick++;
            }

            //8자 인지 확인 ,그래프를 구성하는 노드 중 들어오는 게 2개이상&&나가는게 2개인 노드가 있을때
            if(graph_rev[i].size()>=2&&graph[i].size()==2){
                eight++;
            }

            //정점은 들어오는 간선 없는 애로 잡는게 나을 듯 나가는 애는 있음.
            // if(graph_rev[i].size()==0&&graph[i].size()!=0) 이렇게 포인트를 구하니까 1번째에서 4번도 들어오는게 없는데 나가는게 있어서 정점으로 판정됨.
            //그래서 제한사항에서 그래프들의 합이 2이상이라고 했구나. graph[i].size()>=2로 하려고
            if(graph_rev[i].size()==0&&graph[i].size()>=2){
                point = i;
            }

            //도넛인지 확인(도넛. 간선 보낸 노드한테 다시 돌아옴)    도넛은 구하기 힘드니까 그냥 정점에서 나가는 간선 갯수에서 나머지 그래프 빼라. (어케 구함 이거?)
            //생성한 정점은 그래프의 갯수 만큼 간선을 보낸다.
            donut = graph[point].size() - eight - stick;


        }
        answer[0] = point;
        answer[1] = donut;
        answer[2] = stick;
        answer[3] = eight;

        return answer;
    }

}

