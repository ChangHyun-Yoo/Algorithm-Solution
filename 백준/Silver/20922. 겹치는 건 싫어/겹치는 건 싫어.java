import java.io.*;
import java.util.*;

public class Main {

    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] num = new int[N];
        int answer = -1;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        map.put(num[0], 1);
        answer = 1;
        int l = 0;
        int r = 0;

        while(r < N) {
            if(map.get(num[r]) <= K) {
                answer = Math.max(answer, r - l + 1);
                r++;
                if(r == N) break;
                insert(num[r]);
                continue;
            } else {
                while(map.get(num[r]) > K) {
                    remove(num[l]);
                    l++;
                }
                continue;
            }
        }
        System.out.println(answer);
    }

    static void remove(int i) {
        map.replace(i, map.get(i) - 1);
    }

    static void insert(int i) {
        if(map.get(i) == null) map.put(i, 1);
        else map.replace(i, map.get(i) + 1);
    }
}