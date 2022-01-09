package basic_math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class A2960 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		br.close();
		int n = Integer.parseInt(st.nextToken().toString());
		int k = Integer.parseInt(st.nextToken().toString());
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int i = 2; i <= n ; i++) {
			array.add(i);
		}
		
		int count = 0;
		int output = 0;
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < array.size(); j++) {
				int data = array.get(j);
				if (n % data == 0) {
					if (count == k) {
						output = array.get(j);
					}
					array.remove(j);
					count++;
				}
			}
		}
		bw.write(String.valueOf(output));
		bw.flush();
		bw.close();
//		long start, end;
//		
//		ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList(2, n));
//		int output;
//		
//		for (int i = 2; i < n; i++) {
//			array.add(i);
//		}
//		int count = 0;
//		for (int i = 0; i < array.size(); i++) {
//			int p = array.get(i);
//			for (int j = 0; j <= n; j += p) {
//				if (array.contains(j)) {
//					count++;
//					if (count == k) {
//						System.out.println(p);
//					} else {
//						array.remove(j);
//					}
//				}
//			}
//		}
	}
}
