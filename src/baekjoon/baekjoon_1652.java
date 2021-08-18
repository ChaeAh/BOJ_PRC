package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class baekjoon_1652 {

		final static char EMPTY = '.';
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		char[][] array = new char[N+1][N+1];
		int result=0;
		int seat = 0;
		for(int i=0; i<N; i++) {
			char[] charArr = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				array[i][j] = charArr[j];
			}
		}
		System.out.println(Arrays.deepToString(array));
		System.out.println(Arrays.toString(array));
		br.close();
		solution(N, array);
	}
	
	private static void solution(int N, char[][] array) {
		StringBuffer sb = new StringBuffer();
		sb.append(getHorizontal(N,array)).append(" ");
		sb.append(getVertical(N, array));
		System.out.println(sb.toString());
	}

	private static int getVertical(int n, char[][] array) {	//세로
		boolean[][] visit = new boolean[n+1][n+1];
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
			//	System.out.println(visit[j][i] + "세로");
				if(array[j][i] == EMPTY && !visit[j][i]) {
					visit[j][i] = true;
					int next = j+1;
					while(array[next][i] == EMPTY) {
						visit[next][i] = true;
						next++;
					}
					if(visit[j+1][i] ) answer++;
				}
			}
		}
		
		
		return answer;
	}

	private static int getHorizontal(int n, char[][] array) {	//가로
		boolean[][] visit = new boolean[n+1][n+1];
		int answer = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
		//	System.out.println(!visit[i][j] + "가로");
				if(array[i][j] == EMPTY && !visit[i][j]) {
					visit[i][j] = true;
					int next =j+1;
					while(array[i][next] == EMPTY) {
						visit[i][next] = true;
						next++;
					}
					if(visit[i][j+1]) answer++;
					
				}
			}
		}
		
		return answer;
	}
	
	
}
