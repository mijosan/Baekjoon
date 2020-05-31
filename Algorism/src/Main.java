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
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	for(int i=0;i<n;i++) {
    		int m = Integer.parseInt(br.readLine());
    		int count = 0;
    		double point = 0;
    		double result = 0;
    		int count2 = 0;
    		
    		for(int j=0;j<m;j++) {
    			StringTokenizer st = new StringTokenizer(br.readLine()," ");
    			
    			count = Integer.parseInt(st.nextToken());
    			point = Double.parseDouble(st.nextToken());
    			count2 = count2 + count;
    			
    			result = result + count*point;
    		}
    		
    		System.out.println(count2 + " " + String.format("%.1f", result/count2));
    	}
    }
}