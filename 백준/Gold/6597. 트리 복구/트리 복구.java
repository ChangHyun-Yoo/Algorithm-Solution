import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;

        while((s = br.readLine()) != null) {
            String pre = s.split(" ")[0];
            String in = s.split(" ")[1];

            postOrder(pre, in);

            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void postOrder(String preOrder, String inOrder) {
        if(preOrder.length() == 0)
            return;

        String root = preOrder.substring(0, 1);
        int rootIdx = 0;
        for(int i = 0; i < inOrder.length(); i++) {
            if(inOrder.substring(i, i + 1).equals(root)) {
                rootIdx = i;
                break;
            }
        }

        postOrder(preOrder.substring(1, 1 + rootIdx), inOrder.substring(0, rootIdx));//left
        postOrder(preOrder.substring(1 + rootIdx, preOrder.length()), inOrder.substring(rootIdx + 1, inOrder.length()));
        sb.append(root);
    }
}