import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	int[] arr1 = new int[10];
    	for(int i=0;i<10;i++) {
    		arr1[i] = Integer.parseInt(br.readLine());
    	}
    	
    	int[] arr2 = new int[10];
    	for(int i=0;i<10;i++) {
    		arr2[i] = Integer.parseInt(br.readLine());
    	}
    	
    	Arrays.sort(arr1);
    	Arrays.sort(arr2);
    	
    	int result1 = arr1[arr1.length-1] + arr1[arr1.length-2] + arr1[arr1.length-3];
    	int result2 = arr2[arr2.length-1] + arr2[arr2.length-2] + arr2[arr2.length-3];
    	
    	System.out.print(result1 + " " + result2);
    	
    }
}