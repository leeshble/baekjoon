/*
 * 퀵 정렬
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
		int pivot = array[(start + end) / 2];	//pivot에 든 값을 값을 저장
		int temp;
		
		//start, end 순이 end, start 순이 될떄까지 반복
		while (i <= j) {
			
			//pivot에 든 수보다 start에 든 값이 큰 상황일때까지 start의 위치를 뒤로 이동
			while (array[i] < pivot) {
				i++;
			}
			
			//pivot에 든 수보다 end에 든 값이 작을때까지 end의 위치를 앞으로 이동
			while (array[j] > pivot) {
				j--;
			}

			//각각 좌, 우측에서 큰값 작은값 찾았다면 start와 end의 자리 변경 (SWAP)
			if (i <= j) {
				temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				//start와 end를 각각 뒤 앞으로 이동시킨다
				i++;
				j--;
			}
		}
		

		// 파티션을 나누어 왼쪽 오른쪽 퀵소트 시키기
		if (start < j) {
			quickSort(start, j);
		}
		
		
		if (end > i) {
			quickSort(i, end);
		}
	}
	
	/*
	//start, end, pivot 정하기
	static void quickSort(int start, int end) {
		
		// start가 end보다 크거나 같을때 끝내기
		if (start >= end) {
			return;
		}
		
		// pivot 정하기
		int pivot = partition(start, end);
		
		// 왼쪽 퀵소트
		quickSort(start, pivot -1);
		
		// 오른쪽 퀵소트
		quickSort(pivot, end);
	}
	
	
	static int partition(int start, int end) {
		
		//pivot에 든 값을 값을 저장
		int pivot = array[(start + end) / 2];
		
		//start가 end보다 작거나 같을때까지 반복
		while (start <= end) {
			
			//pivot에 든 수보다 start의 값이 작을 경우 start의 위치를 뒤로 이동
			while (array[start] < pivot) {
				start++;
			}
			
			//pivot에 든 수보다 end의 값이 클 경우 end의 위치를 앞으로 이동
			while (array[end] > pivot) {
				end--;
			}
			
			//start와 end의 자리 변경
			if (start <= end) {
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
				start++;
				end--;
			}
		}
		//start를 새로운 pivot으로 return
		return start;
	}
	*/
}
