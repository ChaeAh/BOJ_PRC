package baekjoon;

import java.util.HashMap;

public class hashLevel1_1 {

	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();
		
		for(String player : participant) {
			hm.put(player, hm.getOrDefault(player, 0)+1);
		}
		
		for(String player : completion) {
			hm.put(player, hm.getOrDefault(player, 0)-1);
		}
		
		for(String key: hm.keySet()) {
			if(hm.get(key)!=0) {
				answer = key;
				break;
			}
		}
		return answer;
	}
}
