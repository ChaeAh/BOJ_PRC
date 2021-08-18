package baekjoon;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//n킬로그램n
		//3kg 5kg
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		int x=0;	//박스의 수 
		while(true) {
			if(input % 5==0) {
				x+= input /5;
				System.out.println(x);
				break;
			}
			input = input-3;
			x++;
			if(input <0) {
			System.out.println("-1");
			break;
			}
		}
	}
}
