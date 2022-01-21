/*
 * 9465번
 * 
 * Memory: 120292KB
 * Time: 844ms
 */

package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A9465 {

	static int[] point1;
	static int[] point2;
	static int[] dp1;
	static int[] dp2;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			point1 = new int[n + 1];
			point2 = new int[n + 1];
			dp1 = new int[n + 1];
			dp2 = new int[n + 1];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				point1[j] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= n; j++) {
				point2[j] = Integer.parseInt(st.nextToken());
			}
			
			//초기값 설정
			dp1[1] = point1[1];
			dp2[1] = point2[1];
			
			for (int j = 2; j <= n; j++) {
				if (dp2[j-1] > dp2[j-2]) {
					dp1[j] = dp2[j-1] + point1[j];
				} else {
					dp1[j] = dp2[j-2] + point1[j];
				}
				if (dp1[j-1] > dp1[j-2]) {
					dp2[j] = dp1[j-1] + point2[j];
				} else {
					dp2[j] = dp1[j-2] + point2[j];
				}
			}
			
			if (dp1[n] > dp2[n]) {
				sb.append(dp1[n]).append("\n");
			} else {
				sb.append(dp2[n]).append("\n");
			}
			
			System.out.print(sb);
			sb.setLength(0);
		}
	}
}
