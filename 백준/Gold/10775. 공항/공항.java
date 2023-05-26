import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());

		parent = new int[G + 1];
		for (int i = 1; i <= G; i++) {
			parent[i] = i;
		}

		// g번 비행기는 g번 이하 게이트에만 도킹이 가능함.
		// 이 때, g번 비행기를 g번 게이트에 도킹하는 것이 최선임.
		// 만약, g번 비행기를 g번게이트에 도킹할 수 없다면,
		// g-1번 게이트에 차선책으로 도킹시킴.
		// g-1번도 안 된다면, g-2번, ... 0번까지 탐색
		// 이 때, 차선책이 0번을 가리키고 있으면 도킹이 불가능한 상태임.
		// 차선책을 찾는 과정에서 유니온 파인드를 사용함.
		int ans = 0;
		for (int i = 0; i < P; i++) {
			int g = Integer.parseInt(br.readLine());
			int emptyGate = find(g);

			if (emptyGate == 0) {
				break;
			}

			ans++;
			union(emptyGate, emptyGate - 1);
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[x] = y;
		}
	}

}