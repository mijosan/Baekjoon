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
    	
    	Long[] dp = new Long[n+1];
    	Long[] arr = new Long[n+1];
    	
    	for(int i=1;i<=n;i++) {
    		arr[i] = Long.parseLong(br.readLine());
    	}
    	
    	if(n >= 1) dp[1] = arr[1];
    	if(n >= 2) dp[2] = arr[1] + arr[2];	
    	if(n >= 3) dp[3] = Math.max(Math.max(dp[2], arr[2]+arr[3]),arr[1]+arr[3]);
    	
    	for(int i=4;i<=n;i++) {
    		
    		dp[i] = Math.max(Math.max(dp[i-1], dp[i-3] + arr[i-1] + arr[i]), dp[i-2] + arr[i]); 
    	}
    	
    	System.out.println(dp[n]);
    	
    	
    	
    	
    	
    		
    }

}