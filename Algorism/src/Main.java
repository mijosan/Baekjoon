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
    	
    	int[][] dp = new int[n][3];
   	
    	for(int i=0;i<n;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine()," ");
    		for(int j=0;j<3;j++) {
    			dp[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	for(int i=1;i<n;i++) {
    		
    		dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + dp[i][0];
    		dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + dp[i][1];
    		dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + dp[i][2];
    	}
    	
    	System.out.println(Math.min(Math.min(dp[n-1][0], dp[n-1][1]),dp[n-1][2]));
    	
    		
    }

}