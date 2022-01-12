/*
 * 2750 ����
 * N���� ���� �־����� ��, �̸� ������������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�.
 * 
 * ��������
 * 
 * Memory: 14476KB
 * Time: 144ms
 */

package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A2750 {

	static int input;
	static int[] array;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		input = Integer.parseInt(br.readLine());
		array = new int[input];
		for (int i = 0; i < input; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		selectionSort();
		for (int val : array) {
			sb.append(val).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void selectionSort() {
		int min, temp;
		for (int i = 0; i < input - 1; i++) {
			//�ּ� ���� �ִ� index��  i�� ����
			min = i;
			for (int j = i + 1; j < input; j++) {
				//���� ������ ������ �ش� index�� �ּҷ� ����
				if (array[j] < array[min]) {
					min = j;
				}
			}
			//�ּ� ���� temp�� ����
			temp = array[min];
			//�ּ� ���� �ִ� �ڸ��� i��° ������ �ڸ��� ���� ����
			array[min] = array[i];
			array[i] = temp;
		}
	}
}
