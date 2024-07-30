import java.util.*;
import java.util.Map.Entry;

class Solution {

  static class Song {

    int id;
    int play;

    public Song(int id, int play) {
      this.id = id;
      this.play = play;
    }

    public int getPlay() {
      return play;
    }
  }

  static Map<String, List<Song>> song = new HashMap<>();
  static Map<String, Integer> totalPlay = new HashMap<>();

  public int[] solution(String[] genres, int[] plays) {

    List<Integer> answer = new ArrayList<>();

    for (int i = 0; i < genres.length; i++) {

      if (!song.containsKey(genres[i])) {
        song.put(genres[i], new ArrayList<>());
      }
      song.get(genres[i]).add(new Song(i, plays[i]));

      totalPlay.put(genres[i], totalPlay.getOrDefault(genres[i], 0) + plays[i]);
    }

    // 맵을 value 값 기준으로 정렬을 할 수가 없다...
    // 리스트로 감싸주었으니까 sort 를 할 수 있겠지?
    // 어케 하냐 이거 ㅋㅋㅋㅋㅋ
    // 맵을 리스트로 변환하고 value 값으로 정렬하라고 챗GPT가 말해줌
    List<Entry<String, Integer>> entryList = new ArrayList<>(totalPlay.entrySet());

    // value 값으로 내림차순 정렬
    entryList.sort((o1, o2) ->
        o2.getValue().compareTo(o1.getValue()));

//    System.out.println("entry: " + entryList);

    // song의 value인 Song 클래스 데이터를 play값 기준으로 정렬
    song.forEach((key, value) -> value.sort((Comparator.comparingInt(Song::getPlay).reversed())));

//    song.forEach((key, value) ->{
//      for (Song item : value) {
//        System.out.println(item.id + " : " + item.play);
//      }
//    });

    for (Entry<String, Integer> entry : entryList) {
      String genre = entry.getKey();

      List<Song> getSong = song.get(genre);

      for (int i = 0; i < getSong.size(); i++) {
        if (i > 1) {
          break;
        }

        answer.add(getSong.get(i).id);
      }
    }

//    System.out.println(answer);

    return answer.stream().mapToInt(Integer::intValue).toArray();
  }
}
