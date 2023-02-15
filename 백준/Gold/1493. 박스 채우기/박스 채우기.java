import java.io.*;
import java.util.*;

public class Main {
    static int[] cube;
    static long answer = 0;
    static boolean check = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int length = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        cube = new int[20];
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            cube[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        dq(length, width, height);

        if(check)
            System.out.println(-1);
        else
            System.out.println(answer);
    }

    static void dq(int length, int width, int height) {
        if(length == 0 || width == 0 || height == 0) {
            return;
        }

        int max = 1;
        int index = 0;
        while(max <= length && max <= width && max <= height) {
            max *= 2;
            index++;
        }
        max /= 2;
        index--;

        while(index >= 0) {
            if(cube[index] > 0) {
                cube[index]--;
                answer++;
                dq(max, max, height - max);
                if(width > length) {
                    dq(length, width - max, height);
                    dq(length - max, max, height);
                } else {
                    dq(max, width - max, height);
                    dq(length - max, width, height);
                }
                return;
            }
            max /= 2;
            index--;
        }
        if(index == -1) {
            check = true;
            return;
        }
    }

}