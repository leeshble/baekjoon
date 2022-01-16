/*
 * 삽입정렬
 * 
 * Memory: 14492KB
 * Time: 148ms
 */

package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class A2750insertion {
	
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
		insertionSort();
		for (int val : array) {
			sb.append(val).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	static void insertionSort() {
		int key; //key를 담는 곳
		int j = 0;	//비교할 숫자 index
        for(int i = 1; i < input; i++){
            key = array[i]; //key값 담기
            //현재 기준 이전꺼 탐새하기 위해 -1
            for(j = i - 1; j >= 0 && key < array[j]; j--){	//0과 같거나 크고 key가 비교할 숫자보다 작을때 반복문 끝
            	array[j+1] = array[j]; // 비교 숫자를 뒤로 이동
            }
            array[j+1] = key; //탐색이 종료된 곳에 key를 넣음
        }
	}
}
