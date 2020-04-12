import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();

		
		char[] alpha = new char[26];
		int[] result = new int[26];
		
		for(int i=0;i<alpha.length;i++) {
			alpha[i] = (char)(97+i);
		}
		
		for(int i=0;i<result.length;i++) {
			result[i] = -1;
		}
		for(int i=0;i<s.length();i++) {
			for(int j=0;j<alpha.length;j++) {
				if(s.charAt(i) == alpha[j]) {
					if(result[j] == -1) {
						result[j] = i;
						break;
					}
				}
			}
		}
		
		for(int a : result) {
			sb = sb.append(a + " ");
		}
		
		System.out.println(sb.toString().trim());
	}
}
