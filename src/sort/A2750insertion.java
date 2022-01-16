/*
 * ��������
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
		int key; //key�� ��� ��
		int j = 0;	//���� ���� index
        for(int i = 1; i < input; i++){
            key = array[i]; //key�� ���
            //���� ���� ������ Ž���ϱ� ���� -1
            for(j = i - 1; j >= 0 && key < array[j]; j--){	//0�� ���ų� ũ�� key�� ���� ���ں��� ������ �ݺ��� ��
            	array[j+1] = array[j]; // �� ���ڸ� �ڷ� �̵�
            }
            array[j+1] = key; //Ž���� ����� ���� key�� ����
        }
	}
}
