import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] plates = new int[N + k - 1];

        for(int i = 0; i < N; i++) {
            plates[i] = Integer.parseInt(br.readLine());
            if(i + N < N + k - 1) {
                plates[i + N] = plates[i];
            }
        }

        int max = -1;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < k; i++) {
            if(map.get(plates[i]) == null) {
                map.put(plates[i], 1);
            } else {
                map.replace(plates[i], map.get(plates[i]) + 1);
            }
        }

        int l = 0;
        int r = k - 1;
        while(r < N + k - 1) {
            if(map.get(c) == null) {
                if(max < map.size() + 1) {
                    max = map.size() + 1;
                }
            } else {
                if(max < map.size()) {
                    max = map.size();
                }
            }

            //l에서 빼기
            if(map.get(plates[l]) > 1) {
                map.replace(plates[l], map.get(plates[l]) - 1);
            } else {
                map.remove(plates[l]);
            }
            l++;

            //r에서 추가
            r++;
            if(r == N + k - 1)
                break;
            if(map.get(plates[r]) == null) {
                map.put(plates[r], 1);
            } else {
                map.replace(plates[r], map.get(plates[r]) + 1);
            }
        }
        System.out.println(max);
    }
}
