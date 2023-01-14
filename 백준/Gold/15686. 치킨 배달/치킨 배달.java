import java.io.*;
import java.util.*;

public class Main {
    public static List<List<Integer>> home = null;
    public static List<List<Integer>> choice  = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> store = new ArrayList<>();
        home = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) {
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    home.add(point);
                } else if(num == 2) {
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    store.add(point);
                }
            }
        }
        List<Integer> current = new ArrayList<>();
        com(0, current, store, M);

        int[][] lengths = new int[home.size()][store.size()];
        for(int i = 0; i < home.size(); i++) {
            for(int j = 0; j < store.size(); j++) {
                lengths[i][j] = Math.abs(store.get(j).get(0) - home.get(i).get(0)) + Math.abs(store.get(j).get(1) - home.get(i).get(1));
            }
        }

        int min = 100000;

        for(List<Integer> ch: choice) {
            int sum = 0;
            for(int i = 0; i < home.size(); i++) {
                int minn = 100000;
                for(int j = 0; j < ch.size(); j++) {
                    if(lengths[i][ch.get(j)] < minn)
                        minn = lengths[i][ch.get(j)];
                }
                sum += minn;
            }
            if(sum < min)
                min = sum;
        }

        System.out.println(min);
    }

    public static void com(int index, List<Integer> current, List<List<Integer>> store, int M) {
        if (index == store.size() || current.size() == M) {
            choice.add(current);
        } else if (current.size() + store.size() - index == M) {//나머지 모두 선택해야 하는 경우
            for (int i = index; i < store.size(); i++) {
                current.add(i);
            }
            com(store.size(), current, store, M);
        } else {
            com(index + 1, new ArrayList<>(current), store, M);
            List<Integer> copy = new ArrayList<>(current);
            copy.add(index);
            com(index + 1, copy, store, M);
        }
    }
}
