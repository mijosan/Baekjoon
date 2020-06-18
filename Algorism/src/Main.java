import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	// StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	// StringBuilder sb = new StringBuilder();
    	// int n = Integer.parseInt(br.readLine());
    	
    	int n = Integer.parseInt(br.readLine());
    	int[] arr = new int[n];
    	
    	for(int i=0;i<arr.length;i++) {
    		arr[i] = i+1;
    	}
    	
    	solution(arr);
	}
	
	static void solution(int[] arr) {
		while(true) {
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			
			int a = arr.length-1;
			
			boolean flag = false;
			for(int i=a;i>0;i--) {	
				if(arr[i] > arr[i-1]) {
					a = i;
					flag = true;
					break;
				}
			}
			
			if(flag == false) {
				break;
			}
			
			int b = arr.length-1;
			
			for(int i=b;i>=a;i--) {		
				if(arr[i] > arr[a-1]) {
					b = i;
					break;
				}
			}
			
			int temp = arr[b];
			arr[b] = arr[a-1];
			arr[a-1] = temp;	
			
			int start = a;
			int end = arr.length-1;
	
			for(int i=0;i<end-start;i++) {
				for(int j=start;j<end-i;j++) {	
					if(arr[j] > arr[j+1]) {
						int temp2 = arr[j+1];
						arr[j+1] = arr[j];
						arr[j] = temp2;
					}
				}
			}		
		}
	}
}