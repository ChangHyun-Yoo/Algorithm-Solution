import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> lst = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            String s = br.readLine();

            if(set.contains(s)) {
                lst.add(s);
            }
        }

        Collections.sort(lst);

        StringBuilder sb = new StringBuilder();
        sb.append(lst.size()).append('\n');
        for(int i = 0; i < lst.size(); i++) {
            sb.append(lst.get(i)).append('\n');
        }

        System.out.print(sb);
    }

}


