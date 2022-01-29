package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class A2800 {

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
			//System.out.println("pointBianry "+pointBinary);
			Stack<Integer> deleteStack = new Stack<>();
			
			//get index for delete
			for (int j = 0; j < stackSize; j++) {
				if (pointBinary.charAt(j) == '1') {
					deleteStack.push((int)stack1Array[j]);
					deleteStack.push((int)stack2Array[j]);
				}
			}
			//System.out.println("delete1Stack "+delete1Stack);
			//System.out.println("delete2Stack "+delete2Stack);
			
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
