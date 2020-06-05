import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
    	
    	int t = Integer.parseInt(br.readLine());
    	
    	for(int i=0;i<t;i++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
	    	
	    	int a = Integer.parseInt(st.nextToken());
	    	int b = Integer.parseInt(st.nextToken());
	    	
	    	bfs(a, b);
    	}
    	
    }
    
    static void bfs(int a, int b) {
    	Queue<Pair> queue = new LinkedList<Pair>();
    	int[] visited = new int[10000];
    	
    	queue.add(new Pair(a, ""));
    	visited[a] = 1;
    	
    	while(!queue.isEmpty()) {
    		Pair pair = queue.poll();
    		
    		int pa = pair.i;
    		String cal = pair.j;
    		
    		visited[pa] = 1;
    		
    		if(pa == b) {
    			System.out.println(cal);
    			break;
    		}
    		
    		for(int i=0;i<4;i++) {
    			if(i == 0) {
    				int result =  (2*pa) % 10000;
    				
    				if(result > 9999) {
    					result = result % 10000;
    				}
    				
    				if(result >= 0 && result < 10000 && visited[result] == 0) {
    					visited[result] = 1;
    					queue.add(new Pair(result, cal + "D"));		
    				}
    				
    			}else if(i == 1) {
    				int result = pa;
    				
    				if(result == 0) {
    					result = 9999;
    				}else {
    					result = result - 1;
    				}
    				if(result >= 0 && result < 10000 && visited[result] == 0) {
    					visited[result] = 1;
    					queue.add(new Pair(result, cal + "S"));		
    				}
    				
    			}else if(i == 2) {
    				int result = (pa % 1000) * 10 + pa / 1000;
    				
    				if(result >= 0 && result < 10000 && visited[result] == 0) {
    					visited[result] = 1;
    					queue.add(new Pair(result, cal + "L"));		
    				}
    			}else if(i == 3){
    				int result = (pa % 10) * 1000 + (pa / 10);
    				
    				if(result >= 0 && result < 10000 && visited[result] == 0) {
    					visited[result] = 1;
    					queue.add(new Pair(result, cal + "R"));		
    				}
    			}
    		}
    	}
    }  
}
class Pair{
	int i;
	String j = "";
	
	Pair(int i, String j){
		this.i = i;
		this.j = this.j + j;
	}
}
