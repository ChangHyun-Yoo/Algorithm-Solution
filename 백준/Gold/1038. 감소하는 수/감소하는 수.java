import java.io.*;
import java.util.*;

public class Main {

    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if(N > 1022) {
            System.out.println(-1);
            return;
        }

        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < 10; i++) {
            if(i == N) {
                System.out.println(answer);
                return;
            }
            queue.add(Integer.toString(i));
            answer++;
        }

        while(!queue.isEmpty()) {
            String num = queue.poll();
            int last = Integer.parseInt(num.substring(num.length() - 1, num.length()));

            for(int i = 0; i < last; i++) {
                String newStr = num + i;
                if(answer == N) {
                    System.out.println(newStr);
                    return;
                }
                answer++;
                queue.add(newStr);
            }
        }
    }

}