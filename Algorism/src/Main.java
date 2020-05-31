import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	BigInteger n = new BigInteger(br.readLine());
        char c = br.readLine().charAt(0);
        BigInteger m = new BigInteger(br.readLine());
	
        if(c == '*')
            System.out.println(n.multiply(m));
        else 
            System.out.println(n.add(m));
    	
    }
}