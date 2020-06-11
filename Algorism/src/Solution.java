import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
	static int[] visited;
	static int[] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	StringBuilder sb = new StringBuilder();
    	solution("abcd", sb, 0);
    }	
	
	public static void solution(String s, StringBuilder sb, int index) {

		for (int i = 1; i < s.length(); i++)
	    {
	        // 1) 한 문자 추가
	        sb.append(s.charAt(i));

	        // 2) 구한 문자조합 출력
	        System.out.println(sb.toString());

	        // 3) 나머지 문자들에 대한 조합 구하기
	        solution(s, sb, i + 1);

	        // 위의 1에서 추가한 문자 삭제 
	        sb.delete(sb.length() - 1, 1);
	    }
       
    }
    
}
