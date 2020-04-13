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
		
		int n = Integer.parseInt(br.readLine());
		int count = 0; // 그룹 아닌 갯수
		
		for(int i=0;i<n;i++) {	
			boolean[] bl = new boolean[27];
			String s = br.readLine();
			
			for(int j=0;j<s.length();j++) {

				if(bl[s.charAt(j)-97] == true) {
					if(j !=0 && s.charAt(j-1) != s.charAt(j)) {
						count = count + 1;			
						break;
					}
				}else {
					bl[s.charAt(j)-97] = true;
				}		
			}
		}
		System.out.println(n-count);
	}
}
