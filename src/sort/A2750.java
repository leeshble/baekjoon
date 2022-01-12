/*
 * 2750 문제
 * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
 * 
 * 선택정렬
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
			//최소 값이 있는 index를  i로 지정
			min = i;
			for (int j = i + 1; j < input; j++) {
				//기준 값보다 작으면 해당 index를 최소로 지정
				if (array[j] < array[min]) {
					min = j;
				}
			}
			//최소 값을 temp에 넣음
			temp = array[min];
			//최소 값이 있던 자리와 i번째 숫자의 자리를 서로 변경
			array[min] = array[i];
			array[i] = temp;
		}
	}
}
