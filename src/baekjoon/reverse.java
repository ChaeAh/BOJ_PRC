package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class reverse {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			sb.append(br.readLine()).append("\n");
		}

		System.out.println(sb.reverse().toString());
	
	}
}