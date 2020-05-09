import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
//DP 자체는 이렇게 정의합니다. 주어진 문제를 여러 개의 부분 문제들로 나누어 푼 다음, 그 결과들로 주어진 문제를 푼다.

public class Main {
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	int t = Integer.parseInt(br.readLine());
    	
    	for(int i=0;i<t;i++) {
    		int n = Integer.parseInt(br.readLine());
    		
    		int[][] dp = new int[41][2];
    		
    		dp[0][0] = 1;
    		dp[0][1] = 0;
    		
    		dp[1][0] = 0;
    		dp[1][1] = 1;
    				
    		for(int j=2;j<=n;j++) {
    			
    			dp[j][0] = dp[j-1][0] + dp[j-2][0];
    			
    			dp[j][1] = dp[j-1][1] + dp[j-2][1];
    			
    		}
    		
    		System.out.println(dp[n][0] + " " + dp[n][1]);
    	}  		
    }

}