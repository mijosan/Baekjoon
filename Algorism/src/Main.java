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
    	
    	for(int i=0;i<3;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine()," ");
    		int sum = 0;
    		
    		for(int j=0;j<4;j++) {
    			sum = sum + Integer.parseInt(st.nextToken());
    		}
    		
    		if(sum == 3) {
    			System.out.println("A");
    		}else if(sum == 2) {
    			System.out.println("B");
    		}else if(sum == 1) {
    			System.out.println("C");
    		}else if(sum == 0) {
    			System.out.println("D");
    		}else {
    			System.out.println("E");
    		}
    	}
    }


}