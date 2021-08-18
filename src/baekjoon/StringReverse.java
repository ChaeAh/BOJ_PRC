package baekjoon;

// 거꾸로 출력
public class StringReverse {

	public static void main(String[] args) {
		
		String str="ABCDE";
		
		String temp = "";
		
		//1) 반복문 출력
		for(int i=str.length()-1; i>=0; i--) {
			temp += str.charAt(i);	//입력 받은 index번째 문자 반환
			
			System.out.println(temp + "반복문 안");
		}
		System.out.println(temp);
		
		//2) StringBuffer 사용
		StringBuffer sb = new StringBuffer(str);	//생성자의 파라미터로 문자열을 입력받을수 있음
		String temp2 = sb.reverse().toString();
		
		System.out.println(temp2);
	}
}
