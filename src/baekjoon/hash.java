package baekjoon;

import java.util.HashMap;
import java.util.Iterator;

public class hash {

	public int solution(String[][] clothes) {
		int answer=1;
		
		//1. Create Hash Map
		HashMap<String, Integer> map = new HashMap<>();
		
		//2. Make count table of each clothing type
		// 이전에 값이 있었으면 기존값에 +1 없었으면 1 입력
		for(int i=0; i<clothes.length; i++) {
			String key = clothes[i][1];
			map.put(key, map.getOrDefault(key, 0)+1);
		}
		
		//3 Iterate through all types of clothes and calculate combination
		// 모든 옷 종류에 대해서 안입는 경우가 있기 때문에 +1을 곱해줘야 한다.
		Iterator<Integer> iter = map.values().iterator();
		while(iter.hasNext()) {
			answer +=iter.next().intValue()+1;
		}
		
		return answer-1;
	}
}
