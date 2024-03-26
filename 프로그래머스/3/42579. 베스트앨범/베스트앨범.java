import java.util.*;
class Solution {
    
    static Map<String, Integer> g = new HashMap<>();
    static Map<String, PriorityQueue<Song>> s = new HashMap<>();
    static PriorityQueue<Genre> pq = new PriorityQueue<>();
    
    public int[] solution(String[] genres, int[] plays) {
        for(int i = 0; i < genres.length; i++) {
            Integer f = g.get(genres[i]);
            if(f == null) {
                g.put(genres[i], plays[i]);
                s.put(genres[i], new PriorityQueue<>());
                s.get(genres[i]).add(new Song(i, plays[i]));
            } else {
                g.replace(genres[i], f + plays[i]);
                s.get(genres[i]).add(new Song(i, plays[i]));
            }
        }
        
        List<Integer> a = new ArrayList<>();
        for(String key: g.keySet()) {
            pq.add(new Genre(key, g.get(key)));
        }
        while(!pq.isEmpty()) {
            Genre now = pq.poll();
            
            PriorityQueue<Song> p = s.get(now.name);
            
            if(!p.isEmpty()) a.add(p.poll().num);
            if(!p.isEmpty()) a.add(p.poll().num);
        }
        
        int[] answer = new int[a.size()];
        for(int i = 0; i < a.size(); i++) {
            answer[i] = a.get(i);
        }
        return answer;
    }
    
    static class Song implements Comparable<Song> {
        int num;
        int played;

        public Song(int num, int played) {
            this.num = num;
            this.played = played;
        }

        public int compareTo(Song s) {
            if(this.played == s.played) {
                return this.num - s.num;
            } else {
                return s.played - this.played;
            }
        }
    }
    
    static class Genre implements Comparable<Genre> {
        String name;
        int played;

        public Genre(String name, int played) {
            this.name = name;
            this.played = played;
        }

        public int compareTo(Genre g) {
            return g.played - this.played;
        }
    }
}
