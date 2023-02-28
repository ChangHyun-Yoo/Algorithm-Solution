import java.io.*;
import java.util.*;

public class Main {

    static int[] info;
    static int[] result;
    static int length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] light1 = new int[N];
        List<Integer> light2 = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            light1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            light2.add(Integer.parseInt(st.nextToken()));
        }
        info = new int[N];
        for(int i = 0; i < N; i++) {
            info[i] = light2.indexOf(light1[i]);
        }

        Stack<Integer> stack = new Stack<>();
        result = new int[N];
        result[0] = info[0];
        stack.push(0);
        stack.push(result[0]);
        length = 1;
        int count = 1;
        while(count != N) {
            int index = binarySearch(info[count]);
            if(index == -1) {
                result[length] = info[count];
                stack.push(length++);
                stack.push(info[count++]);
            } else {
                result[index] = info[count];
                stack.push(index);
                stack.push(info[count++]);
            }
        }
        int[] save = new int[N];
        int idx = length - 1;
        while(!stack.isEmpty()) {
            int value = stack.pop();
            int i = stack.pop();
            if(idx == i) {
                save[idx] = value;
                idx--;
            }
        }

        int[] answer = new int[length];
        for(int i = 0; i < length; i++) {
            answer[i] = light2.get(save[i]);
        }
        Arrays.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(length).append('\n');
        for(int i = 0; i < answer.length; i++) {
            if(i == answer.length - 1){
                sb.append(answer[i]);
            } else {
                sb.append(answer[i] + " ");
            }
        }
        System.out.println(sb);
    }

    static int binarySearch(int value) {
        int low = 0;
        int high = length;

        while(low < high) {
            int mid = low + (high - low) / 2;
            if(value <= result[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        if(low == length) {
            return -1;
        } else {
            return low;
        }
    }
}