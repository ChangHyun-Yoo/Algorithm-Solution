import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb;

    static class TrieNode {
        Map<String, TrieNode> child = new TreeMap<>();
        int d;
    }

    static class Trie {
        static TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        static void insert(String[] strs) {
            TrieNode node = root;
            for(String s: strs) {
                node = node.child.computeIfAbsent(s, key -> new TrieNode());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            String[] strs = new String[n];
            for(int j = 0; j < n; j++) {
                strs[j] = st.nextToken();
            }
            trie.insert(strs);
        }
        sb = new StringBuilder();
        dfs(trie.root, 0);
        System.out.println(sb);
    }

    static void dfs(TrieNode trieNode, int d) {
        for(String key: trieNode.child.keySet()) {
            for(int i = 0; i < d; i++) {
                sb.append("-");
            }
            sb.append(key).append('\n');
            dfs(trieNode.child.get(key), d + 2);
        }
    }
}

