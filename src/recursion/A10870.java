/*
 * Memory: 14260KB
 * Time: 128ms
 */

package recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A10870 {
		
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(fibo(Integer.parseInt(br.readLine()))));
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int fibo(int a) {
		if (a == 0) {
			return 0;
		} else if (a == 1) {
			return 1;
		} else {
			return fibo(a - 1) + fibo(a - 2);
		}
	}
}
