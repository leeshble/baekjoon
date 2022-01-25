package greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class A11501 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int t = scan.nextInt();
		
		//출력이 64bit 정수형에 맞추기 위해 long으로 지정
		long output = 0;
		for (int i = 0; i < t; i++) {
			int n = scan.nextInt();
			long stocks[] = new long[n];
			long max = 0;
			scan.nextLine();
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				stocks[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = n - 1; j >= 0; j--) {
				if (stocks[j] > max) {
					max = stocks[j];
				} else {
					output += (max - stocks[j]);
				}
			}
			sb.append(output).append("\n");
		}
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
	}

}
