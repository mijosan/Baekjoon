import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	
    	int vertex = Integer.parseInt(st.nextToken());
    	int edge = Integer.parseInt(st.nextToken());
    	ArrayList<Integer>[] adjList = new ArrayList[vertex + 1];
    	int[] visited = new int[vertex + 1];
    	int count = 0;
    	
    	for(int i=0;i<adjList.length;i++) {
    		adjList[i] = new ArrayList<Integer>();
    	}
    	
    	for(int i=0;i<edge;i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		
    		int u = Integer.parseInt(st.nextToken());
    		int v = Integer.parseInt(st.nextToken());
    		
    		adjList[u].add(v);
    		adjList[v].add(u);

    	}
    	
    	for(int i=1;i<=vertex;i++) {
    		int size = adjList[i].size();
    		
    		for(int j=0;j<size;j++) {
    			int start = adjList[i].get(j);
    			
    			if(visited[start] == 0) {
    				bfs(adjList, visited, start);
    				count++;
    			}
    		}
    	}
    	
    	for(int i=1;i<visited.length;i++) {
    		if(visited[i] == 0) {
    			count++;
    		}
    	}
    	
    	System.out.println(count);
    }
    
    static void bfs(ArrayList<Integer>[] adjList, int[] visited, int start) {
    	Stack<Integer> stack = new Stack<Integer>();
    	
    	stack.push(start);
    	visited[start] = 1;
    	
    	while(!stack.isEmpty()) {
    		boolean flag = false;
    		int top = stack.peek();
    		
    		for(int i : adjList[top]) {
    			if(visited[i] == 0) {
    				stack.push(i);
    				visited[i] = 1;
    				
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
