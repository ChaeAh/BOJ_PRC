package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class dd {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String k = br.readLine();
		
		String[] array = k.split(" ");
		String a = "";
		String b = "";
		/*배열의 갯수 한번에 연속적으로 골라야하는 횟수*/
		for(int i=0; i<array.length; i++) {
			a	 = array[0];
			b	= array[1];
		}
		int temp = Integer.parseInt(a);
		String input = br.readLine();
		int last = 0;
		
		String[] array2= new String[temp];
		array2 = input.split(" ");
		
/*		for(int i=0; i<array2.length; i++) {
			System.out.print(array2[i]);
		}*/
		
		for(int i=0; i<temp; i++) {
			if(array2[i].equals("1")) {
				last = i;
				break;
			}
		}
		
			if(last-1 >=0 && last+1<=temp-1) {
				array2[last-1] = array2[last];
				array2[last+1] = array2[last];
				
			}
			
			
			
			for(int i=0; i<array2.length; i++) {
				for(int j=0; j<array2.length; j++) {
					
				}
			System.out.print(array2[i]);
		}
		
	/*int	tempK = Integer.parseInt(k);
	int[] array = new int[tempK];
		for(int i=0; i<tempK; i++) {
			String input = br.readLine();
			int input2 = Integer.parseInt(input);
			array[i] = input2;
		}
		
		for(int i=0; i<array.length; i++) {
			for(int j=0; j<array.length; j++) {
				if(array[i] >array[j]) {
					array[i] = array[j];
				}
			}
		}
		for(int i=0; i<array.length; i++) {
		System.out.print( array[i]);
		}*/
	/*	System.out.println(k);
		
		System.out.println(input);*/
	}
}
