/*
 * DP, Bottom-Up 방식
 * 
 * 입력을 다 받고 루프 돌릴때
 * Memory: 14824KB
 * Time: 160ms
 * 
 * 백준 내부에 존재하는 메모리, 시간 타이머가 매 Try 마다 다르게 나옴.
 * 테스트 케이스의 다양성, 채점 참여자에 따른 변동사항이 너무 큰것으로 보임.
 */

package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A12865 {
	
	//입력을 합쳤을때
	/*
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		
		//들수 있는 물품 수
		int n = Integer.parseInt(st.nextToken());
		
		//들수 있는 무게 수
		int k = Integer.parseInt(st.nextToken());
		
		//이차원 배열로 같이 할 수 있으나 더 느리기 때문에 분리
		//각 물건의 무게
		int[] w = new int[n + 1];
		
		//각 물건의 가치
		int[] v = new int[n + 1];
		
		//첫 배열은 공백으로 사용하기 위해 1씩 더 크게 생성
		int dp[] = new int[k+1];
		
		//0행 0열은 공백으로 비워둠
		//i: 물품, j: 무게
		//들수 있는 물품의 수만큼 반복
		for (int i = 1; i <= n; i++) {
			//입력을 루프 돌때마다 진행
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
			
			//무게 한계치를 넘지 않을때까지 반복
			for (int j = k; j - w[i] >= 0; j--) {
				//Math.max는 느리기 때문에 따로 제작
				//이전 방식의 가치와 (남은 무게의 가치 + 자신의 가치) 중 큰 값을 저장
				if (dp[j] < dp[j - w[i]] + v[i]) {
					dp[j] = dp[j - w[i]] + v[i];
				}
			}
		}
		br.close();
		bw.write(String.valueOf(dp[k]));
		bw.flush();
		bw.close();
	}
	
	*/

	//입력을 다 받고 루프 돌릴때
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		
		//들수 있는 물품 수
		int n = Integer.parseInt(st.nextToken());
		
		//들수 있는 무게 수
		int k = Integer.parseInt(st.nextToken());
		
		//이차원 배열로 같이 할 수 있으나 더 느리기 때문에 분리
		//각 물건의 무게
		int[] w = new int[n + 1];
		
		//각 물건의 가치
		int[] v = new int[n + 1];
		
		//무게, 가치 입력받기
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
		
		//첫 배열은 공백으로 사용하기 위해 1씩 더 크게 생성
		int dp[] = new int[k+1];
		
		//0행 0열은 공백으로 비워둠
		//i: 물품, j: 무게
		//들수 있는 물품의 수만큼 반복
		for (int i = 1; i <= n; i++) {
			//무게 한계치를 넘지 않을때까지 반복
			for (int j = k; j - w[i] >= 0; j--) {
				//Math.max는 느리기 때문에 따로 제작
				//이전 방식의 가치와 (남은 무게의 가치 + 자신의 가치) 중 큰 값을 저장
				if (dp[j] < dp[j - w[i]] + v[i]) {
					dp[j] = dp[j - w[i]] + v[i];
				}
			}
		}
		bw.write(String.valueOf(dp[k]));
		bw.flush();
		bw.close();
	}
}
