import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][2];
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			arr[i][0] = weight;
			arr[i][1] = height;
		}
		
		for(int i=0;i<n;i++) {
			
			int rank = 1;
			
			for(int j=0;j<n;j++) {
				System.out.println(arr[i][0]+" "+ arr[j][0] +" "+ arr[i][1] +" "+ arr[j][1]);
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					rank++;
				}
			}
					
			sb.append(rank + " ").toString().trim();

		}
		
		System.out.println(sb);
	}
}