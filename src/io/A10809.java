/*
 * Memory: 15912KB
 * Time: 144ms
 */

package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A10809 {

	public static void main(String[] args) throws IOException{
		// ���ڿ� �Է�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		br.close();
		
		// ���ڿ� ��ġ
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (char i = 'a'; i <= 'z'; i++) {
			bw.write(input.indexOf(i) + " ");
		}
		bw.flush();
		bw.close();
	}
	
}
