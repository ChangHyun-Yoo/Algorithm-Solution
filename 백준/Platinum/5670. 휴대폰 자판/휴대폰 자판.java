import java.io.*;
import java.util.*;

public class Main {

    static int count;

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String s) {
            TrieNode node = this.root;

            for(int i = 0; i < s.length(); i++) {
                node = node.child.computeIfAbsent(s.charAt(i), key -> new TrieNode());
            }

            node.isLast = true;
        }
    }

    static class TrieNode {
        Map<Character, TrieNode> child;
        boolean isLast;

        public TrieNode() {
            child = new HashMap<>();
            isLast = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String s = null;
        while((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);

            count = 0;
            Trie trie = new Trie();

            for(int i = 0; i < n; i++) {
                trie.insert(br.readLine());
            }

            dfs(trie.root, 0);

            sb.append(String.format("%.2f", count / (double) n)).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(TrieNode now, int t) {
        if(t == 0) {//하나도 입력되지 않은 경우
            for(Character c: now.child.keySet()) {
                dfs(now.child.get(c), t + 1);
            }
            return;
        }

        if(now.isLast) {
            count += t;
        }

        if(now.child.size() == 0) {
            return;
        } else if(now.child.size() == 1) {
            for(Character c: now.child.keySet()) {
                if(now.isLast) {
                    dfs(now.child.get(c), t + 1);
                } else {
                    dfs(now.child.get(c), t);
                }
            }
        } else {
            for(Character c: now.child.keySet()) {
                dfs(now.child.get(c), t + 1);
            }
        }
    }
}