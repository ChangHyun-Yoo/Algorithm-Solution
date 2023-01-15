import java.io.*;
import java.util.*;

public class Main {

    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] height = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                height[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            List<Integer> heights = new ArrayList<>();
            for(int h: height[i]) {
                heights.add(h);
            }
            if(cross(heights, L))
                answer++;
        }
        for(int i = 0; i < N; i++) {
            List<Integer> heights = new ArrayList<>();
            for(int j = 0; j < N; j++) {
                heights.add(height[j][i]);
            }
            if(cross(heights, L))
                answer++;
        }

        System.out.println(answer);
    }

    public static boolean cross(List<Integer> height, int L) {
        int current = 0;
        boolean[] fence = new boolean[height.size()];
        for(int i = 0; i < height.size(); i++) {
            if(i > 0)
                current = height.get(i - 1);
            int next = height.get(i);
            if(i == 0)//첫번째
                current = next;
            else if(current == next)//전과 같을 때
                continue;
            else if(Math.abs(current - next) >= 2) {
                return false;
            } else {//한계단 차이 일때
                if(current - next == 1) {//한 계단 낮아질 때
                    if(fence[i])
                        return false;
                    else
                        fence[i] = true;
                    for(int j = i + 1; j < i + L; j++) {
                        try {
                            if(height.get(j) != next)
                                return false;
                            else {
                                if(fence[j])
                                    return false;
                                else
                                    fence[j] = true;
                            }
                        } catch(Exception e) {//놓을 곳이 없음
                            return false;
                        }
                    }
                    i += L - 1;
                } else {//한 계단 높아질 때
                    int before = height.get(i - 1);
                    try {
                        if(fence[i - 1])
                            return false;
                        else
                            fence[i - 1] = true;
                    } catch(Exception e) {
                        return false;
                    }
                    for(int j = i - 2; j > i - L - 1; j--) {
                        try {
                            if(height.get(j) != before)
                                return false;
                            else {
                                if(fence[j])
                                    return false;
                                else
                                    fence[j] = true;
                            }
                        } catch (Exception e) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}