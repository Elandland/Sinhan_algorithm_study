function solution(n)
{
    let ans = 0;
    
    while(n !== 0){
        if(n%2 === 1){
            n = n-1;
            ans++;
        }
        n = n/2;
    }
    
    return ans;
}
