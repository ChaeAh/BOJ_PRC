package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Flyme {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		// StringBuilder는 String과 문자열을 더할때 기존의 데이터에 더하는 방식을 사용하기 때문에'
		// 속도도 빠르고 상대적으로 부하가 적다. 따라서 긴문자열을 더하는 상황에서는 StringBuilder 사용
		
		int n =  Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			// StringTokenizer는 지정한 구분자로 문자열을 쪼개주는 클래스
			// 쪼개진 문자열을 우리는 토큰(token) 이라고 부른다.
			// haxMoreElements(), hasMoreTokens() - > 다음의 token을 반환 내부적으로 어떤위치의 토큰을 사용하였는지
			// Object nextElements() , String nextToken() -> 같은 객체를 반환하는데 반환형은 다르다.
			
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			int distance = Y-X;
			
			int max = (int) Math.sqrt(distance);
			
			if(max == Math.sqrt(distance)) {
				sb.append(max*2 -1).append('\n');
			}else if(distance <=max*max + max) {
				sb.append(max *2).append('\n');
			}else {
				sb.append(max*2 +1).append('\n'	);
			}
		}
		System.out.println(sb.toString());
	}
	
}
