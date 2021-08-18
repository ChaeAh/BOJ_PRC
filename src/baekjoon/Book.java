package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Book {

	static int maxOf(int []a) {
		int max = a[0];
		
		for(int i=0; i<a.length; i++) {
			if(max < a[i]) {
				max = a[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] heigth = new int[num];
		
		
		for(int i=0; i<num; i++) {
			System.out.print("height [" + i + "]");
			heigth[i] =Integer.parseInt(br.readLine());
		}
		
		System.out.println("최댓값은" + maxOf(heigth) + "이다");
	}
}
