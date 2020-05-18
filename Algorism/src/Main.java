import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//DP : �־��� ������ ���� ���� �κ� ������� ������ Ǭ ����, �� ������ �־��� ������ Ǭ��.

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	int[] dp = new int[n+2]; //�׳� �������ִ� �ִ� �ݾ� (i + 1�ϳ�)
    	int[] t = new int[n+2]; //��� �ɸ��� �ð�
    	int[] p = new int[n+2]; //��� �ݾ�
    	
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
