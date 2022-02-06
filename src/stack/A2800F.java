package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class A2800F {

	/*
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // 괄호 위치 큐에 저장
        Map<Integer, Integer> paren = new HashMap<>();
        List<Integer> parenIdx = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                s.push(i);
                parenIdx.add(i);
            }else if(input.charAt(i) == ')') {
                paren.put(s.pop(), i);
            }
        }
        Set<String> set = new HashSet<>();

        for (int i = 1; i < (1 << parenIdx.size()); i++) {
            StringBuilder sb = new StringBuilder();
            Map<Integer, Integer> idx = new HashMap<>();

            // 부분집합 만들기
            for (int j = 0; j < parenIdx.size(); j++) {
                if ((i & (1 << j)) != 0) {
                    idx.put(parenIdx.get(j), paren.get(parenIdx.get(j)));
                }
            }

            for (int k = 0; k < input.length(); k++) {
                // 빼야 할 괄호
                if (input.charAt(k) == '(' && idx.containsKey(k)) continue;
                if (input.charAt(k) == ')' && idx.containsValue(k)) continue;

                sb.append(input.charAt(k));
            }
            set.add(sb.toString());
        }
        List<String> output = new ArrayList(set);

        output.sort(Comparator.naturalOrder());
        for(int i = 0; i < output.size(); i++)
            System.out.println(output.get(i));
    }*/
	
	static Stack<Integer> stack1;
	static Stack<Integer> stack2;
	static HashSet<String> outputHash = new HashSet<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String data;
		int dataLength;
		char pointer;
		
		data = br.readLine();
		br.close();
		dataLength = data.length();
		stack1 = new Stack<>();
		stack2 = new Stack<>();
		for (int i = 0; i < dataLength; i++) {
			pointer = data.charAt(i);
			if (pointer == '(') {
				stack1.push(i);
			} else if (pointer == ')') {
				stack2.push(i);
			}
		}
		int stack1Size = stack1.size();
		String maxBinary = maxBinaryMaker(stack1Size);
		int maxBinaryInteger = Integer.parseInt(maxBinary, 2);
		deleteBrackets(stack1Size, maxBinaryInteger, data, dataLength);
		
		String[] output = outputHash.toArray(new String[0]);
		StringBuilder sb = new StringBuilder();
		int outputLength = output.length;
		for (int i = outputLength - 1; i >= 0; i--) {
			sb.append(output[i]).append("\n");
		}
		System.out.print(sb.toString());
	}
	
	static String maxBinaryMaker(int i) {
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < i; j++) {
			sb.append("1");
		}
		return sb.toString();
	}
	
	static String leftBinaryMaker(int maxSize, String pointBinary) {
		StringBuilder sb = new StringBuilder();
		int leftLength = maxSize - pointBinary.length();
		for (int i = 0; i < leftLength; i++) {
			sb.append(0);
		}
		sb.append(pointBinary);
		return sb.toString();
	}
	
	static void deleteBrackets(int stackSize, int maxBinaryInteger, String data, int dataLength) {
		Object[] stack1Array = stack1.toArray();
		Object[] stack2Array = new Object[stackSize];
		//stack2 reverse
		for (int i = stackSize - 1, j = 0; i >= 0; i--, j++) {
			stack2Array[j] = stack2.elementAt(i);
		}
		
		for (int i = 0; i < maxBinaryInteger; i++) {
			String pointBinary = leftBinaryMaker(stackSize, Integer.toBinaryString(i + 1));
			Stack<Integer> deleteStack = new Stack<>();
			
			//get index for delete
			for (int j = 0; j < stackSize; j++) {
				if (pointBinary.charAt(j) == '1') {
					deleteStack.push((int)stack1Array[j]);
					deleteStack.push((int)stack2Array[j]);
				}
			}
			
			//start delete
			String[] outputData = new String[dataLength];
			outputData = data.split("");
			int deleteStackSize = deleteStack.size();
			for (int j = 0; j < deleteStackSize; j++) {
				outputData[deleteStack.elementAt(j)] = "";
			}
			String output = String.join("", outputData);
			
			//add to hash for delete duplicate output
			outputHash.add(output.toString());
		}
	}
}
