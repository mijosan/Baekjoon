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
    	
    	int[] dp = new int[n+1];
    	int[] map = new int[n+1];
    	
    	for(int i=1;i<=n;i++) {
    		map[i] = Integer.parseInt(br.readLine());
    	}
    	
    	
		dp[1] = map[1];
		
		if(n > 1) {
			dp[2] = map[1]+map[2];
			
			if(n > 2) {
				dp[3] = Math.max(map[1]+map[3], map[2]+map[3]);
			}
		}
    	for(int i=4;i<=n;i++) {
    		dp[i] = Math.max(dp[i-2], dp[i-3]+map[i-1]) + map[i];
    	}
    	
    	System.out.println(dp[n]);
    	
    		
    }

}