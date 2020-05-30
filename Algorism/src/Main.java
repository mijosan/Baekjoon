import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	int[] arr = new int[n];
    	int max = Integer.MIN_VALUE;
    	int result = 0;
    	
    	st = new StringTokenizer(br.readLine()," ");
    	
    	for(int i=0;i<n;i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	for(int i=0;i<n-2;i++) {
    		for(int j=i+1;j<n-1;j++) {
    			for(int k=j+1;k<n;k++){
    				int a = arr[i];
    				int b = arr[j];
    				int c = arr[k];
    				
    				result = a+b+c;
    				
    				if(result <= m && result >= max) {
    					max = result;
    				}
    			}
    		}
    	}
    	
    	System.out.println(max);
    	
    	
    }


}