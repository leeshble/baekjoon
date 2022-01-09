/*
 * Memory: 14322KB
 * Time: 124ms
 */

package recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A10872 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(facto(Integer.parseInt(br.readLine()))));
		br.close();
		bw.flush();
		bw.close();
	}
	
	public static int facto(int a) {
		if (a <= 1) {
			return 1;
		} else {
			return a * facto(a - 1);
		}
	}

}
