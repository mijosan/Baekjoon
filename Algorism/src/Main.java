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
    	
    	while(true) {
    		StringTokenizer st = new StringTokenizer(br.readLine()," ");
    		
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		
    		if(a == 0 && b == 0 && c == 0) {
    			break;
    		}
    		
    		if(a*a + b*b == c*c) {
    			System.out.println("right");
    		}else if(a*a + c*c == b*b) {
    			System.out.println("right");
    		}else if(c*c + b*b == a*a) {
    			System.out.println("right");
    		}else {
    			System.out.println("wrong");
    		}
    		
    		
    	}    	
    }


}