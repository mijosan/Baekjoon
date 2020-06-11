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
    	
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	
    	int e = Integer.parseInt(st.nextToken());
    	int s = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	int year = 1;
    	
		int e1 = 1, s1 = 1, m1 = 1;
    	
    	while(true) {
    		if(e1 == e && s1 == s && m1 == m) {
    			break;
    		}
    		
    		e1++; 
    		s1++; 
    		m1++; 
    		
    		if(e1 > 15) {
    			e1 = 1;
    		}
    		
    		if(s1 > 28) {
    			s1 = 1;
    		}
    		
    		if(m1 > 19) {
    			m1 = 1;
    		}
    		
    		year++;
    	}
    	
    	System.out.println(year);
    }
	

}