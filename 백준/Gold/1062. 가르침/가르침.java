import java.io.*;
import java.util.*;

public class Main {

    public static int answer = 0;
    public static int[] lst;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        lst = new int[N];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            int t = 0;
            for(int j = 4; j < s.length() - 4; j++) {
                String sub = s.substring(j, j + 1);
                switch(sub) {
                    case "b":
                        t |= (int) Math.pow(2, 20);
                        break;
                    case "d":
                        t |= (int) Math.pow(2, 19);
                        break;
                    case "e":
                        t |= (int) Math.pow(2, 18);
                        break;
                    case "f":
                        t |= (int) Math.pow(2, 17);
                        break;
                    case "g":
                        t |= (int) Math.pow(2, 16);
                        break;
                    case "h":
                        t |= (int) Math.pow(2, 15);
                        break;
                    case "j":
                        t |= (int) Math.pow(2, 14);
                        break;
                    case "k":
                        t |= (int) Math.pow(2, 13);
                        break;
                    case "l":
                        t |= (int) Math.pow(2, 12);
                        break;
                    case "m":
                        t |= (int) Math.pow(2, 11);
                        break;
                    case "o":
                        t |= (int) Math.pow(2, 10);
                        break;
                    case "p":
                        t |= (int) Math.pow(2, 9);
                        break;
                    case "q":
                        t |= (int) Math.pow(2, 8);
                        break;
                    case "r":
                        t |= (int) Math.pow(2, 7);
                        break;
                    case "s":
                        t |= (int) Math.pow(2, 6);
                        break;
                    case "u":
                        t |= (int) Math.pow(2, 5);
                        break;
                    case "v":
                        t |= (int) Math.pow(2, 4);
                        break;
                    case "w":
                        t |= (int) Math.pow(2, 3);
                        break;
                    case "x":
                        t |= (int) Math.pow(2, 2);
                        break;
                    case "y":
                        t |= (int) Math.pow(2, 1);
                        break;
                    case "z":
                        t |= (int) Math.pow(2, 0);
                        break;
                    default:
                        break;
                }
            }
            lst[i] = t;
        }

        //b d e f g h j k l m o p q r s u v w x y z
        //
        if(K < 5) {
            System.out.println(0);
            return;
        }

        int newWord = K - 5;

        com(newWord, 0, 0, 0);

        System.out.println(answer);
    }

    public static int check(int num) {
        int res = 0;
        for(int s: lst) {
            int tt = num | s;
            if(tt == num) {
                res++;
            }
        }
        return res;
    }

    public static void com(int newWord, int current, int num, int putted) {
        if(putted == newWord) {
            int a = check(num);
            if(answer < a)
                answer = a;
            return;
        }

        if(current > 20) {
            return;
        }

        com(newWord, current + 1, num + (int) Math.pow(2, 20 - current), putted + 1);
        com(newWord, current + 1, num, putted);
    }

}