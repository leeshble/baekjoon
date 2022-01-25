/*
 * ���� 9012 ����
 * Memory: 30864KB
 * Time: 132ms
 */
package stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class A9012 {
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());	//��� �Է¹����� ����
        String data;	//()���� ����
        int dataLength;	//�� ���� ���� ���� ����
        Stack<Integer> vps;	//vps ����
        char vpsCheck;	//vps ������
        boolean check = false;	//vps���� �ƴ��� ��� üũ
        for (int i = 0; i < input; i++) {
        	data = br.readLine();	//() ����
        	dataLength = data.length();
            vps = new Stack<>();
            for (int j = 0; j < dataLength; j++) {
            	vpsCheck = data.charAt(j);	//data�� j��° ��ġ�� �ִ� 
            	try {	//�ӵ� �鿡�� ��������... ����ϴϱ� ����.
					if (vpsCheck == '(') {	// ( �϶�
					vps.push(1);	// ���ÿ� �߰�
					} else if (vpsCheck == ')') {	// ) �϶�
						vps.pop();	// ���ÿ��� ������
					}
					check = vps.empty();	//������ ������� üũ ������� true
				} catch (Exception e) {	//�������� (�� �Ǹ� �� ���ÿ��� �������� �ϴ°��̹Ƿ� ����ó��
					// TODO: handle exception
					check = false;	// üũ ���� false��
					break;	// for������ ������ ��
				}
			}
            
            if (check == true) {	//check�� true�̸� YES �ⷰ ���ۿ� ����
                bw.write("YES");
                bw.write("\n");
            } else {	//check�� false�̸� NO ��� ���ۿ� ����
                bw.write("NO");
                bw.write("\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

