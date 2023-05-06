import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> roads = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N + 1; i++) {
            roads.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            roads.get(a).add(b);
            roads.get(b).add(a);
        }

        int q = Integer.parseInt(br.readLine());
        for(int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int t = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if(t == 1) {
                if(roads.get(k).size() >= 2) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            } else {
                System.out.println("yes");
            }
        }
    }
}