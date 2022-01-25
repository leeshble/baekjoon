package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A1946 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		
		int[] paper;
		int[] inter;
		
		int testCase = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCase; i++) {
			int n = Integer.parseInt(br.readLine());
			
			paper = new int[n];
			inter = new int[n];
			
			int output = n;
			
			
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				paper[j] = Integer.parseInt(st.nextToken());
				inter[j] = Integer.parseInt(st.nextToken());
			}
			
			for (int j = 0; j < n; j++) {
				boolean paperResult = true, interResult = true;
				
				for (int k = 0; k < n; k++) {
					if (paper[j] < paper[k]) {
						paperResult = false;
						break;
					}
				}
				for (int k = 0; k < n; k++) {
					if (inter[j] < inter[k]) {
						interResult = false;
						break;
					}
				}
				if (paperResult == true && interResult == true) {
					output--;
				}
			}
			sb.append(output).append("\n");
		}
		System.out.print(sb);
	}

}
