import java.io.*;
import java.util.*;

public class Main {

    static class TrieNode {
        Map<Character, TrieNode> child = new HashMap<>();
        boolean isLast;
    }

    static class Trie {
        static TrieNode root = new TrieNode();

        public Trie() {
            this.root = new TrieNode();
        };

        static void insert(String s) {
            TrieNode node = root;
            for(int i = 0; i < s.length(); i++) {
                node = node.child.computeIfAbsent(s.charAt(i), key -> new TrieNode());
            }
            node.isLast = true;
        }

        static boolean search(String s) {
            TrieNode node = root;
            for(int i = 0; i < s.length(); i++) {
                node = node.child.getOrDefault(s.charAt(i), null);
                if(node == null) return false;
            }

            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            List<String> strs = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                strs.add(br.readLine());
            }
            Collections.sort(strs, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o2.length() - o1.length();
                }
            });

            Trie trie = new Trie();
            boolean yes = true;
            for(String s: strs) {
                if(trie.search(s)) {
                    sb.append("NO").append('\n');
                    yes = false;
                    break;
                } else {
                    trie.insert(s);
                }
            }
            if(yes) sb.append("YES").append('\n');
        }
        System.out.println(sb);
    }
}

