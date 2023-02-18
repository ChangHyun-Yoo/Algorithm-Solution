import java.io.*;
import java.util.*;

public class Main {

    static boolean check = false;

    static class Circle implements Comparable<Circle> {
        int num;
        int point;

        public Circle(int num, int point) {
            this.num = num;
            this.point = point;
        }


        @Override
        public int compareTo(Circle o) {
            if(this.point == o.point)
                check = true;
            return this.point - o.point;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Circle[] info = new Circle[2 * N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            info[i] = new Circle(i, c - r);
            info[i + N] = new Circle(i, c + r);
        }

        if(check) {
            System.out.println("NO");
            return;
        }

        Arrays.sort(info);

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < 2*N; i++) {
            if(stack.isEmpty()) {
                stack.push(info[i].num);
            } else {
                if(stack.peek() == info[i].num) {
                    stack.pop();
                } else {
                    stack.push(info[i].num);
                }
            }
        }

        if(stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}