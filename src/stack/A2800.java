package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Stack;

public class A2800 {
	
	static StringBuilder sb;
	static Stack<Integer> stack;
	static HashSet<String> outputData;
	static boolean[] check;
	static int[] pair;
	static String input;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		//입력받기
		input = br.readLine();
		
		int inputLength = input.length();
		pair = new int[inputLength];	//괄호의 
		check = new boolean[inputLength];
		stack = new Stack<>();
		
		for (int i = 0; i < inputLength; i++) {
			char pointer = input.charAt(i);
			if(pointer == '(') {
				stack.push(i);
			} else if (pointer == ')') {
				pair[i] = stack.peek();
				pair[stack.peek()] = i;
				stack.pop();
			}
		}
		
		outputData = new HashSet<>();
		dfs(0, inputLength);
		ArrayList<String> outputSorted = new ArrayList<>(outputData);
		Collections.sort(outputSorted);
		
		String[] output = outputSorted.toArray(new String[0]);
		int outputLength = output.length;
		for (int i = 1; i < outputLength; i++) {
			sb.append(output[i]).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static void dfs(int deptNow, int dept) {
		if (deptNow != dept) {
			char ch = input.charAt(deptNow);
	        if(ch == '(') {
	            check[deptNow] = true;
	            dfs(deptNow+1, dept);  // 해당 쌍의 괄호를 지우는 경우
	            check[deptNow] = false;
	        }

	        if(ch == ')' && check[pair[deptNow]]) {  // 나와 쌍인 '('가 지워져있는지 체크
	            check[deptNow] = true;  // 사실 이어져있는 괄호 쌍은 하나뿐이라 여기서 굳이 check 건드릴 필요는 없긴 함
	            dfs(deptNow + 1, dept);
	            check[deptNow] = false;
	        }else {  // 괄호 안 지우는 경우 or 숫자일 경우
	            sb.append(ch);
	            dfs(deptNow + 1, dept);
	            sb.deleteCharAt(sb.length() - 1);
	        }
		} else {
			outputData.add(sb.toString());
			return;
		}
	}

}
