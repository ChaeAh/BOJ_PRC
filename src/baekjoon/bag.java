package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//여행에 필요하다고 생각하는 N개의 물건
//물건은 무게W와 가치 V를 가짐 
//물건들의 가치의 최댓값
//	물품의 수 N 와 준서가 버틸수 있는 무게 K
//배낭문제의 경우 조합 최적화 문제이다. 짐을쪼갤수 있는 경우와 짐을 쪼갤수 없는 경우
/*
짐을 쪼갤 수 있는 배낭문제를 Fraction Knapsack Problem 이라 하고, 
짐을 쪼갤 수 없는 배낭문제를 0/1 Knapsack Problem 이라 한다. 알고리즘 또한 다르게 적용하는데, 
Fraction Knapsack Problem 의 경우 탐욕 알고리즘(Greedy)을 쓰며, 0/1 Knapsack Problem의 경우 DP 법을 쓴다.	 
*/

public class bag {
	
	static int dp[][];	// i번째 가방까지 살펴봤을때, j 무게일때 담을 수 있는 물건들의 최대 합
	static int N, K;	// N : 물건의 갯수, K : 가방에 담을 수 있는 물건들의 무게 합
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	// w : i번째 물건의 무게 v : i번째 물건의 가치
	
	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[N+1][K+1];
		
		int w, v;	// i번째 물건의 무게, i번째 물건의 가치
//		dp[i][j] 에서 j가 w보다 가벼울때는 i번째  물건을 가방에 담을수 없으므로 이전 dp의 가치를 그대로 할당한다.
//		이전 행에는 j무게일때 담은 물건들의 최대 가치 값이 할당되어 있다.
			
//			dp[i][j]에서 j가 무게와 같거나 무거울때는 n번째 물건을 담을 수 있다. 이때 j  = j-n+n임을 생각하자.
			
//			n번째 물건의 가치 값(v) + 이전 행의 j-n번 열의 가치값(dp[i-1][j-n])이 이전행에서 j무게일때 담은 물건의 최대 가치값(dp[i-1][j]) 보다 크다면
//			같은 무게에 더 큰 가치를 담을 수 있으므로 dp[i][j]= v + dp[i-1][j-n]이 된다.
//			v + dp[i-1][j-n]이 dp[i-1][j]보다 작거나 같다면 dp[i-1][j]를 그대로 dp[i][j]에 할당한다.
			
//			dp가 완성되면 dp[N][K]는 N번째 가방까지 있다고 가정했을때, K무게 이하에서 담을 수 있는 물건의 최대가치 값	
		
		/*
		* 물품의 수 : 4 최대 버틸수 있는값 : 7
		4 7
		무게 가치
		6 		13
N2	4 		8
		3 		6
		5 		12
		* */	
/*
 	   1  2  3  4  5  6  7
 1    0  0  0  0 0 13 13
 2   0  0  0  8 8 13 14 
 3   0  0  6  8 8 13 14 
 4   0  0  6  8 12 13 14 
 최대무게 = 7 의 경우,
N2 일때 남은 무게가 최대무게 (7) - N2의 무게(4) 로 3의 무게가 남게 된다.
이때, 남은 무게3은 N3의 무게가 된다.
여기서 N2의 가치는 두 가지를 선택 할 수 있다.
- 1. N2의 무게 4일 때의 가치 + 남은 무게(N3)의 가치 -> 14
- 2. N1의 가치 -> 13
이 중에 큰 것으로 정하면 되는데, 첫 번째 경우가 크므로 14의 가치를 갖게 된다.
N3, N4도 같은 가치를 갖게 된다.
 * */		
		
		st = new StringTokenizer(br.readLine());
		w = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=N; i++) {	//물건의 갯수
			for(int j=0; j<= K; j++) {	//물건의 총합까지
				// Math.max() -> 두 인자 중 큰 값을 리턴하는 함수
				dp[i][j] = j < w ? dp[i-1][j] : Math.max(v+dp[i-1][j-w], dp[i-1][j]);
			}
		}
		
		System.out.println(dp[N][K]);
		
	}
}
