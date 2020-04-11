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
			sb.append("*");
			System.out.println(sb);
		}
		
		for(int i=0;i<n;i++) {
			sb.deleteCharAt(sb.length()-1);
			System.out.println(sb);
		}
	}
}
