import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] inOrder;
    static int[] postOrder;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        inOrder = new int[n];
        postOrder = new int[n];
        for(int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                if(i == 0)
                    inOrder[j] = Integer.parseInt(st.nextToken());
                else
                    postOrder[j] = Integer.parseInt(st.nextToken());
            }
        }

        preOrder(0, n, 0, n);

        System.out.println(sb);
    }

    static void preOrder(int i1, int i2, int p1, int p2) {
        if(i1 == i2)
            return;

        int root = postOrder[p2 - 1];
        int index = 0;
        for(int i = i1 ; i < i2; i++) {
            if(inOrder[i] == root) {
                index = i;
                break;
            }
        }

        //root
        sb.append(root + " ");
        //left
        preOrder(i1, index, p1, p1 + index - i1);
        //right
        preOrder(index + 1, i2, p1 + index - i1, p2 - 1);
    }
}