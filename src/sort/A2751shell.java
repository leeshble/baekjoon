package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A2751shell {

	static int input;
	static int[] array;
	
	public static void main(String[] args) throws IOException{
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
		cellSort();
		for (int val : array) {
			sb.append(val).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void cellSort() {
		for (int gap = input / 2; gap > 0; gap /= 2) {	//처음엔 배열의 반을 나눈 값을 이용
			if (gap % 2 == 0) {	//짝수일 경우 
				gap++;
			}
			for (int i = 0; i < gap; i++) {
				insertionSort(i, input - 1, gap);
			}
		}
	}
	
	static void insertionSort(int first, int last, int gap) {
		int j, key;
		for (int i = first + gap; i <= last; i += gap) {
			key = array[i];
			for (j = i - gap; j >= first && array[j] > key; j -= gap) {
				array[j + gap] = array[j];
			}
			array[j + gap] = key;
		}
	}
	
}
