package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class baekjoon_2456 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Candidate> list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine()); // 학생들의 수
		String [][] jumsu = new String[N][3];
		list.add(new Candidate(1, 0, 0, 0, 0));
		list.add(new Candidate(2, 0, 0, 0, 0));
		list.add(new Candidate(3, 0, 0, 0, 0));
	//	st = new StringTokenizer(br.readLine(), "\n");
		for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken());
				int second = Integer.parseInt(st.nextToken());
				int third = Integer.parseInt(st.nextToken());

				if(first == 1) {
					list.get(0).score1++;
				}else if(first == 2) {
					list.get(0).score2++;
				}else {
					list.get(0).score3++;
				}
				
				if(second == 1) {
					list.get(1).score1++;
				} else if(second == 2) {
					list.get(1).score2++;
				} else {
					list.get(1).score3++;
				}
				if(third == 1) {
					list.get(2).score1++;
				} else if(third == 2) {
					list.get(2).score2++;
				} else {
					list.get(2).score3++;
				}
				
				list.get(0).sum +=first;
				list.get(1).sum += second;
				list.get(2).sum += third;
				
		}
		
		Collections.sort(list);	//가장 우선순위가 높은 후보의 번호와 최고 점수 출력
		boolean flag =false;
		System.out.println("list.get(0).sum : " +list.get(0).sum);
		System.out.println("list.get(1).sum : " +list.get(1).sum);
		if(list.get(0).sum == list.get(1).sum) {
			if(list.get(0).score3 == list.get(1).score3) {
				if(list.get(0).score2 == list.get(0).score2) {
					flag = true;
				}
			}
		}
		
		if(flag) {
			System.out.println(0 + " " + list.get(0).sum);
		}else {
			System.out.println(list.get(0).num + " "  + list.get(0).sum);
		}

		
		
	}
	
	static class Candidate implements Comparable<Candidate> {

		int num;	//후보자의 번호
		int score1;
		int score2;
		int score3;
		int sum;
		
		
		public Candidate(int num, int score1, int score2, int score3, int sum) {
			this.num = num;
			this.score1 = score1;
			this.score2 = score2;
			this.score3 = score3;
			this.sum = sum;
		}

/*
 Integer.compare(int x, int y) 인데요.
x == y 일 경우 0 리턴
x < y   일 경우 음수 리턴
x > y   일 경우 양수 리턴

 * */
		@Override
		public int compareTo(Candidate o) {
			if(this.sum == o.sum) {
				if(this.score3 == o.score3) {
					System.out.println("Integer.compare(o.score2, this.score2) : "+Integer.compare(o.score2, this.score2));
					return Integer.compare(o.score2, this.score2);
				}
				System.out.println("Integer.compare(o.score3, this.score3) : " +Integer.compare(o.score3, this.score3));
				return Integer.compare(o.score3, this.score3);
				
			}
			System.out.println("o.sum" +o.sum + "this.sum "+this.sum);
			System.out.println("Integer.compare(o.sum, this.sum) : " +Integer.compare(o.sum, this.sum));
			return Integer.compare(o.sum, this.sum);
		}
		
	}
}
