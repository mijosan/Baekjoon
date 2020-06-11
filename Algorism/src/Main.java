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
    	StringBuilder sb = new StringBuilder();
    	// int n = Integer.parseInt(br.readLine());
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	int n = Integer.parseInt(br.readLine());
    	
    	for(int i=0;i<n;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine()," ");
    		String cmd = st.nextToken();
    		
    		int value = 0;

    		if(!cmd.equals("all") && !cmd.equals("empty")) {
    			value = Integer.parseInt(st.nextToken());
    		}
    		
    		if(cmd.equals("add")) {
    			if(!list.contains(value)) {
    				list.add(value);
    			}
    			
    		}else if(cmd.equals("remove")) {
    			if(list.contains(value)) {
    				list.remove(list.indexOf(value));
    			}
    			
    		}else if(cmd.equals("check")) {
    			if(list.contains(value)) {
    				sb.append("1\n");
    			}else {
    				sb.append("0\n");
    			}
    		}else if(cmd.equals("toggle")) {
    			if(list.contains(value)) {
    				list.remove(list.indexOf(value));
    			}else {
    				list.add(value);
    			}
    			
    		}else if(cmd.equals("all")) {
    			list.removeAll(list);
    			
    			for(int j=1;j<=20;j++) {
    				list.add(j);
    			}
    		}else if(cmd.equals("empty")) {
    			list.removeAll(list);
    		}
    	}
    	System.out.println(sb);
    }
	

}