import java.io.*;
import java.util.*;

public class Main {
    public static List<List<Integer>> col = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            List<Integer> f = new ArrayList<>();
            List<Integer> s = new ArrayList<>();

            f.add(first);
            while(first != 1) {
                first /= 2;
                f.add(first);
            }
            s.add(second);
            while(second != 1) {
                second /= 2;
                s.add(second);
            }

            int answer1 = 0;
            int answer2 = 0;
            for(int ff: f) {
                if(s.contains(ff)) {
                    answer1 = ff;
                    break;
                }
            }

            for(int ss: s) {
                if(f.contains(ss)) {
                    answer2 = ss;
                    break;
                }
            }

            System.out.println(Math.max(answer1, answer2) * 10);
        }

    }

}