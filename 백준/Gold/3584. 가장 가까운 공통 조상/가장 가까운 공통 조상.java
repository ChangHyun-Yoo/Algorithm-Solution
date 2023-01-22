import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static int max = -1;
    public static int maxNode = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();
            for(int j = 0; j < n - 1; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                map.put(child, parent);
            }

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            List<Integer> l1 =  new ArrayList<>();
            l1.add(num1);
            while(true) {
                if(map.get(num1) == null) {
                    break;
                } else {
                    num1 = map.get(num1);
                    l1.add(num1);
                }
            }

            while(true) {
                if(l1.contains(num2)) {
                    System.out.println(num2);
                    break;
                } else {
                    num2 = map.get(num2);
                }
            }

        }


    }
}
