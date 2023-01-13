import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int switchNum = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] lst = new int[switchNum];
        for(int i = 0; i < switchNum; i++) {
            lst[i] = Integer.parseInt(st.nextToken());
        }
        int count = Integer.parseInt(br.readLine());
        for(int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int sex = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if(sex == 1) {//남힉생
                for(int j = n - 1; j < switchNum; j += n) {
                    if(lst[j] == 0)
                        lst[j] = 1;
                    else
                        lst[j] = 0;
                }
            } else {//여학생
                int a = 0;
                while(n - 1 - a >= 0 && n - 1 + a < switchNum) {
                    if(a == 0)
                        a++;
                    else {
                        if(lst[n - 1 - a] == lst[n - 1 + a]) {
                            a++;
                        } else {
                            break;
                        }
                    }
                }
                a--;
                for(int k = n - 1 - a; k <= n - 1 + a; k++) {
                    if(lst[k] == 1)
                        lst[k] = 0;
                    else
                        lst[k] = 1;
                }
            }
        }

        for(int i = 0; i < lst.length; i++) {
            if(i % 20 == 19)
                System.out.println(lst[i]);
            else
                System.out.print(lst[i] + " ");
        }
    }

}