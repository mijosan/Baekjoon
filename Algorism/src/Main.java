import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int h = Integer.parseInt(st.nextToken());
		
		if(h == 0) {
			h = 24*60;
		}else {
			h = h*60;
		}
				
		int m = Integer.parseInt(st.nextToken());
		
		int x = (h+m)-45;
		
		System.out.println(((x/60 == 24) ? 0 : x/60) + " " + x%60);

	}

}
