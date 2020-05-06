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
		// StringTokenizer st = new StringTokenizer(br.readLine(),".");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());

		int n = Integer.parseInt(br.readLine());
		int x = 0;
		int m = n;
		
		int size = 0;
		
		while(m != 0) {
			m = m / 10;
			size = size + 1;
		}
		
		int a = n-(size*9);
		
		for(int i=a;i<=n;i++) {
			int sum = i;
			int k = i;
			
			while(k > 0) {
				sum = sum + k%10;
				k = k/10;
			}
			
			if(sum == n) {
				x = i;
				break;
			}
			
		}
		System.out.println(x);
		
	}
}