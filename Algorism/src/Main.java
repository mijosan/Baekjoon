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

		//1~1000
		int n = Integer.parseInt(br.readLine());
		
		int count = 0;
		
		if(n < 100) {
			System.out.println(n);
		}else if(n == 1000){
			System.out.println(144);
			
		}else {
			for(int i=100;i<=n;i++) {
				
				int temp = i;
				
				int[] arr = new int[3];
				int index = 2;
				while(temp > 0) {

					arr[index] = temp % 10;
					index--;
					
					temp = temp/10;
				}
				
				if(arr[1] - arr[0] == arr[2] - arr[1]) {
					count = count + 1;
				}
				
			}
			System.out.println(count + 99);
		}
	}
}
