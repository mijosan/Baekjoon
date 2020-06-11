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
	        // 1) �� ���� �߰�
	        sb.append(s.charAt(i));

	        // 2) ���� �������� ���
	        System.out.println(sb.toString());

	        // 3) ������ ���ڵ鿡 ���� ���� ���ϱ�
	        solution(s, sb, i + 1);

	        // ���� 1���� �߰��� ���� ���� 
	        sb.delete(sb.length() - 1, 1);
	    }
       
    }
    
}
