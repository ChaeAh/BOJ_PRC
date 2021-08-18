package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_10871 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb= new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());	// N
		int X = Integer.parseInt(st.nextToken());	// X
		
		 st = new StringTokenizer(br.readLine(), " ");
		 
		for(int i=0; i<N; i++) {
			int comp = Integer.parseInt(st.nextToken());
			if( comp <X) {
			sb.append(comp).append(" ");
			}
		}
		System.out.println(sb.toString());
		
	}
}
