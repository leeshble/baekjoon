package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A11724 {

	static int n;	//정점의 개수
	static int m;	//간선의 개수
	static int[][] map;	//인접행렬
	static boolean[] visit;	//방문여부
	
	public static void main(String[] args) throws IOException{
		// 정점, 간선 개수 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		
		// 인접행렬 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u][v] = 1;
			map[u][v] = 1;
		}
		
		// dfs 돌리기
		int count = 0;	// 
		visit = new boolean[n + 1];
		for (int i = 1; i < n + 1; i++) {
			if (!visit[i]) {
				dfs(i);
				count++;	//한번 돌때마다 갯수 추가
			}
		}
		System.out.print(count);
	}
	
	static void dfs(int i) {
		// 방문 처리
		visit[i] = true;
		
		for (int j = 0; j <= n; j++) {
			//인접행렬 값 1이고, 방문하지 않은 곳일때 dfs 재귀
			if (map[i][j] == 1 && !visit[j]) {
				dfs(j);
			}
		}
	}

}
