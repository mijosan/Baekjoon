import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//DP ��ü�� �̷��� �����մϴ�. �־��� ������ ���� ���� �κ� ������� ������ Ǭ ����, �� ������ �־��� ������ Ǭ��.

public class Main {
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	Long[] dp = new Long[n+1];
    	
    	dp[1] = 1L;
    	
    	if(n >= 2) {
    		dp[2] = 1L;
    	}
    	
    	for(int i=3;i<=n;i++) {
    		dp[i] = dp[i-1] + dp[i-2];
    	}
    	
    	System.out.println(dp[n]);
    	
    	
    	
    		
    }

}