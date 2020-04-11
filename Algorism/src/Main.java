import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<i;j++) {
				sb.append(" ");
			}
			
			for(int j=0;j<(2*n-1)-(i*2);j++) {
				sb.append("*");
			}
			System.out.println(sb);
			sb.delete(0, sb.length());
		}
		
		for(int i=0;i<n-1;i++) {
			for(int j=1;j<(n-1)-i;j++) {
				sb.append(" ");
			}
			
			for(int j=0;j<3+(2*i);j++) {
				sb.append("*");
			}
			System.out.println(sb);
			sb.delete(0, sb.length());
		}
		
	}
}
