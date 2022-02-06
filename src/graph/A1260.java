package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class A1260 {
	
	static StringBuilder sb;
	static int n; // 정점의 개수
	static int m; // 간선의 개수
	static int v; // 탐색을 시작할 정점의 번호 V
	static int[][] map; // 인접행렬
	static boolean[] visit; // 방문여부

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		
		// 인접행렬 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u][v] = 1;
			map[v][u] = 1;
		}
		
		sb = new StringBuilder();
		visit = new boolean[n + 1];
		dfs(v);
		sb.append("\n");
		
		// 방문여부 초기화
		for (int i = 0; i < n + 1; i++) {
			visit[i] = false;
		}
		bfs(v);
		System.out.print(sb);
	}
	
	static void dfs(int i) {
		// 방문 처리
		visit[i] = true;
		sb.append(i);
		sb.append(" ");
		for (int j = 1; j <= n; j++) {
			//인접행렬 값 1이고, 방문하지 않은 곳일때 dfs 탐색
			if (map[i][j] == 1 && !visit[j]) {
				dfs(j);
			}
		}
	}
	
	static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);	// 처음 시작노드 추가
        visit[start] = true;	// 처음 시작노드 방문처리
        while(!queue.isEmpty()){
            int node = queue.poll();
            sb.append(node + " ");	//출력에 추가
            for(int i = 1; i < n + 1; i++){
                // 현재 노드와 다른 노드 중, 방문하지 않은 노드, 간선이 있다면
                if(i != node && visit[i] == false && map[node][i] == 1) {
                    queue.add(i);	//노드 추가
                    visit[i] = true;	//방문처리
                }
            }
        }
    }
}
