package baekjoon;

import java.util.ArrayList;
import java.util.List;

public class physicalTest2 {

	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int lostLen = lost.length;
		
		List<Integer> losts = new ArrayList<Integer>();
		List<Integer> reserves = new ArrayList<Integer>();
		
		for(int a: lost) {
			losts.add(a);
		}
		
		for(int a: reserve) {
			reserves.add(a);
		}
	
		for(int i=0; i<losts.size(); i++) {
			System.out.println(losts.get(i));
		}
		for(int i=0; i<reserves.size(); i++) {
			System.out.println(reserves.get(i));
		}
		
		answer = n - lostLen;
		
		for(int i=0; i<losts.size(); i++) {
			for(int j=0; j<reserves.size(); j++) {
				if(losts.get(i) == reserves.get(i)) {
					reserves.remove(i);
					losts.remove(i);
					i--;
					answer++;
					break;
				}
			}
		}
		
		for(int i=0; i<losts.size(); i++) {
			for(int j=0; j<reserves.size(); j++) {
				if(reserves.get(i)+1 == losts.get(i) || reserves.get(i)-1 == losts.get(i)) {
					answer++;
					reserves.remove(i);
					break;
				}
			}
		}
		
		return answer;
		
	}
}
