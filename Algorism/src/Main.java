import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	// StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	// StringBuilder sb = new StringBuilder();
    	// int n = Integer.parseInt(br.readLine());
    	
    	 int N = Integer.parseInt(br.readLine()); 
         int arr[] = new int[N];
         
         StringTokenizer st = new StringTokenizer(br.readLine(), " "); 
         
         for (int i = 0; i < N; i++) {
             arr[i] = Integer.parseInt(st.nextToken());
         }
         
         if (nextPermutation(arr)) {
             for (int i = 0; i < N; i++) {
                 System.out.print(arr[i] + " ");
             }
             System.out.println();
         } else {
             System.out.println("-1");
         }
    	
	}
	
	public static boolean nextPermutation(int[] arr) {
		
		//1 2 3 4
		//뒤에서부터 탐색하면서 a-1보다 a가 더 큰 경우 찾음
		int a = arr.length-1;
		
		while(a > 0 && arr[a-1] >= arr[a]) a--;
		if(a <= 0) return false;
		
		//다시 뒤에서부터 탐색하며 a-1보다 b가 더 큰 경우 찾음
		int b = arr.length-1;
		while(arr[a-1] >= arr[b]) b--;
		
		//a랑 b를 swap
		int temp = arr[a-1];
		arr[a-1] = arr[b];
		arr[b] = temp;
		
		//a에서부터 끝까지를 오름차순 정렬
		int start = a;
		int end = arr.length-1;
		
		while(start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		return true;
	}

}