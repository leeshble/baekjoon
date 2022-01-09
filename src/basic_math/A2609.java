/*
 * Memory: 16128KB
 * Time: 152ms
 */

package basic_math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A2609 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		bw.write(gcf(a, b) + "\n" + lcm(a, b));
		bw.flush();
		bw.close();
	}
	
	public static int gcf(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcf(b, a % b);
	}
	
	public static int lcm(int a, int b) {
		return a * b / gcf(a, b);
	}

}
