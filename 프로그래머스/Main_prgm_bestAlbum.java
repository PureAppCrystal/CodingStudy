package 프로그래머스;
import java.util.*;



class Song implements Comparable<Song> {

  int code;
  int play;
  String genre;

  public Song(int code, int play, String genre) {
    this.code = code;
    this.play = play;
    this.genre = genre;
  }
  
  @Override
  public int compareTo(Song o) {
      return o.play - this.play;
  }

  @Override
  public String toString() {
    // return super.toString();
    return "genre : " + this.genre + ", code : " + this.code + ", play : " + this.play;
  }
}

public class Main_prgm_bestAlbum {
    public static void main(String[] args) {

      String [] genres = 	{"classic", "pop", "classic", "classic", "pop"}; 
      int [] plays = {500, 600, 150, 800, 2500} ;
      int []result = solution(genres, plays);
      System.out.println("result : " + result);
    
    }

    
    static int[] solution(String[] genres, int[] plays) {

      ArrayList<Integer> bestAlbum = new ArrayList<>();
      ArrayList<Song> songList = new ArrayList<>();
      HashMap<String, Integer> genreMap = new HashMap<>();
      HashMap<String, Integer> albumMap = new HashMap<>();


      for(int i=0; i<genres.length; i++ ){
        // i is key
        int code = i;
        int play = plays[i];
        String genre = genres[i];

        songList.add(new Song(code, play, genre));
        if( genreMap.containsKey(genre)){
          genreMap.put(genre, genreMap.get(genre) + play);
        } else {
          genreMap.put(genre, play);
        }
      }

      Collections.sort(songList, new Comparator<Song>(){
        @Override
         public int compare(Song s1, Song s2){
             if(s1.genre.equals(s2.genre)){
                 return s1.compareTo(s2);
             } else {
                 return -(genreMap.get(s1.genre) - genreMap.get(s2.genre));
             }
         }
     });
     
     for(Song song : songList){
         if(!albumMap.containsKey(song.genre)){
             albumMap.put(song.genre, 1);
             bestAlbum.add(song.code);
         } else {
             int genreCnt = albumMap.get(song.genre);
             
             if(genreCnt >= 2) continue;
             else {
                 albumMap.put(song.genre, genreCnt + 1);
                 bestAlbum.add(song.code);
             }
         }
     }
     
     int[] answer = new int[bestAlbum.size()];
     for(int i = 0 ; i < answer.length ; ++i){
         answer[i] = bestAlbum.get(i);
     }
     
     return answer;
  }
    
}
