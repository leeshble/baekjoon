package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class A4963 {
	static int w;
	static int h;
	static int[][] map;
	static boolean[][] check;
	static int[] searchX = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
	static int[] searchY = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break;

			map = new int[w + 2][h + 2];
			check = new boolean[w + 2][h + 2];
			for (int i = 1; i < w + 1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < h + 1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int count = 0;
			for (int i = 1; i < w; i++) {
				for (int j = 1; j < h; j++) {
					if (map[i][j] == 1 && !check[i][j]) {
						searchIsland(i, j);
						count++;
					}
				}
			}
			System.out.print(count);
			System.out.print("\n");
		}
		br.close();
	}

	static void searchIsland(int i, int j) {
		for (int j2 = 0; j2 < 8; j2++) {
			int x = i + searchX[j2];
			int y = j + searchY[j2];

			if (map[x][y] == 1 && !check[x][y])
				searchIsland(x, y);
		}
	}
}
