package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class plusCycle {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		if(n <10) {
			n *=10;
		}
		//26
		int sum = n;
		int left,right, cnt = 0;
		while(true) {
			left = sum /10;//2
			right = sum %10;//6
			sum = left + right;	//8
			
			sum = right *10 + sum% 10; 
			cnt++;
			if(sum == n) {
				break;
			}
		}
		System.out.println(cnt);
	}
}
