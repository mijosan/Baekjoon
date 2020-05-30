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
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	int count = 0;
    	
    	for(int i=0;i<n;i++) {
    		int a = Integer.parseInt(br.readLine());
    		
    		if(a == 1) {
    			count++;
    		}
    	}
    	
    	if(count > n/2) {
    		System.out.println("Junhee is cute!");
    	}else {
    		System.out.println("Junhee is not cute!");
    	}
    }


}