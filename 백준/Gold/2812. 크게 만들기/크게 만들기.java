import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] chs = br.readLine().toCharArray();

        Deque<Character> deque = new ArrayDeque<>();

        for(int i = 0; i < chs.length; i++) {

            while(K > 0 && !deque.isEmpty() && deque.peekLast() < chs[i]) {
                deque.removeLast();
                K--;
            }
            deque.addLast(chs[i]);
        }

        StringBuilder sb = new StringBuilder();

        while(deque.size() > K) {
            sb.append(deque.pollFirst());
        }

        System.out.print(sb.toString());
    }
}
