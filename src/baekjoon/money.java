package baekjoon;

import java.util.Scanner;

public class money {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int change = 1000 - scan.nextInt();
		
		int[] coins = {500,100,50,10,5,1};
		int result= 0;
		
		for(int i=0; i<coins.length; i++) {
			if(change <coins[i]) {
				continue;
			//	result += change / coins[i];
		//		change = change % coins[i];
			}
		}
		
   /*     for(int coin : coins){

            if (coin > change)
                continue;
            result += change / coin;
            change %= coin;

        }*/
		
		System.out.println("동전갯수 :" + result);
		System.out.println("거스름돈 :" + change);
	}


}
