import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Trie trie = new Trie();
        TrieNode root = trie.root;

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int n = 0; n < N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int K = Integer.parseInt(st.nextToken());

            TrieNode current = root;
            for(int k = 0; k < K; k++) {
                String input = st.nextToken();

                if(!current.next.containsKey(input)) {
                    current.next.put(input, new TrieNode(input));
                }

                current = current.next.get(input);
            }
        }

        for(String key: root.next.keySet()) {
            dfs(root.next.get(key), 0, sb);
        }

        System.out.print(sb.toString());
    }

    static void dfs(TrieNode current, int floor, StringBuilder sb) {
        for(int f = 0; f < floor; f++) {
            sb.append("--");
        }
        sb.append(current.s).append('\n');

        for(String key: current.next.keySet()) {
            dfs(current.next.get(key), floor + 1, sb);
        }
    }

    static class TrieNode {
        String s;
        TreeMap<String, TrieNode> next;

        public TrieNode(String s) {
            this.s = s;
            next = new TreeMap<>();
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode("root");
        }
    }
}
