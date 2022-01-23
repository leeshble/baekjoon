package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A2011 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		if (input.charAt(0) == 0) {
			System.out.print("0");
			return;
		}
		
		long[] dp = new long[input.length()];
		dp[0] = dp[1] = 1;
		
		//for문에서 i < input.length() 방식으로 하면 매 턴마다 call 하기 때문에 이 방식이 더 빠름
		int size = input.length();
		for (int i = 0; i < size; i++) {
			char check = input.charAt(i - 1);
			char prev = input.charAt(i - 2);
		}
	}

}
