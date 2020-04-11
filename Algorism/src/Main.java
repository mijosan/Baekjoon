import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int burger1 = Integer.parseInt(br.readLine());
		int burger2 = Integer.parseInt(br.readLine());
		int burger3 = Integer.parseInt(br.readLine());
		int beverage1 = Integer.parseInt(br.readLine());
		int beverage2 = Integer.parseInt(br.readLine());
		
		int min1;
		int min2;
		
		int result;
		if(burger1 > burger2) {
			min1 = burger2;
			if(burger2>burger3) {
				min1 = burger3;
			}
		}else {
			min1 = burger1;
			if(burger1 > burger3) {
				min1 = burger3;
			}
		}
		
		if(beverage1 > beverage2) {
			min2 = beverage2;
		}else {
			min2 = beverage1;
		}
		
		result = min1 + min2 - 50;
		
		System.out.println(result);
	}
}
