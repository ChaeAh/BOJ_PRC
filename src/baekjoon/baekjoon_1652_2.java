package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjoon_1652_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] arr = new String[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		int row =0;
		int cal = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.println(arr[4].charAt(0));
				if(arr[i].charAt(j) == '.') {
					if(j+1 < N && arr[i].charAt(j+1) == '.') {
						if(j+2 >= N || (j+2 < N && arr[i].charAt(j+2)== 'X')) {
							row++;
						}
					}
					if(i+1 <N && arr[i+1].charAt(j) == '.') {
						if(i+2>=N || (i+2<N && arr[i+2].charAt(j) == 'X')) {
							cal++;
						}
					}
				}
			}
		}
		
		System.out.println(row + " " + cal);
		
	}
}
