import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		int c = b;
	    System.out.println(a*(b%10));
	    
	    b = b/10;
	    System.out.println(a*(b%10));
	    
	    b = b/10;
	    System.out.println(a*(b%10));
	    
	    System.out.println(a*c);
	}

}
