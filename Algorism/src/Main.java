import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;
//DP ��ü�� �̷��� �����մϴ�. �־��� ������ ���� ���� �κ� ������� ������ Ǭ ����, �� ������ �־��� ������ Ǭ��.

public class Main {
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	int[] dp = new int[n+1];
    	
    	dp[0] = 1;
    	dp[1] = 1;
    	
    	for(int i=2;i<=n;i++) {
    		
    		dp[i] = (dp[i-1] + dp[i-2] % 10007);
    		
    	}
    	
    	System.out.println(dp[n]);
    	
    		
    }

}