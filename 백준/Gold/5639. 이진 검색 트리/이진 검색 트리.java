import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int x;
        Node left;
        Node right;

        public Node(int x) {
            this.x = x;
            this.left = null;
            this.right = null;
        }
    }

    static List<Integer> nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nums = new ArrayList<>();
        String input = "";
        while((input = br.readLine()) != null) {
            nums.add(Integer.parseInt(input));
        }

        Node root = new Node(-1);
        makeTree(root, 0, nums.size() - 1);

        postOrder(root);

        System.out.println(sb);
    }

    static void postOrder(Node node) {
        if(node == null) return;
        if(node.x == -1) return;

        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.x).append('\n');
    }

    static void makeTree(Node current, int s, int e) {
        if(s > e) return;
        
        current.x = nums.get(s);

        if(s == e) return;

        int pivot = current.x;
        int bigIndex = -1;
        for(int i = s + 1; i <= e; i++) {
            if(nums.get(i) > pivot) {
                bigIndex = i;
                break;
            }
        }

        if(bigIndex == -1) {//모두 왼쪽 서브트리
            current.left = new Node(-1);
            makeTree(current.left, s + 1, e);
        } else {
            current.left = new Node(-1);
            current.right = new Node(-1);
            makeTree(current.left, s + 1, bigIndex - 1);
            makeTree(current.right, bigIndex, e);
        }
    }
}