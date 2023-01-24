import java.io.*;
import java.util.*;

public class Main {

    private static int max = -1000000000;
    private static int min = 1000000000;
    private static List<String[]> cand = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> num = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++)
            num.add(Integer.parseInt(st.nextToken()));

        int[] cal = new int[4];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < 4; i++) {
            cal[i] = Integer.parseInt(st.nextToken());
        }

        String[] current = new String[N - 1];
        bfs(current, cal, 0);

        for(String[] c : cand) {
            int number = num.get(0);
            for(int i = 0; i < c.length; i++) {
                if(c[i].equals("plus")) {
                    number += num.get(i + 1);
                } else if(c[i].equals("mul")) {
                    number *= num.get(i + 1);
                } else if(c[i].equals("div")) {
                    if(number < 0) {
                        number = -Math.abs(number) / num.get(i + 1);
                    } else {
                        number = number / num.get(i + 1);
                    }
                } else {
                    number -= num.get(i + 1);
                }
            }
            if(number > max)
                max = number;
            if(number < min)
                min = number;
        }

        System.out.println(max);
        System.out.println(min);
    }

    public static void bfs(String[] current, int[] cal, int num) {
        if(num == current.length) {
            cand.add(current);
        }

        if(cal[0] > 0) {
            String[] copy = current.clone();
            copy[num] = "plus";
            int[] copyCal = cal.clone();
            copyCal[0] -= 1;
            bfs(copy, copyCal,num + 1);
        }
        if(cal[1] > 0) {
            String[] copy = current.clone();
            copy[num] = "minus";
            int[] copyCal = cal.clone();
            copyCal[1] -= 1;
            bfs(copy, copyCal,num + 1);
        }
        if(cal[2] > 0) {
            String[] copy = current.clone();
            copy[num] = "mul";
            int[] copyCal = cal.clone();
            copyCal[2] -= 1;
            bfs(copy, copyCal,num + 1);
        }
        if(cal[3] > 0) {
            String[] copy = current.clone();
            copy[num] = "div";
            int[] copyCal = cal.clone();
            copyCal[3] -= 1;
            bfs(copy, copyCal,num + 1);
        }
    }

}