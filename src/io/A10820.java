/*
 * Memory: 15944KB
 * Time: 152ms
 */

package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A10820 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = "";
		int[] stats = new int[4];
		while((input = br.readLine()) != null) {
			for (int i = 0; i < input.length(); i++) {
				char word = input.charAt(i);
				if (word >= 'a' & word <= 'z') {
					stats[0]++;				
				} else if (word >= 'A' & word <= 'Z') {
					stats[1]++;
				} else if (word >= '0' & word <= '9') {
					stats[2]++;
				} else if (word == ' ') {
					stats[3]++;
				}
			}
			//Faster way to use 'for' with array
			for (int i = 0; i <= 3; i++) {
				bw.write(stats[i] + " ");
				stats[i] = 0;
			}
			bw.write("\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
}
