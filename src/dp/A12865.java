/*
 * DP, Bottom-Up ���
 * 
 * �Է��� �� �ް� ���� ������
 * Memory: 14824KB
 * Time: 160ms
 * 
 * ���� ���ο� �����ϴ� �޸�, �ð� Ÿ�̸Ӱ� �� Try ���� �ٸ��� ����.
 * �׽�Ʈ ���̽��� �پ缺, ä�� �����ڿ� ���� ���������� �ʹ� ū������ ����.
 */

package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A12865 {
	
	//�Է��� ��������
	/*
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		
		//��� �ִ� ��ǰ ��
		int n = Integer.parseInt(st.nextToken());
		
		//��� �ִ� ���� ��
		int k = Integer.parseInt(st.nextToken());
		
		//������ �迭�� ���� �� �� ������ �� ������ ������ �и�
		//�� ������ ����
		int[] w = new int[n + 1];
		
		//�� ������ ��ġ
		int[] v = new int[n + 1];
		
		//ù �迭�� �������� ����ϱ� ���� 1�� �� ũ�� ����
		int dp[] = new int[k+1];
		
		//0�� 0���� �������� �����
		//i: ��ǰ, j: ����
		//��� �ִ� ��ǰ�� ����ŭ �ݺ�
		for (int i = 1; i <= n; i++) {
			//�Է��� ���� �������� ����
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
			
			//���� �Ѱ�ġ�� ���� ���������� �ݺ�
			for (int j = k; j - w[i] >= 0; j--) {
				//Math.max�� ������ ������ ���� ����
				//���� ����� ��ġ�� (���� ������ ��ġ + �ڽ��� ��ġ) �� ū ���� ����
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

	//�Է��� �� �ް� ���� ������
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		st = new StringTokenizer(br.readLine());
		
		//��� �ִ� ��ǰ ��
		int n = Integer.parseInt(st.nextToken());
		
		//��� �ִ� ���� ��
		int k = Integer.parseInt(st.nextToken());
		
		//������ �迭�� ���� �� �� ������ �� ������ ������ �и�
		//�� ������ ����
		int[] w = new int[n + 1];
		
		//�� ������ ��ġ
		int[] v = new int[n + 1];
		
		//����, ��ġ �Է¹ޱ�
		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
		
		//ù �迭�� �������� ����ϱ� ���� 1�� �� ũ�� ����
		int dp[] = new int[k+1];
		
		//0�� 0���� �������� �����
		//i: ��ǰ, j: ����
		//��� �ִ� ��ǰ�� ����ŭ �ݺ�
		for (int i = 1; i <= n; i++) {
			//���� �Ѱ�ġ�� ���� ���������� �ݺ�
			for (int j = k; j - w[i] >= 0; j--) {
				//Math.max�� ������ ������ ���� ����
				//���� ����� ��ġ�� (���� ������ ��ġ + �ڽ��� ��ġ) �� ū ���� ����
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
