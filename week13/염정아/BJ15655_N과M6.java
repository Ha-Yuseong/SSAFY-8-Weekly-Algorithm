package problem.BJ;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BJ15655_N과M6 {
	static int ans, N, M;
	static int[] tgt, src;

	static StringBuilder sb = new StringBuilder();


	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		tgt = new int[M];
		src = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) src[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(src);

		comb(0, 0);

		System.out.println(sb.toString());
	}


	private static void comb(int dep, int idx) {
		if (dep == M) {
			for (int n : tgt) sb.append(n).append(" ");
			sb.append("\n");
			return;
		}

		for (int i = idx; i < N; i++) {
			tgt[dep] = src[i];
			comb(dep + 1, i + 1);
		}
	} // end perm
}
