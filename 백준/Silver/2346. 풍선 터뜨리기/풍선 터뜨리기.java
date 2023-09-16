import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Balloon> lst = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            lst.add(new Balloon(i + 1, Integer.parseInt(st.nextToken())));
        }

        StringBuilder sb = new StringBuilder();

        int current = 0;
        while(lst.size() != 1) {
            sb.append(lst.get(current).num + " ");
            int paper = lst.get(current).p;
            lst.remove(current);

            if(paper < 0) {
                current += paper;
            } else {
                current += paper - 1;
            }

            current %= lst.size();
            if(current < 0) current += lst.size();
        }
        sb.append(lst.get(0).num);
        System.out.println(sb);
    }

    static class Balloon {
        int num;
        int p;

        public Balloon(int num, int p) {
            this.num = num;
            this.p = p;
        }
    }
}