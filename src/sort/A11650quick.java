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
		int pivot = array[(start + end) / 2];	//pivot�� �� ���� ���� ����
		int temp;
		
		while (i <= j) {

			//pivot�� �� ������ start�� �� ���� ���� ��� start�� ��ġ�� �ڷ� �̵�
			while (array[i] < pivot) {
				i++;
			}
			
			//pivot�� �� ������ end�� �� ���� Ŭ ��� end�� ��ġ�� ������ �̵�
			while (array[j] > pivot) {
				j--;
			}

			//start�� end�� �ڸ� ����
			if (i <= j) {
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
		

		// ���� ����Ʈ
		if (start < j) {
			quickSort(array, start, j);
		}
		
		// ������ ����Ʈ
		if (end > i) {
			quickSort(array, i, end);
		}
	}
}
