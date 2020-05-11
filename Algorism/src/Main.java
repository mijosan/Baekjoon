import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//DP 자체는 이렇게 정의합니다. 주어진 문제를 여러 개의 부분 문제들로 나누어 푼 다음, 그 결과들로 주어진 문제를 푼다.

public class Main {
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	int[][] dp = new int[n+1][n+1];
    	
    	for(int i=1;i<=n;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine()," ");
    		
    		for(int j=1;j<=i;j++) {
    			dp[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	

    	if(n >= 2) {
    		dp[2][1] = dp[1][1] + dp[2][1];
    		dp[2][2] = dp[1][1] + dp[2][2];
    	}
    	
    	for(int i=3;i<=n;i++) {
    		
    		dp[i][1] = dp[i-1][1] + dp[i][1];
    		
    		for(int j=2;j<i;j++) {

    			dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + dp[i][j];
    			
    		}
    		
    		dp[i][i] = dp[i-1][i-1] + dp[i][i];
    	}
    	
    	int max = Integer.MIN_VALUE;
    	
    	for(int i=1;i<=n;i++) {
    		if(max < dp[n][i]) {
    			max = dp[n][i];
    		}
    	}
    	
    	System.out.println(max);
    		
    }

}