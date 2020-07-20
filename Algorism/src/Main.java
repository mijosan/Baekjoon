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
        // StringBuilder sb = new StringBuilder();
        // int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int price = Integer.parseInt(st.nextToken());
        int gram = Integer.parseInt(st.nextToken());
        
        int n  = Integer.parseInt(br.readLine());
        
        double min = (double)price / gram * 1000;
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
        	
        	int price2 = Integer.parseInt(st.nextToken());
            int gram2 = Integer.parseInt(st.nextToken());
            
            double result = (double)price2 / gram2 * 1000;
            
            if(min > result) {
            	min = result;
            }
        }
        
        System.out.println(min);
    }
}