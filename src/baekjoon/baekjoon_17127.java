package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_17127 {

	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(br.readLine());
		int[] flower = new int[cnt+1];
		int answer =0;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for(int i=0; i<cnt; i++) {
				flower[i] = Integer.parseInt(st.nextToken());
				System.out.print(flower[i] + ",");
				System.out.println();
			}
			
			int sum = 0;
			for(int i=1; i<=cnt-3; i++) {
				for(int j=i+1; j<=cnt-2; j++) {
					for(int k=j+1; j<=cnt-1; k++) {
						for(int p=k+1; p<=cnt; p++) {
							int pp=cal(i,j-1,flower) + cal(j, k-1,flower);
							int kk =cal(k,p-1,flower) + cal(p , cnt,flower);
							sum = pp +kk;
						}
					}
				}
			}
			System.out.println(sum);
	/*		for(int i=1; i<cnt; i++) {
				for(int j=i+1; j<cnt; j++) {
					for(int k=j+1; k<cnt; k++) {
						int p = cal(1,i,flower) ;
						int d = cal(i+1,j,flower);
						int ss=  cal(j+1,k,flower) ;
						int kk = cal(k+1,cnt,flower);
						System.out.println(p + ", " +d + ", " + ss + "," + kk + "  ");
						int val = p+ d+ ss + kk;
						answer =(answer > val) ? answer : val;
					
					}
				}
				System.out.println("answer :" + answer);
			}
			System.out.println(answer);
			//n-5	m-2 m-4 m-6 m-3 m-5 m-4
*/			
	}
	
	static int cal(int num, int count, int[] flower) {
		int max=1;
	/*	for(int i=num; i<count; i++) {
			System.out.println("flower[i] : " + flower[i]);
			max *= flower[i];
			
		}*/
		for(int i=num; i<count; i++) {
		//	System.out.println("flower[i] : " + flower[i]);
			max *= flower[i];
		}
	//	System.out.println("=====================");
	//	System.out.println("max : " +max );
		return max;
	}
}
