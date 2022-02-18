package bt_search;

/*
* 각 나무를 위에서부터 잘라내는 방식
* 각 나무를 자르고 난 뒤 자른 나무들의 길이의 합이 목표로 하는 길이보다 길면 min값을 높이는 방식
* 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A2805 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());	// 나무 갯수
		int m = Integer.parseInt(st.nextToken());	// 가져가려고 하는 길이
		
		// n값만큼 배열 생성
		int[] tree = new int[n];
		int min = 0;
		int max = 0;
		
		// 입력받은 나무가 더 큰 경우 max에 저장
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(max < tree[i]) {
				max = tree[i];
			}
		}
		// 이분탐색
		// max값이 min값보다 작으면 루프 종료
		while(min < max) {
			// 중간을 자르는 위치로 한다
			int cutHeight = (min + max) / 2;
			long sum = 0;
			for(int treeHeight : tree) {
				// 나무의 자른 길이는 mid에서 나무 높이를 빼주고 sum에 더함
				// 나무가 자르는 위치보다 작아서 -가 나올 경우는 제외한다
				if(treeHeight - cutHeight > 0) { 
					sum += (treeHeight - cutHeight);
				}
			}
			// sum값보다 가져가려고 하는 길이가 더 크면 자르는 위치를 낮춘다
			if(sum < m) {
				max = cutHeight;
			}
			// 이외의 경우에는 자르는 길이를 높힌다
			else {
				min = cutHeight + 1;
			}
		}
		// 결과 값은 -1해서 출력
		System.out.println(min - 1);		
	}

}
