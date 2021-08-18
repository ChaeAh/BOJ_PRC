package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1032 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] str = new String[N];
		StringBuilder pattern = new StringBuilder();
		boolean result= true;
		
		for(int i=0; i<N; i++) {
			str[i] = br.readLine();
		//	System.out.println(str[i]);
		}

		for(int i=0; i<str[0].length(); i++) {
			for(int j=1; j<N; j++) {
				if(str[0].charAt(i) == str[j].charAt(i)) {
					result = true;
				}else {
					result = false;
					break;
				}
			}
			
			if(!result) {
				pattern.append("?");
			}else {
				pattern.append(str[0].charAt(i));
			}
		}
		
		System.out.println(pattern.toString());
		
	}
}
