class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        int move = length - 1; // 좌우 움직임 수를 체크

        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            int index = i + 1;
            // 연속되는 A 갯수 확인
            while (index < length && name.charAt(index) == 'A') {
                index++;
            }

            // 순서대로 가는 것과, 뒤로 돌아가는 것 중 이동수가 적은 것을 선택
            // 그냥 처음 move만큼 가는 것과, 처음으로 돌아가서 커서를 왼쪽으로 이동하여
            // A 뒤에 있는 내용을 탐색하는 경우를 계산하기 위함
            move = Math.min(move, i * 2 + length - index);

            // 뒤로 돌아가는 것, 뒤로 갔다가 다시 앞으로 오기 때문에 *2,
            // +i를 해주는 이유는 일단 index가 A인 구간을 만나서 계산이 들어가기 때문
            move = Math.min(move, (length - index) * 2 + i);
        }

        return answer + move;
    }
}