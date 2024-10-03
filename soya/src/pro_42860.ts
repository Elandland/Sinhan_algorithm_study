function solution(name) {
    let answer = 0;
    let names = name.split('');
    let lchecker = 0;
    let rchecker = 0;
    
    function changeTopdown(val){
        const a = 'A'.charCodeAt();
        const z = 'Z'.charCodeAt();
        const v = val.charCodeAt();
        answer+= Math.min( v-a, z-v+1);
    }
    let totalNeedNum = 0; //'A'가 아닌 갯수
    //알파벳별 변환
    for(let i = 0 ; i < names.length ; i++){
        //알파벳 변환하기 
        if(names[i] !=='A'){
            changeTopdown(names[i]);
            totalNeedNum++;
        }
    }
   if(names[0] !=='A'){
        names[0] = 'A';
        totalNeedNum--; // 0번 인덱스는 A갯수에서 뺀다. 시작위치므로 찾을필요가 없음 
    }
    
    let minMovedCount = names.length-1;
    
    // 좌, 우로 갔을때 최적 이동수 구하기 
    function greedy(curIdx,moveCnt){
        if(moveCnt >= minMovedCount) return;
        if(totalNeedNum === 0){
            minMovedCount = Math.min(minMovedCount,moveCnt)
            return;
        }

        let idx = curIdx;
        for(let cnt = 1 ; cnt < names.length ; cnt++){
            let rnextIdx = idx+cnt < names.length ? idx+cnt : idx+cnt-names.length;
            let lnextIdx = idx-cnt < 0 ? names.length-(cnt-idx) : idx-cnt;
            if(names[rnextIdx] ==='A' && names[lnextIdx] ==='A') continue;
            if(names[rnextIdx] !== 'A'){   
                let saved = names[rnextIdx];
                names[rnextIdx] = 'A'; // 덮어쓰기
                totalNeedNum--;
                greedy(rnextIdx,moveCnt+cnt);
                names[rnextIdx] = saved;
                totalNeedNum++;
            }
            if(names[lnextIdx]!=='A'){
                let saved = names[lnextIdx];
                names[lnextIdx] = 'A'; //덮어쓰기
                totalNeedNum--;
                greedy(lnextIdx,moveCnt+cnt);
                names[lnextIdx] = saved;
                totalNeedNum++;
            }
        }  
    }

    greedy(0,0);
    answer += minMovedCount    
    
    return answer;
}
