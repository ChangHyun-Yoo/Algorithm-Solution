import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Jewel> jewels = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(M, V));
        }

        Collections.sort(jewels);

        List<Integer> bags = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < K; i++) {
            int C = Integer.parseInt(br.readLine());
            bags.add(C);

            if(!map.containsKey(C)) map.put(C, new ArrayList<>());
        }

        Collections.sort(bags);

        for(Jewel jewel: jewels) {
            int low = 0;
            int high = bags.size();

            while(low < high) {
                int mid = low + (high - low) / 2;

                if(bags.get(mid) >= jewel.M) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            // low는 수용 가능한 첫 가방의 index
            if(low != bags.size()) {
                map.get(bags.get(low)).add(jewel.V);
            }
        }

        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < bags.size(); i++) {
            int bag = bags.get(i);

            if(map.get(bag) != null) {
                for(int V: map.get(bag)) {
                    pq.offer(V);
                }
            }
            map.remove(bag);

            if(!pq.isEmpty())
                answer += (long) pq.poll();
        }

        System.out.println(answer);
    }

    static class Jewel implements Comparable<Jewel> {
        int M;
        int V;

        public Jewel(int M, int V) {
            this.M = M;
            this.V = V;
        }

        public int compareTo(Jewel j) {
            return j.V - this.V;
        }
    }
}
