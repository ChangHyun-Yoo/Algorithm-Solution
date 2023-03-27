import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static class TrieNode {
        Map<String, TrieNode> child = new TreeMap<>();
    }

    static class Trie {
        static TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        static void insert(String[] strs) {
            TrieNode node = root;
            for(String str: strs) {
                node = node.child.computeIfAbsent(str, key -> new TrieNode());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        for(int i = 0; i < N; i++) {
            String[] strings = br.readLine().split("\\\\");
            trie.insert(strings);
        }
        dfs(trie.root, 0);
        System.out.println(sb);
    }

    static void dfs(TrieNode node, int d) {
        for(String key: node.child.keySet()) {
            for(int i = 0; i < d; i++) {
                sb.append(" ");
            }
            sb.append(key).append('\n');
            dfs(node.child.get(key), d + 1);
        }
    }
}

