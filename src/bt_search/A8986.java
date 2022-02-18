package bt_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class A8986 {

	static int[] xCoord;
	static int[] dist;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		xCoord = new int[n];
		for (int i = 0; i < n; i++) {
			xCoord[i] = Integer.parseInt(st.nextToken());
		}
		dist = new int[n - 1];
		
		for (int i = 0; i < n-1; i++) {
			dist[i] = Math.abs(xCoord[i] - xCoord[i + 1]);
		}
		System.out.println(Arrays.toString(dist));
		int[] distDiff = new int[n-1];
		for (int i = 0; i < distDiff.length; i++) {
			Queue<Integer> diff = new LinkedList<>();
			for (int j = 0; j < n - 1; j++) {
				diff.add(Math.abs(dist[i] - dist[j]));
			}
			System.out.println("diff" + diff);
			distDiff[i] = Collections.max(diff);
			System.out.println(dist[i]+" "+Arrays.toString(distDiff));
		}
		System.out.println(Arrays.toString(distDiff));
		Arrays.sort(distDiff);
		System.out.println(distDiff[0]);
	}
}
