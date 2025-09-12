import java.util.*;
import java.io.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] status = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                status[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while(true) {
            // 1. 현재 칸이 청소 안된 경우 현재 칸 청소
            if(status[r][c] == 0) {
                status[r][c] = -1;
                answer++;
            }

            // 빈칸이 있는 경우
            if(check(r, c, status)) {
                d = (d + 3) % 4;

                if(d == 0 && r != 0) {
                    if(status[r - 1][c] == 0) r--;
                } else if(d == 1 && c != status[0].length - 1) {
                    if(status[r][c + 1] == 0) c++;
                } else if(d == 2 && r != status.length - 1) {
                    if(status[r + 1][c] == 0) r++;
                } else if(d == 3 && c != 0) {
                    if(status[r][c - 1] == 0) c--;
                }
            }
            // 빈칸이 없는 경우
            else {
                if(d == 0) {
                    if(r != status.length - 1 && status[r + 1][c] != 1) {
                        r++;
                        continue;
                    } else break;
                }
                if(d == 1) {
                    if(c != 0 && status[r][c - 1] != 1) {
                        c--;
                        continue;
                    } else break;
                }
                if(d == 2) {
                    if(r != 0 && status[r - 1][c] != 1) {
                        r--;
                        continue;
                    } else break;
                }
                if(d == 3) {
                    if(c != status[0].length - 1 && status[r][c + 1] != 1) {
                        c++;
                        continue;
                    } else break;
                }
            }
        }

        System.out.println(answer);
    }

    static boolean check(int r, int c, int[][] status) {
        for(int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];

            if(nx >= 0 && nx < status.length && ny >= 0 && ny < status[0].length) {
                if(status[nx][ny] == 0) return true;
            }
        }

        return false;
    }
}
