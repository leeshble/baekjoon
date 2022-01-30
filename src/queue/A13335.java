package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A13335 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		//�Է�
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	//Ʈ�� ��
		int w = Integer.parseInt(st.nextToken());	//�ٸ� ����
		int L = Integer.parseInt(st.nextToken());	//�ٸ� �ִ� ����
		
		Queue<Integer> truck = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			truck.add(Integer.parseInt(st.nextToken()));	//Ʈ�� ť�� �߰�
		}
		
		int time = 0;	//�ɸ��� �ð�
		int bridgeWeight = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < w; i++) {
			queue.add(0);
		}
		
		//�ٸ� ���� Ʈ���� ���������� �ݺ�
		while (!queue.isEmpty()) {
			time++;	//�ð� ����
			bridgeWeight -= queue.poll();	//�ٸ� ���Կ��� ���ֱ�
			if (!truck.isEmpty()) {
				if (L >= truck.peek() + bridgeWeight) {	//�ٸ� �ִ� ������ �߰� Ʈ���� �ö� ���ߺ��� ũ�� ����
					bridgeWeight += truck.peek();	//Ʈ�� ���� �߰�
					queue.add(truck.poll());
				} else {
					queue.add(0);
				}
			}
		}
		System.out.print(time);
		
	}

}
