package baekjoon;

import java.util.Arrays;

public class hashLevel1 {
	public String solution(String[] participant, String[] completion) { 
		// 1. Sort both arrays 
		Arrays.sort(participant);
		Arrays.sort(completion); 
		// 2. Loop through to find the difference 
		int i; 
		for (i=0; i<completion.length; i++) {
			if (!participant[i].equals(completion[i])) 
				return participant[i]; 
		}
		// 3. If the program reaches this part, last participant couldn't complete the race 
		return participant[i];
		}
}
