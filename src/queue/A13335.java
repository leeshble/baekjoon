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
		
		//입력
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	//트럭 수
		int w = Integer.parseInt(st.nextToken());	//다리 길이
		int L = Integer.parseInt(st.nextToken());	//다리 최대 하중
		
		Queue<Integer> truck = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			truck.add(Integer.parseInt(st.nextToken()));	//트럭 큐에 추가
		}
		
		int time = 0;	//걸리는 시간
		int bridgeWeight = 0;
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < w; i++) {
			queue.add(0);
		}
		
		//다리 위에 트럭이 없을때까지 반복
		while (!queue.isEmpty()) {
			time++;	//시간 증가
			bridgeWeight -= queue.poll();	//다리 무게에서 빼주기
			if (!truck.isEmpty()) {
				if (L >= truck.peek() + bridgeWeight) {	//다리 최대 하중이 추가 트럭이 올라간 하중보다 크면 실행
					bridgeWeight += truck.peek();	//트럭 무게 추가
					queue.add(truck.poll());
				} else {
					queue.add(0);
				}
			}
		}
		System.out.print(time);
		
	}

}
