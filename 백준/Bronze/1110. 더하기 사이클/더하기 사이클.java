import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        int origin = input;
        int answer = 0;
        while(true) {
            input = (input % 10) * 10 + ((input / 10 + input % 10) % 10);
            answer++;
            if(origin == input) {
                break;
            }
        }
        System.out.println(answer);
    }

}