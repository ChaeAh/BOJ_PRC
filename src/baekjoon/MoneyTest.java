package baekjoon;

import java.util.Scanner;

public class MoneyTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("입력하세요 : ");
        int change = 1000 - scanner.nextInt();
        int result = 0;

        int [] coins = {500,100,50,10,5,1};

        for(int coin : coins){

            if (coin > change)
                continue;
            result += change / coin;
            change %= coin;

        }
        System.out.println(result);
        System.out.println(change);
	}
}
