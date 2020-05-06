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

		int[] arr = new int[9];

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum = sum + arr[i];
		}
		
		loop:
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				if (sum - (arr[i] + arr[j]) == 100) {
					arr[i] = 0;
					arr[j] = 0;
					break loop;
				}
			}
		}

		Arrays.sort(arr);
	  
		for(int i=0;i<arr.length;i++) { 
			if(arr[i] != 0) { 
				System.out.println(arr[i]);
			} 
		}
	}
}