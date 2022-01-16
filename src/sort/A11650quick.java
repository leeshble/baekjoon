package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class A11650quick {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int input = Integer.parseInt(br.readLine());
		int[] array1 = new int[input];
		int[] array2 = new int[input];
		for (int i = 0; i < input; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			array1[i] = Integer.parseInt(st.nextToken());
			array2[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		
		quickSort(array1, 0, input - 1);
		quickSort(array2, 0, input - 1);
		
		for (int i = 0; i < input; i++) {
			sb.append(array1[i]).append(" ").append(array2[i]).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void quickSort(int[] array, int start, int end) {
		int i = start;
		int j = end;
		int pivot = array[(start + end) / 2];	//pivot에 든 값을 값을 저장
		int temp;
		
		while (i <= j) {

			//pivot에 든 수보다 start에 든 값이 작을 경우 start의 위치를 뒤로 이동
			while (array[i] < pivot) {
				i++;
			}
			
			//pivot에 든 수보다 end에 든 값이 클 경우 end의 위치를 앞으로 이동
			while (array[j] > pivot) {
				j--;
			}

			//start와 end의 자리 변경
			if (i <= j) {
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
		

		// 왼쪽 퀵소트
		if (start < j) {
			quickSort(array, start, j);
		}
		
		// 오른쪽 퀵소트
		if (end > i) {
			quickSort(array, i, end);
		}
	}
}
