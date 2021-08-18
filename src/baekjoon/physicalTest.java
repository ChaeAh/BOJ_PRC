package baekjoon;

import java.util.ArrayList;
import java.util.List;

public class physicalTest {

/*
전체 학생의 수는 2명 이상 30명 이하입니다.
체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 
이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
 * */
		public int solution(int n, int[] lost, int[] reserve) {
			int answer=0;
			int lostLength = lost.length;
			List<Integer> lostList = new ArrayList<Integer>();
			List<Integer> resList = new ArrayList<Integer>();
			
			for(int i=0; i<lost.length; i++) {
				lostList.add(i);
			}
			for(int j=0; j<reserve.length; j++) {
				resList.add(j);
			}
			//잃어버린 사람 제외
			answer = n- lostLength;
	
			//여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 
			for(int i=0; i<lostList.size(); i++) {
				for(int j=0; j<resList.size(); j++) {
					if(lostList.get(i) ==resList.get(j)) {
						lostList.remove(i);
						resList.remove(j);
						i--;
						answer +=1;
						break;
					}
				}
			}
			//lostlist 2 4
			//resList 3
			//2 4
			// 1 3 5
			for(int i=0; i<lostList.size(); i++) {
				for(int j=0; j<resList.size(); j++) {
					if(lostList.get(i) == resList.get(i-1) || 	lostList.get(i) == resList.get(i+1)) {
						resList.remove(i);
						answer+=1;
						break;
					}
				}
			}
			
			
			return answer;
		}
	
}
