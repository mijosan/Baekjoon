import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine()," ");
		//StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		int sum = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) <= 'C') {
				sum = sum + 3;
			}else if(s.charAt(i) <= 'F') {
				sum = sum + 4;
			}else if(s.charAt(i) <= 'I') {
				sum = sum + 5;
			}else if(s.charAt(i) <= 'L') {
				sum = sum + 6;
			}else if(s.charAt(i) <= 'O') {
				sum = sum + 7;
			}else if(s.charAt(i) <= 'S') {
				sum = sum + 8;
			}else if(s.charAt(i) <= 'V') {
				sum = sum + 9;
			}else if(s.charAt(i) <= 'Z') {
				sum = sum + 10;
			}
		}
		
		System.out.println(sum);
	}
}
