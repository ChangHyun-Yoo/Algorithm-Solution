import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> lst = new ArrayList<>();

        for(int i = 1; i <= N; i++) {
            lst.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for(int i = K - 1; lst.size() != 0; i += K) {
            i %= lst.size();
            if(lst.size() == 1) {
                sb.append(lst.get(i));
            } else {
                sb.append(lst.get(i)).append(", ");
            }
            lst.remove(i--);
        }
        sb.append(">");
        System.out.println(sb);
    }
}