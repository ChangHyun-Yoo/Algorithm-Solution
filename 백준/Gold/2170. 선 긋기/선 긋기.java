import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] info = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(info, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int answer = 0;

        int start = info[0][0];
        int end = info[0][1];

        for(int i = 1; i < N; i++) {
            if(end < info[i][0]) {
                answer += end - start;
                start = info[i][0];
                end = info[i][1];
            } else {
                end = Math.max(end, info[i][1]);
            }
        }
        answer += end - start;

        System.out.println(answer);
    }
}