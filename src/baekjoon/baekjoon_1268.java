package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class baekjoon_1268 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
//		1단계
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][5];			//행 : 학생수 , 열 :1~5학년
		int[] sameClassRoom = new int[n];		// 학생별 같은 반이였던 학생 수
		int maxStudent = 0;					// 같은 반이였던 학생 수 최대값
		int answer =0;
	
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++ ) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {			// 비교할 대상이 되는 학생을 지목
			Set<Integer> sameClass = new  HashSet<>();
// 		Set - HashSet을 이용해 해결 : 중복을 허락하지 않고 순서와 관계없이 정렬
//			중복을 허락하지 않음
			for(int j=0; j<5; j++) {		//비교할 대상의 학년별로 선택한 열
				for(int k=0; k<n; k++) {		// i와 j의 학생과 학년별로 모든 학생을 탐색
					if(arr[i][j] == arr[k][j] && k != i) {
						sameClass.add(k);
					}
				}
			}
			if(maxStudent < sameClass.size()) {
				maxStudent = sameClass.size();
				answer = i;
			}
		}
		
		System.out.println(answer+1);
		br.close();
		
	}
}
