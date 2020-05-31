import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	int sum = 0;
    	
    	for(int i=0;i<10;i++) {
    		int n = Integer.parseInt(br.readLine());
    		
    		sum = sum + n;
    		
    		if(sum == 100) {
    			break;
    		}
    		
    		if(sum > 100) {
    			int gap1 = 100 - (sum - n);
    			int gap2 = sum - 100;
    			
    			if(gap2 > gap1) {
    				sum = sum - n;
    			}
    			
    			break;
    		}
    	}
    	
    	System.out.println(sum);
    }
}