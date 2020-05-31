import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	
    	int e = Integer.parseInt(st.nextToken());
    	int f = Integer.parseInt(st.nextToken());
    	int c = Integer.parseInt(st.nextToken());
    	
    	int sum = 0;
    	int temp = (e+f)/c;
    	int temp2 = (e+f)%c;
    	
    	while(true) {	
    		sum = sum + temp;
    		
    		if(temp !=0) {
    			int a = temp;
    			temp = (temp+temp2) / c;
    			temp2 = (a + temp2) % c;
    		}else {
    			break;
    		}
    	}
    	
    	System.out.println(sum);
    }
}