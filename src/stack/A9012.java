/*
 * 스택 9012 문제
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
        int input = Integer.parseInt(br.readLine());	//몇개를 입력받을지 저장
        String data;	//()저장 변수
        int dataLength;	//위 변수 길이 저장 변수
        Stack<Integer> vps;	//vps 스택
        char vpsCheck;	//vps 포인터
        boolean check = false;	//vps인지 아닌지 결과 체크
        for (int i = 0; i < input; i++) {
        	data = br.readLine();	//() 저장
        	dataLength = data.length();
            vps = new Stack<>();
            for (int j = 0; j < dataLength; j++) {
            	vpsCheck = data.charAt(j);	//data의 j번째 위치에 있는 
            	try {	//속도 면에서 안좋지만... 통과하니까 쓴다.
					if (vpsCheck == '(') {	// ( 일때
					vps.push(1);	// 스택에 추가
					} else if (vpsCheck == ')') {	// ) 일때
						vps.pop();	// 스택에서 뺴내기
					}
					check = vps.empty();	//스택이 비었는지 체크 비었으면 true
				} catch (Exception e) {	//마지막이 (가 되면 빈 스택에서 뽑으려고 하는것이므로 에러처리
					// TODO: handle exception
					check = false;	// 체크 값을 false로
					break;	// for문에서 나오게 함
				}
			}
            
            if (check == true) {	//check가 true이면 YES 출럭 버퍼에 저장
                bw.write("YES");
                bw.write("\n");
            } else {	//check가 false이면 NO 출력 버퍼에 저장
                bw.write("NO");
                bw.write("\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}

