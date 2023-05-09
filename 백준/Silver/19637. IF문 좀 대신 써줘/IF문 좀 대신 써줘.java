import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, String> map = new HashMap<>();
        List<Integer> lst = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String nickname = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(!set.contains(num)) {
                set.add(num);
                lst.add(num);
                map.put(num, nickname);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int n = Integer.parseInt(br.readLine());

            int low = 0;
            int high = lst.size();

            while(low < high) {
                int mid = low + (high - low) / 2;

                if(lst.get(mid) <= n) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            if(map.get(n) != null) {
                sb.append(map.get(lst.get(low - 1))).append('\n');
            } else {
                sb.append(map.get(lst.get(low))).append('\n');
            }
        }
        System.out.println(sb);

    }
}