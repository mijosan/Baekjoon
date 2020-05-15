import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//DP : 주어진 문제를 여러 개의 부분 문제들로 나누어 푼 다음, 그 결과들로 주어진 문제를 푼다.

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	
    	int t = Integer.parseInt(br.readLine());
    	
	
    	for(int j=0;j<t;j++) {
    		
    		int n = Integer.parseInt(br.readLine());
    		
    		long[] dp = new long[n+1];
    		
    		if(n >= 1) {
    			dp[1] = 1;
    		}
    		
    		if(n >= 2) {
    			dp[2] = 1;
    		}
    		
    		if(n >= 3) {
    			dp[3] = 1;
    		}
    		
    		if(n >= 4) {
    			dp[4] = 2;
    		}
    		
    		if(n >= 5) {
    			dp[5] = 2;
    		}
    		
	    	for(int i=6;i<=n;i++) {
	    		
	    		dp[i] = dp[i-1] + dp[i-5];
	    	}
	    	
	    	System.out.println(dp[n]);
    	}
    }
}