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
	static int n; // ������ ����
	static int m; // ������ ����
	static int v; // Ž���� ������ ������ ��ȣ V
	static int[][] map; // �������
	static boolean[] visit; // �湮����

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input);
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		
		// ������� �Է�
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
		
		// �湮���� �ʱ�ȭ
		for (int i = 0; i < n + 1; i++) {
			visit[i] = false;
		}
		bfs(v);
		System.out.print(sb);
	}
	
	static void dfs(int i) {
		// �湮 ó��
		visit[i] = true;
		sb.append(i);
		sb.append(" ");
		for (int j = 1; j <= n; j++) {
			//������� �� 1�̰�, �湮���� ���� ���϶� dfs Ž��
			if (map[i][j] == 1 && !visit[j]) {
				dfs(j);
			}
		}
	}
	
	static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);	// ó�� ���۳�� �߰�
        visit[start] = true;	// ó�� ���۳�� �湮ó��
        while(!queue.isEmpty()){
            int node = queue.poll();
            sb.append(node + " ");	//��¿� �߰�
            for(int i = 1; i < n + 1; i++){
                // ���� ���� �ٸ� ��� ��, �湮���� ���� ���, ������ �ִٸ�
                if(i != node && visit[i] == false && map[node][i] == 1) {
                    queue.add(i);	//��� �߰�
                    visit[i] = true;	//�湮ó��
                }
            }
        }
    }
}
