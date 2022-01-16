/*
 * �� ����
 * 
 * Memory: 14484KB
 * Time: 132ms
 */

package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A2750quick {

	static int input;
	static int array[];
	
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
		quickSort(0, input - 1);
		for (int val : array) {
			sb.append(val).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void quickSort(int start, int end) {
		int i = start;
		int j = end;
		int pivot = array[(start + end) / 2];	//pivot�� �� ���� ���� ����
		int temp;
		
		//start, end ���� end, start ���� �ɋ����� �ݺ�
		while (i <= j) {
			
			//pivot�� �� ������ start�� �� ���� ū ��Ȳ�϶����� start�� ��ġ�� �ڷ� �̵�
			while (array[i] < pivot) {
				i++;
			}
			
			//pivot�� �� ������ end�� �� ���� ���������� end�� ��ġ�� ������ �̵�
			while (array[j] > pivot) {
				j--;
			}

			//���� ��, �������� ū�� ������ ã�Ҵٸ� start�� end�� �ڸ� ���� (SWAP)
			if (i <= j) {
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				//start�� end�� ���� �� ������ �̵���Ų��
				i++;
				j--;
			}
		}
		

		// ��Ƽ���� ������ ���� ������ ����Ʈ ��Ű��
		if (start < j) {
			quickSort(start, j);
		}
		
		
		if (end > i) {
			quickSort(i, end);
		}
	}
	
	/*
	//start, end, pivot ���ϱ�
	static void quickSort(int start, int end) {
		
		// start�� end���� ũ�ų� ������ ������
		if (start >= end) {
			return;
		}
		
		// pivot ���ϱ�
		int pivot = partition(start, end);
		
		// ���� ����Ʈ
		quickSort(start, pivot -1);
		
		// ������ ����Ʈ
		quickSort(pivot, end);
	}
	
	
	static int partition(int start, int end) {
		
		//pivot�� �� ���� ���� ����
		int pivot = array[(start + end) / 2];
		
		//start�� end���� �۰ų� ���������� �ݺ�
		while (start <= end) {
			
			//pivot�� �� ������ start�� ���� ���� ��� start�� ��ġ�� �ڷ� �̵�
			while (array[start] < pivot) {
				start++;
			}
			
			//pivot�� �� ������ end�� ���� Ŭ ��� end�� ��ġ�� ������ �̵�
			while (array[end] > pivot) {
				end--;
			}
			
			//start�� end�� �ڸ� ����
			if (start <= end) {
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
				start++;
				end--;
			}
		}
		//start�� ���ο� pivot���� return
		return start;
	}
	*/
}
