import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		//StringBuilder sb = new StringBuilder();

		int max = Integer.MIN_VALUE;
		int order = Integer.MIN_VALUE;
		
		for(int i=0;i<9;i++) {
			
			int temp = Integer.parseInt(br.readLine());
			
			if(temp > max){
				max = temp;
				order = i+1;
			}
			
			
		}
		
		System.out.println(max);
		System.out.println(order);
		
	}
}
