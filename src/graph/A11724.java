package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A11724 {

	static int n;	//������ ����
	static int m;	//������ ����
	static int[][] map;	//�������
	static boolean[] visit;	//�湮����
	
	public static void main(String[] args) throws IOException{
		// ����, ���� ���� �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n + 1][n + 1];
		
		// ������� �Է�
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[u][v] = 1;
			map[u][v] = 1;
		}
		
		// dfs ������
		int count = 0;	// 
		visit = new boolean[n + 1];
		for (int i = 1; i < n + 1; i++) {
			if (!visit[i]) {
				dfs(i);
				count++;	//�ѹ� �������� ���� �߰�
			}
		}
		System.out.print(count);
	}
	
	static void dfs(int i) {
		// �湮 ó��
		visit[i] = true;
		
		for (int j = 0; j <= n; j++) {
			//������� �� 1�̰�, �湮���� ���� ���϶� dfs ���
			if (map[i][j] == 1 && !visit[j]) {
				dfs(j);
			}
		}
	}

}
