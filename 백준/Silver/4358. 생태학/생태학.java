import java.io.*;
import java.util.*;

public class Main {

    static class TrieNode {
        Map<Character, TrieNode> childNode;
        int num;

        public TrieNode() {
            childNode = new HashMap<>();
            num = 0;
        }
    }

    static class Trie {

        static TrieNode root = new TrieNode();

        static void insert(String s) {
            TrieNode node = root;

            for(int i = 0; i < s.length(); i++) {
                node = node.childNode.computeIfAbsent(s.charAt(i), key -> new TrieNode());
            }
            node.num++;
        }

        static int find(String s) {
            TrieNode node = root;

            for(int i = 0; i < s.length(); i++) {
                node = node.childNode.getOrDefault(s.charAt(i), null);
                if(node == null) return 0;
            }
            if(node == null) return 0;
            else return node.num;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int words = 0;
        Set<String> set = new TreeSet<>();
        Trie trie = new Trie();
        while(sc.hasNext()) {
            String s = sc.nextLine();
            trie.insert(s);
            set.add(s);
            words++;
        }
        for(String s: set) {
            System.out.println(s + " " + String.format("%.4f",  (double) trie.find(s) * 100.0 / words));
        }
    }
}