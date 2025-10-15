import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] devices = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            int device = Integer.parseInt(st.nextToken());
            devices[i] = device;
        }

        Set<Integer> current = new HashSet<>();

        int answer = 0;
        for(int i = 0; i < devices.length; i++) {
            int device = devices[i];

            if(current.size() < N || current.contains(device)) {
                current.add(device);
                continue;
            }

            Map<Integer, Integer> map = new HashMap<>();
            int zero = -1;
            for(int c: current) {
                boolean exists = false;
                for(int j = i + 1; j < K; j++) {
                    // 이후에도 존재하는 경우
                    if(devices[j] == c) {
                        map.put(c, j);
                        exists = true;
                        break;
                    }
                }

                if(!exists) {
                    zero = c;
                    break;
                }
            }

            int max = -1;
            int maxCurrent = -1;
            if(zero == -1) {
                for(int key: map.keySet()) {
                    if(max < map.get(key)) {
                        max = map.get(key);
                        maxCurrent = key;
                    }
                }
                zero = maxCurrent;
            }

            current.remove(zero);
            answer++;
            current.add(device);
        }

        System.out.println(answer);
    }
}
