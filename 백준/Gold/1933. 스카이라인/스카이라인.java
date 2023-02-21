import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] info = new int[2 * N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            info[i][0] = L;
            info[i][1] = H;
            info[i + N][0] = R;
            info[i + N][1] = -H;
        }

        Arrays.sort(info, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int point;
        int max = -1;
        for(int i = 0; i < info.length; i++) {
            point = info[i][0];
            while(info[i][0] == point) {
                if(info[i][1] > 0) {
                    pq.offer(info[i][1]);
                } else {
                    pq.remove(-info[i][1]);
                }
                i++;
                if(i == info.length)
                    break;
            }

            if(!pq.isEmpty()) {
                if(max != pq.peek()) {
                    max = pq.peek();
                    sb.append(point + " ").append(max + " ");
                }
            } else {
                sb.append(point + " ").append(0 + " ");
            }
            i--;
        }

        System.out.println(sb);
    }
}
