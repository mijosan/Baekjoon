import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//DP 자체는 이렇게 정의합니다. 주어진 문제를 여러 개의 부분 문제들로 나누어 푼 다음, 그 결과들로 주어진 문제를 푼다.

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	int t = Integer.parseInt(br.readLine());
    	
    	int[] dp = new int[12];
    	
    	dp[1] = 1;
    	dp[2] = 2;
    	dp[3] = 4;
    	
    	for(int i=0;i<t;i++) {
    		int n = Integer.parseInt(br.readLine());
    		
    		for(int j=4;j<=n;j++) {
    			dp[j] = dp[j-1] + dp[j-2] + dp[j-3];
    		}
    		
    		System.out.println(dp[n]);
    	}
    }

}