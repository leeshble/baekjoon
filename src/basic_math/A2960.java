/*
 * Memory: 14140KB
 * Time: 128ms
 */

package basic_math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A2960 {
	static int n;
	static int k;
	static int count;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		count = 0;
		
		bw.write(String.valueOf(erato()));
		bw.flush();
		bw.close();
	}
	
	public static int erato() {
		boolean[] array = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			for (int j = i; j <= n; j += i) {
				if (!array[j]) {
					array[j] = true;
					count++;
				}
				if (count == k) {
					return j;
				}
			}
		}
		return 0;
	}
}
