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
    	
    	int a = Integer.parseInt(st.nextToken());
    	int b = Integer.parseInt(st.nextToken());
    	int c = Integer.parseInt(st.nextToken());
    	int d = Integer.parseInt(st.nextToken());
    	
    	int sum = a+b+c+d;
    	
    	st = new StringTokenizer(br.readLine()," ");
    	
    	int a1 = Integer.parseInt(st.nextToken());
    	int b1 = Integer.parseInt(st.nextToken());
    	int c1 = Integer.parseInt(st.nextToken());
    	int d1 = Integer.parseInt(st.nextToken());
    	
    	int sum1 = a1+b1+c1+d1;
    	
    	if(sum>=sum1) {
    		System.out.println(sum);
    	}else {
    		System.out.println(sum1);
    	}
    }
}