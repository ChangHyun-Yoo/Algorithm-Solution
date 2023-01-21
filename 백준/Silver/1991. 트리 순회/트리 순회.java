import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static String preOrder = "";
    public static String inOrder = "";
    public static String postOrder = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] nodes = new String[(int) Math.pow(2, N) + 1];

        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < (int) Math.pow(2, N) + 1; i++) {
            nodes[i] = "";
        }

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String root = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            if(root.equals("A")) {
                nodes[0] = "A";
                map.put("A", 0);
                if(!left.equals(".")) {
                    nodes[1] = left;
                    map.put(left, 1);
                }
                if(!right.equals(".")) {
                    nodes[2] = right;
                    map.put(right, 2);
                }
            } else {
                int rootIndex = map.get(root);
                if(!left.equals(".")) {
                    nodes[rootIndex * 2 + 1] = left;
                    map.put(left, rootIndex * 2 + 1);
                }
                if(!right.equals(".")) {
                    nodes[rootIndex * 2 + 2] = right;
                    map.put(right, rootIndex * 2 + 2);
                }
            }
        }

        //preOrder : root - left- right
        preOrder(0, nodes);
        System.out.println(preOrder);

        //inOrder : left - root - right;
        inOrder(0, nodes);
        System.out.println(inOrder);

        //postOrder : left - right - root;
        postOrder(0, nodes);
        System.out.println(postOrder);

    }

    public static void preOrder(int index, String[] nodes) {
        if(!nodes[index].equals("")) {
            preOrder += nodes[index];
            preOrder(index * 2 + 1, nodes);
            preOrder(index * 2 + 2, nodes);
        }
    }

    public static void inOrder(int index, String[] nodes) {
        if(!nodes[index].equals("")) {
            inOrder(index * 2 + 1, nodes);
            inOrder += nodes[index];
            inOrder(index * 2 + 2, nodes);
        }
    }

    public static void postOrder(int index, String[] nodes) {
        if(!nodes[index].equals("")) {
            postOrder(index * 2 + 1, nodes);
            postOrder(index * 2 + 2, nodes);
            postOrder += nodes[index];
        }
    }
}
