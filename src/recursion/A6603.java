package recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A6603 {
	
	static int k;
	static int[] queue;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine(), "");
			k = Integer.parseInt(st.nextToken().toString());
				if (k == 0) {
				break;
			}
			queue = new int[k];
			visited = new boolean[k];
			for (int i = 0; i < k; i++) {
				queue[i] = Integer.parseInt(st.nextToken().toString());
			}
			dfs(0, 0);
			System.out.print("\n");
		}
		br.close();
	}
	
	static void dfs(int line, int count){
		if (count == 6) {
			for (int i = 0; i < k; i++) {
				if (visited[i] == true) {
					System.out.print(queue[i] + " ");
				}
			}
			System.out.print("\n");
		}
		for (int i = line; i < k; i++) {
			visited[i] = true;
			dfs(i++ , count++);
			visited[i] = false;
		}
	}
}
