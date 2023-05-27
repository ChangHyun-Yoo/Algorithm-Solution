import java.io.*;
import java.util.*;

public class Main {

    static class TrieNode {
        Map<Character, TrieNode> child;
        boolean isLast;

        public TrieNode() {
            child = new HashMap<>();
            isLast = false;
        }
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert() {
            TrieNode node = root;

            for(int i = 0; i < chs.size(); i++) {
                node = node.child.computeIfAbsent(chs.get(i), key -> new TrieNode());
            }

            node.isLast = true;
        }

        public boolean isExist(String s) {
            TrieNode node = root;

            for(int i = 0; i < s.length(); i++) {
                node = node.child.getOrDefault(s.charAt(i), null);

                if(node == null) return false;
            }

            if(node == null) return false;
            return node.isLast;
        }
    }

    static Trie trie;
    static char[][] chars;
    static boolean[][] visited;
    static List<Character> chs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int w = Integer.parseInt(br.readLine());
        String[] strs = new String[w];
        for(int i = 0; i < w; i++) {
            strs[i] = br.readLine();
        }
        br.readLine();
        int b = Integer.parseInt(br.readLine());

        chars = new char[4][4];
        visited = new boolean[4][4];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < b; i++) {
            for(int j = 0; j < 4; j++) {
                String s = br.readLine();
                for(int k = 0; k < 4; k++) {
                    chars[j][k] = s.charAt(k);
                }
            }

            trie = new Trie();
            chs.clear();

            for(int j = 0; j < 4; j++) {
                for(int k = 0; k < 4; k++) {
                    dfs(j, k, 1);
                }
            }

            int maxScore = 0;
            PriorityQueue<String> longest = new PriorityQueue<>();
            int maxLength = 0;
            int num = 0;

            for(String s: strs) {
                if(trie.isExist(s)) {
                    if(maxLength < s.length()) {
                        longest.clear();
                        longest.offer(s);
                        maxLength = s.length();
                    } else if(maxLength == s.length()) {
                        longest.offer(s);
                    }
                    num++;
                    if(s.length() == 3 || s.length() == 4) maxScore += 1;
                    else if(s.length() == 5) maxScore += 2;
                    else if(s.length() == 6) maxScore += 3;
                    else if(s.length() == 7) maxScore += 5;
                    else if(s.length() == 8) maxScore += 11;
                }
            }

            sb.append(maxScore + " " + longest.peek() + " " + num).append('\n');
            if(i != b - 1) {
                br.readLine();
            }
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y, int length) {
        if(x >= 0 && x < 4 && y >= 0 && y < 4) {
            if(length >= 1 && length <= 8 && !visited[x][y]) {
                visited[x][y] = true;
                chs.add(chars[x][y]);
                trie.insert();

                dfs(x - 1, y, length + 1);
                dfs(x - 1, y - 1, length + 1);
                dfs(x - 1, y + 1, length + 1);
                dfs(x, y - 1, length + 1);
                dfs(x, y + 1, length + 1);
                dfs(x + 1, y - 1, length + 1);
                dfs(x + 1, y, length + 1);
                dfs(x + 1, y + 1, length + 1);

                chs.remove(chs.size() - 1);
                visited[x][y] = false;
            }
            else return;
        }
    }
}