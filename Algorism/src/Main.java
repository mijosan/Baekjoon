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
    	int[] dp = new int[n];
    	int[] arr = new int[n];
    	
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	for(int i=0;i<n;i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    		dp[i] = 1;
    	}
    	
    	for(int i=1;i<n;i++) {
    		
    		for(int j=0;j<i;j++) {
    			
	    		if(arr[i] > arr[j]) {
	    			dp[i] = Math.max(dp[i], dp[j]+1);
	    		}
	    		
    		}
    	}
    	
    	int max = 0;
    	
    	for(int i=0;i<n;i++) {

    		if(max < dp[i]) {
    			max = dp[i];
    		}
    	}
    	
    	System.out.println(max);
    	
    	

    }

}