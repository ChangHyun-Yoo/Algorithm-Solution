import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<int[]> info = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] lst = new int[2];
            lst[0] = Integer.parseInt(st.nextToken());
            lst[1] = Integer.parseInt(st.nextToken());
            info.add(lst);
        }

        Collections.sort(info, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        int min = -1;
        int answer = 0;
        for(int[] i: info) {
            if(i[0] < min) {
                continue;
            } else {
                answer++;
                min = i[1];
            }
        }
        System.out.println(answer);

    }
}