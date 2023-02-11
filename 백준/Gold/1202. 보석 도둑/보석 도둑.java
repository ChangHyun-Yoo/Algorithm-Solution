import java.io.*;
import java.util.*;

public class Main {

    static class Jewel implements Comparable<Jewel> {
        int M;
        int V;

        public Jewel(int m, int v) {
            M = m;
            V = v;
        }

        @Override
        public int compareTo(Jewel j) {
            if(this.M == j.M) {
                return this.V - j.V;
            } else {
                return this.M - j.M;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Jewel> jewels = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            jewels.add(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(jewels);

        List<Integer> bag = new ArrayList<>();
        for(int i = 0; i < K; i++) {
            bag.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(bag);

        PriorityQueue<Integer> info = new PriorityQueue<>(Collections.reverseOrder());

        long answer = 0;
        for(int i = 0, j = 0; i < bag.size(); i++) {
            while(j < N && jewels.get(j).M <= bag.get(i)) {
                info.offer(jewels.get(j).V);
                j++;
            }

            if(!info.isEmpty())
                answer += info.poll();
        }
        System.out.println(answer);
    }
}