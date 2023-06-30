import java.io.*;
import java.util.*;

public class Main {

    static Node root;
    static List<Integer> preOrder;
    static List<Integer> inOrder;
    static StringBuilder sb = new StringBuilder();

    static class Node {
        int value;
        Node left;
        Node right;

        public Node() {
            value = -1;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            preOrder = new ArrayList<>();
            inOrder = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < n; i++) {
                preOrder.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < n; i++) {
                inOrder.add(Integer.parseInt(st.nextToken()));
            }

            root = new Node();
            find(root, 0, n, 0, n);
            print(root);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void print(Node node) {
        if(node.value == -1) return;

        print(node.left);
        print(node.right);
        sb.append(node.value + " ");
    }

    static void find(Node current, int ps, int pe, int is, int ie) {
        if(ps == pe) return;
        current.value = preOrder.get(ps);

        int index = inOrder.indexOf(current.value);
        current.left = new Node();
        current.right = new Node();

        find(current.left, ps + 1, ps + 1 + index - is, is, index);
        find(current.right, ps + 1 + index - is, pe, index + 1, ie);
    }
}