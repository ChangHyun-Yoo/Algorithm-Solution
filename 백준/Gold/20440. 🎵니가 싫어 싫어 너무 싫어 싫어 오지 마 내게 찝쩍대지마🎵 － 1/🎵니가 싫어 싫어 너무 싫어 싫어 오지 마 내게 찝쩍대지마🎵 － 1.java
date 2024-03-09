import java.util.*;
import java.io.*;

public class Main {

    static TreeMap<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(!map.containsKey(start)) {
                map.put(start, 1);
            } else {
                map.replace(start, map.get(start) + 1);
            }
            if(!map.containsKey(end)) {
                map.put(end, -1);
            } else {
                map.replace(end, map.get(end) - 1);
            }
        }
        
        int start = -1;
        int end = -1;
        int max = -1;
        int current = 0;

        for(int key: map.keySet()) {
            if(map.get(key) == 0) continue;

            current += map.get(key);
            if(max < current) {
                max = current;
                start = key;
            }
        }

        for(int key: map.keySet()) {
            if(key > start && map.get(key) < 0) {
                end = key;
                break;
            }
        }

        System.out.println(max);
        System.out.println(start + " " + end);
    }

}