import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Node> nodes = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            nodes.add(new Node(start, end));
        }

        Collections.sort(nodes);

        int answer = 1;
        int end = nodes.get(0).end;

        for(int i = 1; i < nodes.size(); i++) {
            if(end <= nodes.get(i).start) {
                answer++;
                end = nodes.get(i).end;
            }
        }

        System.out.println(answer);
    }

    static class Node implements Comparable<Node> {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Node n) {
            if(this.end == n.end) {
                return this.start - n.start;
            } else
                return this.end - n.end;
        }
    }
}