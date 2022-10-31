package problem.BJ;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BJ15665_N과M11 {
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

		perm(0);

		System.out.println(sb.toString());
	}


	private static void perm(int dep) {
		if (dep == M) {
			for (int n : tgt) sb.append(n).append(" ");
			sb.append("\n");
			return;
		}

		int prev = -1;
		for (int i = 0; i < N; i++) {
			if (src[i] == prev) continue;

			tgt[dep] = src[i];
			prev = src[i];
			perm(dep + 1);
		}

	} // end perm

}

/*
 * 1 7 9 9
 * => 
 * 1 7
 * 1 9
 * 7 9
 * 9 9
 * */
