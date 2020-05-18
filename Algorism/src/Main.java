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
    	
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	int[] dp = new int[n+2]; //그날 받을수있는 최대 금액 (i + 1일날)
    	int[] t = new int[n+2]; //상담 걸리는 시간
    	int[] p = new int[n+2]; //상담 금액
    	
    	for(int i=1;i<=n;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine()," ");
    		t[i] = Integer.parseInt(st.nextToken());
    		p[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	int max = 0;
    	
    	for(int i=1;i<=n+1;i++) {
    	
    		dp[i] = Math.max(max, dp[i]);
    		
    		
    		if(i + t[i] <= n+1) {
    			dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
    		}
    		
    		max = Math.max(max, dp[i]);
    		
    	}
    	
    	System.out.println(max);

    }
}
