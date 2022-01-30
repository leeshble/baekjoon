package queue;

import java.util.LinkedList;
import java.util.Scanner;

public class A1966 {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, m, count; // m의 인덱스는 0부터
        
        LinkedList<Integer> queueIndex;	//인덱스를 저장할 큐
        LinkedList<Integer> queueData;	//데이터를 저장할 큐
        
        int times = scan.nextInt();
        for(int i = 0; i < times; i++) {
        	
            queueIndex = new LinkedList<>();
            queueData = new LinkedList<>();
            
            //몇 번째인지 체크
            count = 0;
            
            //n, m값 입력받기
            n = scan.nextInt();
            m = scan.nextInt();
            
            //큐에 입력 값 저장
            for(int j = 0; j < n; j++) {
            	queueIndex.add(j);
            	queueData.add(scan.nextInt());
            }
            
            // 큐에 데이터가 없을때까지 반복(인텍스와 데이터 두개 모두 동시에 삭제하므로 Index 기준)
            while(!queueIndex.isEmpty()){
            	
                boolean stat = true;
                
                //가장 먼저 보관한 각 큐 값 꺼내어 각 temp에 저장
                int tempIndex = queueIndex.poll();
                int tempData = queueData.poll();
                
                //큐에 든 값 비교해서 출력 비교
                int queueSize = queueIndex.size();
                for (int j = 0; j < queueSize; j++) {
                	//큐 데이터 중요도가 tempData보다 크면 stat을 불가능으로
                    if(queueData.get(j) > tempData) {
                    	stat = false;
                    }
                }
                
                //stat이 true일 경우 프린팅
                if (stat) {
                	//출력 번수 증가
                    count++;
                    //tempIndex 안의 값이 사용자가 궁금한 번째 수와 같으면 루프 정지
                    if (tempIndex == m) {
                    	break;
                    }
                } else {
                	//큐 뒤에 다시 삽입
                	queueIndex.add(tempIndex);
                	queueData.add(tempData);
                }
            }
            
            //출력
            System.out.println(count);
        }
    }
}
