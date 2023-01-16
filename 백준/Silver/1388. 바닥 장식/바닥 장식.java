import java.io.*;
import java.util.*;

public class Main {

    public static int min = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());

        char[][] tiles = new char[col][row];
        boolean[][] counted = new boolean[col][row];
        for(int i = 0; i < col; i++) {
            String line = br.readLine();
            for(int j = 0; j < row; j++) {
                tiles[i] = line.toCharArray();
            }
        }

        int answer = 0;

        for(int i = 0; i < col; i++) {
            int sum = 0;
            boolean connected = false;
            for(int j = 0; j < row; j++) {
                if(!connected) {
                    if(tiles[i][j] == '-') {
                        sum++;
                        connected = true;
                    }
                } else {
                    if(tiles[i][j] == '-') {
                        continue;
                    } else {
                        connected = false;
                    }
                }
            }
            answer += sum;
        }

        for(int i = 0; i < row; i++) {
            int sum = 0;
            boolean connected = false;
            for(int j = 0; j < col; j++) {
                if(!connected) {
                    if(tiles[j][i] == '|') {
                        sum++;
                        connected = true;
                    }
                } else {
                    if(tiles[j][i] == '|') {
                        continue;
                    } else {
                        connected = false;
                    }
                }
            }
            answer += sum;
        }

        System.out.println(answer);
    }

}