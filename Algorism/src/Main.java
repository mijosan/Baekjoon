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
    	
    	
    	//int n = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	int[] dp = new int[m+1];
    
    	dp[1] = n - 1;
    	
    	for(int i=2;i<=m;i++) {
    
    		dp[i] = dp[i-1] + n;
    	}
    	
    	System.out.println(dp[m]);
    }
}
