package queue;

import java.util.LinkedList;
import java.util.Scanner;

public class A1966 {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, m, count; // m�� �ε����� 0����
        
        LinkedList<Integer> queueIndex;	//�ε����� ������ ť
        LinkedList<Integer> queueData;	//�����͸� ������ ť
        
        int times = scan.nextInt();
        for(int i = 0; i < times; i++) {
        	
            queueIndex = new LinkedList<>();
            queueData = new LinkedList<>();
            
            //�� ��°���� üũ
            count = 0;
            
            //n, m�� �Է¹ޱ�
            n = scan.nextInt();
            m = scan.nextInt();
            
            //ť�� �Է� �� ����
            for(int j = 0; j < n; j++) {
            	queueIndex.add(j);
            	queueData.add(scan.nextInt());
            }
            
            // ť�� �����Ͱ� ���������� �ݺ�(���ؽ��� ������ �ΰ� ��� ���ÿ� �����ϹǷ� Index ����)
            while(!queueIndex.isEmpty()){
            	
                boolean stat = true;
                
                //���� ���� ������ �� ť �� ������ �� temp�� ����
                int tempIndex = queueIndex.poll();
                int tempData = queueData.poll();
                
                //ť�� �� �� ���ؼ� ��� ��
                int queueSize = queueIndex.size();
                for (int j = 0; j < queueSize; j++) {
                	//ť ������ �߿䵵�� tempData���� ũ�� stat�� �Ұ�������
                    if(queueData.get(j) > tempData) {
                    	stat = false;
                    }
                }
                
                //stat�� true�� ��� ������
                if (stat) {
                	//��� ���� ����
                    count++;
                    //tempIndex ���� ���� ����ڰ� �ñ��� ��° ���� ������ ���� ����
                    if (tempIndex == m) {
                    	break;
                    }
                } else {
                	//ť �ڿ� �ٽ� ����
                	queueIndex.add(tempIndex);
                	queueData.add(tempData);
                }
            }
            
            //���
            System.out.println(count);
        }
    }
}
