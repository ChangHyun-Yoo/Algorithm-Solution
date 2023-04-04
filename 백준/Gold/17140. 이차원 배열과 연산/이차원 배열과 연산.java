import java.io.*;
import java.util.*;

public class Main {

    static int[][] A = new int[100][100];
    static int[][] info = new int[101][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = -1;
        int rowNum = 3;
        int colNum = 3;

        for(int i = 0; i <= 100; i++) {
            if(A[r - 1][c - 1] == k) {
                answer = i;
                break;
            }

            if(rowNum >= colNum) {
                int max = -1;
                for(int j = 0; j < rowNum; j++) {
                    initInfo();
                    for(int l = 0; l < colNum; l++) {
                        info[A[j][l]][1]++;
                    }
                    sort();
                    int index = 0;
                    int m = 0;
                    for(; m <= 100 && index < 100; m++) {
                        if(info[m][0] != 0 && info[m][1] != 0) {
                            A[j][index++] = info[m][0];
                            if(index == 100) break;
                            A[j][index++] = info[m][1];
                        }
                    }
                    if(index > max) max = index;
                    for(; index < 100; index++) {
                        A[j][index] = 0;
                    }
                }
                colNum = max;
                continue;
            }

            if(rowNum < colNum) {
                int max = -1;
                for(int j = 0; j < colNum; j++) {
                    initInfo();
                    for(int l = 0; l < rowNum; l++) {
                        info[A[l][j]][1]++;
                    }
                    sort();
                    int index = 0;
                    int m = 0;
                    for(; m <= 100 && index < 100; m++) {
                        if(info[m][0] != 0 && info[m][1] != 0) {
                            A[index++][j] = info[m][0];
                            if(index == 100) break;
                            A[index++][j] = info[m][1];
                        }
                    }

                    if(index > max) max = index;
                    for(; index < 100; index++) {
                        A[index][j] = 0;
                    }
                }
                rowNum = max;
                continue;
            }
        }

        System.out.println(answer);
    }

    static void initInfo() {
        for(int i = 0; i < 101; i++) {
            info[i][0] = i;
            info[i][1] = 0;
        }
    }

    static void sort() {
        Arrays.sort(info, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });
    }
}
