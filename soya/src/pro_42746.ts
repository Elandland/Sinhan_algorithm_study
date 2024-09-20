function solution(numbers) {
    
    // 앞자리가 가장 큰 수로 정렬 
    numbers.sort((a,b)=>{
        let aArr =(""+a).split("");
        let bArr = (""+b).split("");
        let len = aArr.length > bArr.length ? bArr.length : aArr.length;
        let bigger = aArr.length > bArr.length ?  aArr : bArr;
        let i = 0;
        for(; i < len ; i++){
            if(bArr[i] == aArr[i]) continue;
            if(bArr[i] > aArr[i]) return 1;
            return bArr[i] - aArr[i];     
        }
        //긴쪽에 남은수가 맨왼쪽자리수보다 작으면 뒤로, 크면 앞으로, 같으면 뒤에꺼로 체크 
        let first = +aArr[0];
        console.log("first:",first)
        for(; i < bigger.length ; i++){
             if(bigger[i] == first) continue;
            console.log("why : ", +bigger[i] - first, "bigger[i] =", bigger[i])
             if(+bigger[i] > +first) return -1;
        }
        console.log("i:",i,", bigger[i]= ", bigger[i-1])
        return 1;
    })
    console.log(numbers)
    // 합체 
    let answer = numbers.join('');
    return answer;
}
