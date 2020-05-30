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
    	
    	int n = 1000 - Integer.parseInt(br.readLine());
    	int count = 0;
    	
    	while(n != 0) {
    		if(n >= 500) {
    			count = count + n / 500;
    			n = n % 500;
    		}else if(n >= 100) {
    			count = count + n / 100;
    			n = n % 100;
    		}else if(n >= 50) {
    			count = count + n / 50;
    			n = n % 50;
    		}else if(n >= 10) {
    			count = count + n / 10;
    			n = n % 10;
    		}else if(n >= 5) {
    			count = count + n / 5;
    			n = n % 5;
    		}else{
    			count++;
    			n = n - 1;
    		}
    	}
    	
    	System.out.println(count);
    }


}