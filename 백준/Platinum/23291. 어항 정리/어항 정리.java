import java.io.*;
import java.util.*;

public class Main {

    static int[] num;
    static int[][] rolled;
    static boolean[][] visited;
    static int min;
    static int max;
    static int remain;
    static int w;
    static int h1;
    static int N;
    static int[][] value;
    static int[][] plus;
    static int[][] plus2;
    static int[][] building;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        f(N);
        w = (N - remain) / h1;
        rolled = new int[h1][w];
        visited = new boolean[h1][w];
        num = new int[N];
        value = new int[h1][w + remain];
        plus = new int[h1][w + remain];
        plus2 = new int[4][N / 4];
        building = new int[4][N / 4];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        while(true) {
            i++;
            max = -1;
            min = Integer.MAX_VALUE;
            check();
            for(int j = 0; j < num.length; j++) {
                if(num[j] == min) num[j]++;
            }

            fillRolled();

            control1();
            int index = 0;
            for(int j = 0; j < w + remain; j++) {
                for(int k = h1 - 1; k >= 0; k--) {
                    if(value[k][j] != 0) {
                        num[index] = value[k][j];
                        index++;
                    }
                }
            }

            build();
            control2();

            index = 0;
            for(int j = 0; j < N / 4; j++) {
                for(int k = 3; k >= 0; k--) {
                    num[index] = building[k][j];
                    index++;
                }
            }

            max = -1;
            min = Integer.MAX_VALUE;
            check();
            if(max - min <= K) break;
        }
        System.out.println(i);
    }

    static void control2() {
        for(int[] p: plus2) {
            Arrays.fill(p, 0);
        }
        for(int i = 0; i < building.length; i++) {
            for(int j = 0; j < building[0].length; j++) {
                if(i != 0) {
                    if(building[i][j] > building[i - 1][j] && (building[i][j] != 0 && building[i - 1][j] != 0)) {
                        if((building[i][j] - building[i - 1][j]) / 5 > 0) {
                            plus2[i][j] -= (building[i][j] - building[i - 1][j]) / 5;
                            plus2[i - 1][j] += (building[i][j] - building[i - 1][j]) / 5;
                        }
                    }
                }
                if(j != 0) {
                    if(building[i][j] > building[i][j - 1] && (building[i][j] != 0 && building[i][j - 1] != 0)) {
                        if((building[i][j] - building[i][j - 1]) / 5 > 0) {
                            plus2[i][j] -= (building[i][j] - building[i][j - 1]) / 5;
                            plus2[i][j - 1] += (building[i][j] - building[i][j - 1]) / 5;
                        }
                    }
                }
                if(i != 3) {
                    if(building[i][j] > building[i + 1][j] && (building[i][j] != 0 && building[i + 1][j] != 0)) {
                        if((building[i][j] - building[i + 1][j]) / 5 > 0) {
                            plus2[i][j] -= (building[i][j] - building[i + 1][j]) / 5;
                            plus2[i + 1][j] += (building[i][j] - building[i + 1][j]) / 5;
                        }
                    }
                }
                if(j != N / 4 - 1) {
                    if(building[i][j] > building[i][j + 1] && (building[i][j] != 0 && building[i][j + 1] != 0)) {
                        if((building[i][j] - building[i][j + 1]) / 5 > 0) {
                            plus2[i][j] -= (building[i][j] - building[i][j + 1]) / 5;
                            plus2[i][j + 1] += (building[i][j] - building[i][j + 1]) / 5;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < N / 4; j++) {
                building[i][j] += plus2[i][j];
            }
        }
    }

    static void build() {
        for(int i = 0; i < N / 4; i++) {
            building[3][i] = num[i + N * 3 / 4];
        }

        int x = 2;
        int y = N / 4 - 1;
        int dir = -1;
        int value = 0;
        while(true) {
            if(x == 0 && y == 0) {
                building[0][0] = num[value];
                break;
            }

            building[x][y] = num[value];
            value++;
            if(dir == -1) {
                if(y == 0) {
                    x--;
                    dir = 1;
                } else {
                    y--;
                }
                continue;
            }

            if(dir == 1) {
                if(y == N / 4 - 1) {
                    x--;
                    dir = -1;
                } else {
                    y++;
                }
                continue;
            }
        }
    }
    static void control1() {
        for(int[] v: value) {
            Arrays.fill(v, 0);
        }
        for(int[] p: plus) {
            Arrays.fill(p, 0);
        }

        for(int i = 0; i < h1; i++) {
            for(int j = 0; j < w; j++) {
                value[i][j] = rolled[i][j];
            }
        }
        int l = num.length - 1;
        for(int i = w + remain - 1; i >= 0 && l >= 0; i--) {
            value[h1 - 1][i] = num[l];
            l--;
        }
        for(int i = 0; i < h1; i++) {
            for(int j = 0; j < w + remain; j++) {
                if(i != 0) {
                    if(value[i][j] > value[i - 1][j] && (value[i][j] != 0 && value[i - 1][j] != 0)) {
                        if((value[i][j] - value[i - 1][j]) / 5 > 0) {
                            plus[i][j] -= (value[i][j] - value[i - 1][j]) / 5;
                            plus[i - 1][j] += (value[i][j] - value[i - 1][j]) / 5;
                        }
                    }
                }
                if(j != 0) {
                    if(value[i][j] > value[i][j - 1] && (value[i][j] != 0 && value[i][j - 1] != 0)) {
                        if((value[i][j] - value[i][j - 1]) / 5 > 0) {
                            plus[i][j] -= (value[i][j] - value[i][j - 1]) / 5;
                            plus[i][j - 1] += (value[i][j] - value[i][j - 1]) / 5;
                        }
                    }
                }
                if(i != h1 - 1) {
                    if(value[i][j] > value[i + 1][j] && (value[i][j] != 0 && value[i + 1][j] != 0)) {
                        if((value[i][j] - value[i + 1][j]) / 5 > 0) {
                            plus[i][j] -= (value[i][j] - value[i + 1][j]) / 5;
                            plus[i + 1][j] += (value[i][j] - value[i + 1][j]) / 5;
                        }
                    }
                }
                if(j != w + remain - 1) {
                    if(value[i][j] > value[i][j + 1] && (value[i][j] != 0 && value[i][j + 1] != 0)) {
                        if((value[i][j] - value[i][j + 1]) / 5 > 0) {
                            plus[i][j] -= (value[i][j] - value[i][j + 1]) / 5;
                            plus[i][j + 1] += (value[i][j] - value[i][j + 1]) / 5;
                        }
                    }
                }
            }
        }
        for(int i = 0; i < h1; i++) {
            for(int j = 0; j < w + remain; j++) {
                value[i][j] += plus[i][j];
            }
        }
    }

    static void fillRolled() {
        for(boolean[] v: visited) {
            Arrays.fill(v, false);
        }
        int value = w * h1 - 1;
        int x = h1 - 1;
        int y = w - 1;
        int dir = 0;
        while(value >= 0) {
            if(value == 0) {
                rolled[x][y] = num[value];
                break;
            }

            if(!visited[x][y]) {
                rolled[x][y] = num[value];
                visited[x][y] = true;

                if(dir == 0) {
                    if(y == 0) {
                        x--;
                        dir = 1;
                        value--;
                        continue;
                    } else {
                        if(!visited[x][y - 1]) {
                            y--;
                            value--;
                            continue;
                        } else {
                            x--;
                            dir = 1;
                            value--;
                            continue;
                        }
                    }
                }

                if(dir == 1) {
                    if(x == 0) {
                        y++;
                        dir = 2;
                        value--;
                        continue;
                    } else {
                        if(!visited[x - 1][y]) {
                            x--;
                            value--;
                            continue;
                        } else {
                            y++;
                            dir = 2;
                            value--;
                            continue;
                        }
                    }
                }

                if(dir == 2) {
                    if(y == w - 1) {
                        x++;
                        dir = 3;
                        value--;
                        continue;
                    } else {
                        if(!visited[x][y + 1]) {
                            y++;
                            value--;
                            continue;
                        } else {
                            x++;
                            dir = 3;
                            value--;
                            continue;
                        }
                    }
                }

                if(dir == 3) {
                    if(x == h1 - 1) {
                        y--;
                        dir = 0;
                        value--;
                        continue;
                    } else {
                        if(!visited[x + 1][y]) {
                            x++;
                            value--;
                            continue;
                        } else {
                            y--;
                            dir = 0;
                            value--;
                            continue;
                        }
                    }
                }
            }
        }
    }

    static void f(int n) {
        int h = 0;
        int w = n - 1;

        double number = 1.0;
        while(h <= w) {
            number += 0.5;
            w -= (int) number;
            h = (int) (number + 0.5);
        }
        remain = w;
        h1 = h;
    }

    static void check() {
        for(int n: num) {
            if(n > max) max = n;
            if(n < min) min = n;
        }
    }
}

