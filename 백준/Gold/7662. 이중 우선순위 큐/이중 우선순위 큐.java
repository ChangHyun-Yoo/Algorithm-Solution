import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            for(int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                if(st.nextToken().equals("I")) {
                    int value = Integer.parseInt(st.nextToken());

                    if(treeMap.get(value) == null) {
                        treeMap.put(value, 1);
                    } else {
                        treeMap.replace(value, treeMap.get(value) + 1);
                    }
                } else {
                    if(!treeMap.isEmpty()) {
                        if(Integer.parseInt(st.nextToken()) == -1) {
                            int minKey = treeMap.firstKey();

                            if(treeMap.get(minKey) == 1) {
                                treeMap.remove(minKey);
                            } else {
                                treeMap.replace(minKey, treeMap.get(minKey) - 1);
                            }
                        } else {
                            int maxKey = treeMap.lastKey();

                            if(treeMap.get(maxKey) == 1) {
                                treeMap.remove(maxKey);
                            } else {
                                treeMap.replace(maxKey, treeMap.get(maxKey) - 1);
                            }
                        }
                    }
                }
            }

            if(treeMap.isEmpty()) {
                sb.append("EMPTY").append('\n');
            } else {
                sb.append(treeMap.lastKey() + " " + treeMap.firstKey()).append('\n');
            }
        }
        System.out.println(sb);
    }
}