import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        int[] parent = new int[G + 1];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        int[] airplanes = new int[P];
        for(int p = 0; p < P; p++) {
            airplanes[p] = Integer.parseInt(br.readLine());
        }

        int answer = 0;
        for(int i = 0; i < airplanes.length; i++) {
            int airplane = airplanes[i];

            int p = findParent(airplane, parent);

            if(p == 0) break;
            else answer++;

            union(p - 1, p, parent);
        }

        System.out.println(answer);
    }

    static int findParent(int airplane, int[] parent) {
        if(airplane == parent[airplane]) return airplane;

        return parent[airplane] = findParent(parent[airplane], parent);
    }

    static void union(int i, int j, int[] parent) {
        int rootI = findParent(i, parent);
        int rootJ = findParent(j, parent);

        if(rootI < rootJ) {
            parent[rootJ] = rootI;
        } else if(rootI > rootJ) {
            parent[rootI] = rootJ;
        }
    }
}
