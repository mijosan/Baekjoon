import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        // int n = Integer.parseInt(br.readLine());
        
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int temp = 0;
        
        for(int i = 1; i <= n; i++) {
        	int a = Integer.parseInt(st.nextToken());
        	
        	int x = (a * i) - temp;
        	
        	System.out.print(x + " ");
        	
        	temp = temp + x;
        }
    }

}