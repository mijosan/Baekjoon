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
    	
    	for(int i=0;i<n;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine()," ");
    		
    		int size = st.countTokens();
    		int[] arr = new int[9];
    		for(int j=1;j<=size;j++) {
    			arr[j] = Integer.parseInt(st.nextToken());
    		}
    		
    		arr[1] = arr[1] + arr[5];
    		arr[2] = arr[2] + arr[6];
    		arr[3] = arr[3] + arr[7];
    		arr[4] = arr[4] + arr[8];
    		
    		if(arr[1] < 1) {
    			arr[1] = 1;
    		}
    		if(arr[2] < 1) {
    			arr[2] = 1;
    		}
    		if(arr[3] < 0) {
    			arr[3] = 0;
    		}
    		
    		System.out.println(1 * arr[1] + 5 * arr[2] + 2 * arr[3] + 2 * arr[4]);
    	}
    	
    }
}