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
		StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	char[] a = new char[15];
    	char[] b = new char[15];
    	char[] c = new char[15];
    	char[] d = new char[15];
    	char[] e = new char[15];
    	
    	String a1 = br.readLine();
    	String b1 = br.readLine();
    	String c1 = br.readLine();
    	String d1 = br.readLine();
    	String e1 = br.readLine();
    	
    	for(int i=0;i<a1.length();i++) {
    		a[i] = a1.charAt(i);
    	}
    	for(int i=0;i<b1.length();i++) {
    		b[i] = b1.charAt(i);
    	}
    	for(int i=0;i<c1.length();i++) {
    		c[i] = c1.charAt(i);
    	}
    	for(int i=0;i<d1.length();i++) {
    		d[i] = d1.charAt(i);
    	}
    	for(int i=0;i<e1.length();i++) {
    		e[i] = e1.charAt(i);
    	}
    	
    	for(int i=0;i<15;i++) {
    		sb.append(""+a[i]+b[i]+c[i]+d[i]+e[i]);
    	}
    	
    	System.out.println(sb.toString().replaceAll("\u0000",""));
    }


}