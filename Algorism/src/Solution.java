import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Solution {
	static int[] visited;
	static int[] map;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	int[] arr = {4, 3, 2, 1};
    	
    	for (int i = 0; i < arr.length-1; i++) {
            for (int j = i + 1; j < arr.length-(1+i); j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    	
    	for(int i=0;i<arr.length;i++) {
    		System.out.print(arr[i] + " ");
    	}
    }	
	
    
}
