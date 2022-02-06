package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class A1991 {

	static StringBuilder sb = new StringBuilder();
	static Map<String, List<String>> tree = new HashMap<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		List<String> nodeList;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			nodeList = new ArrayList<String>();
			String key = st.nextToken();
			String node1 = st.nextToken();
			String node2 = st.nextToken();
			nodeList.add(node1);
			nodeList.add(node2);
			tree.put(key, nodeList);
		}
		preOrder("A");
		sb.append("\n");
		inOrder("A");
		sb.append("\n");
		postOrder("A");
		System.out.print(sb);
	}

	static void preOrder(String node) {
		if (node.equals(".")) {
			return;
		} else {
			sb.append(node);
			preOrder(tree.get(node).get(0));
			preOrder(tree.get(node).get(1));
		}
	}

	static void inOrder(String node) {
		if (node.equals(".")) {
			return;
		} else {
			inOrder(tree.get(node).get(0));
			sb.append(node);
			inOrder(tree.get(node).get(1));
		}
	}

	static void postOrder(String node) {
		if (node.equals(".")) {
			return;
		} else {
			postOrder(tree.get(node).get(0));
			postOrder(tree.get(node).get(1));
			sb.append(node);
		}
	}

}
