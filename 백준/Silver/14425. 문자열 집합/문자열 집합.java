import java.io.*;
import java.util.*;

public class Main {

    static class TrieNode {
        Map<Character, TrieNode> child = new HashMap<>();
        boolean isLast = false;
        public TrieNode() {};
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String s) {
            TrieNode node = root;
            for(int i = 0; i < s.length(); i++) {
                node = node.child.computeIfAbsent(s.charAt(i), key -> new TrieNode());
            }
            node.isLast = true;
        }

        public boolean exists(String s) {
            TrieNode node = root;
            for(int i = 0; i < s.length(); i++) {
                node = node.child.getOrDefault(s.charAt(i), null);
                if(node == null) return false;
            }
            if(node != null)
                if(node.isLast)
                    return true;
                else return false;
            else return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();
        for(int i = 0; i < N; i++) {
            trie.insert(br.readLine());
        }

        int answer = 0;
        for(int i = 0; i < M; i++) {
            String b = br.readLine();
            if(trie.exists(b)) answer++;
        }
        System.out.println(answer);
    }
}
