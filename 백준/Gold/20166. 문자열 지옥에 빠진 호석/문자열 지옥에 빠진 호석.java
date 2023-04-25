import java.io.*;
import java.util.*;

public class Main {

    static class TrieNode {
        Map<Character, TrieNode> child;
        int num;

        public TrieNode() {
            this.child = new HashMap<>();
            this.num = 0;
        }
    }

    static class Trie {

        static TrieNode root = new TrieNode();

        static void insert(List<Character> chs) {
            TrieNode node = root;

            for(int i = 0; i < chs.size(); i++) {
                node = node.child.computeIfAbsent(chs.get(i), key -> new TrieNode());
            }

            node.num++;
        }

        static int check(List<Character> chs) {
            TrieNode node = root;

            for(int i = 0; i < chs.size(); i++) {
                node = node.child.getOrDefault(chs.get(i), null);
                if(node == null) {
                    return 0;
                }
            }
            if(node == null) return 0;
            else return node.num;
        }
    }

    static List<Character> current = new ArrayList<>();
    static int N;
    static int M;
    static Trie trie;
    static char[][] lst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        lst = new char[N][M];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            for(int j = 0; j < s.length(); j++) {
                lst[i][j] = s.charAt(j);
            }
        }

        trie = new Trie();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                current.add(lst[i][j]);
                dfs(i, j, 1);
                current.remove(current.size() - 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < K; i++) {
            List<Character> chars = new ArrayList<>();
            for(char c: br.readLine().toCharArray()) {
                chars.add(c);
            }
            sb.append(trie.check(chars)).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y, int length) {
        if(length > 5) return;

        trie.insert(current);

        current.add(lst[(x + N - 1) % N][y]);
        dfs((x + N - 1) % N, y, length + 1);
        current.remove(current.size() - 1);

        current.add(lst[(x + N - 1) % N][(y + 1) % M]);
        dfs((x + N - 1) % N, (y + 1) % M, length + 1);
        current.remove(current.size() - 1);

        current.add(lst[x][(y + 1) % M]);
        dfs(x, (y + 1) % M, length + 1);
        current.remove(current.size() - 1);

        current.add(lst[(x + 1) % N][(y + 1) % M]);
        dfs((x + 1) % N, (y + 1) % M, length + 1);
        current.remove(current.size() - 1);

        current.add(lst[(x + 1) % N][y]);
        dfs((x + 1) % N, y, length + 1);
        current.remove(current.size() - 1);

        current.add(lst[(x + 1) % N][(y + M - 1) % M]);
        dfs((x + 1) % N, (y + M - 1) % M, length + 1);
        current.remove(current.size() - 1);

        current.add(lst[x][(y + M - 1) % M]);
        dfs(x, (y + M - 1) % M, length + 1);
        current.remove(current.size() - 1);

        current.add(lst[(x + N - 1) % N][(y + M - 1) % M]);
        dfs((x + N - 1) % N, (y + M - 1) % M, length + 1);
        current.remove(current.size() - 1);
    }
}