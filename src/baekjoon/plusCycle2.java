package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class plusCycle2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int target = n;
		int cnt = 0;
		do {
			int first = n /10;
			int second = n % 10;
			n = second * 10 + (first+second)%10;
			cnt++;
		}while( n != target);
		
		System.out.println(cnt);
		br.close();
	}
}
