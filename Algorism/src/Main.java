import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[][] visited;
	static int[][] result;
	static int vertex;
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	vertex = Integer.parseInt(br.readLine());
    	map = new int[vertex+1][vertex+1];
    	result = new int[vertex+1][vertex+1];
    	
    	for(int i=1;i<map.length;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine()," ");
    		
    		for(int j=1;j<map.length;j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
      		}
    	}
    	
    	for(int i=1;i<map.length;i++) {
    		for(int j=1;j<map.length;j++) {
    			
    			if(map[i][j] == 1) {
    				bfs(i, j);
    			}
    		}
    	}
    	
    	for(int i=1;i<map.length;i++) {
    		for(int j=1;j<map.length;j++) {
    			System.out.print(result[i][j] + " ");
    		}
    		System.out.println();
    	}
    
    }
    
    static void bfs(int i, int j) {
    		
		Stack<Integer> stack = new Stack<Integer>();
		visited = new int[vertex+1][vertex+1];
		
    	stack.push(j);
    	visited[i][j] = 1;
    	result[i][j] = 1;
    	
    	while(!stack.isEmpty()) {
    		j = stack.peek();
    		boolean flag = false;
    		
    		
    		for(int k=1;k<map.length;k++) {
    			if(map[j][k] == 1 && visited[j][k] == 0) {
    				stack.push(k);
    				visited[j][k] = 1;    				
    				visited[i][k] = 1;
    				result[i][k] = 1;
    				
    				flag = true;
    				
    				break;
    			}
    		}
    		
    		if(flag == false) {
    			stack.pop();
    		}
    				
    	}
	}
    
}
