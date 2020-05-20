import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
//DP : 주어진 문제를 여러 개의 부분 문제들로 나누어 푼 다음, 그 결과들로 주어진 문제를 푼다.

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	
    	int vertex = Integer.parseInt(st.nextToken());
    	int edge = Integer.parseInt(st.nextToken());
    	int start = Integer.parseInt(st.nextToken());
    	boolean[] visited = new boolean[vertex + 1];
    	
    	ArrayList<Integer>[] adjList = new ArrayList[vertex + 1];
    	
    	for(int i=0;i<adjList.length;i++) {
    		adjList[i] = new ArrayList<Integer>();
    	}
    	
    	for(int i=0;i<edge;i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		
    		int v1 = Integer.parseInt(st.nextToken());
    		int v2 = Integer.parseInt(st.nextToken());
    		
    		adjList[v1].add(v2);
    		adjList[v2].add(v1);
    	}

    	for(int i=0;i<adjList.length;i++) {
    		Collections.sort(adjList[i]);
    	}
    	
    	dfs(adjList, visited, start);
    	
    	Arrays.fill(visited, false);
    	System.out.println();
    	
    	bfs(adjList, visited, start);   	
    }
    
    static void dfs(ArrayList<Integer>[] adjList, boolean[] visited, int vertex) {
    	Stack<Integer> stack = new Stack<Integer>();
    	boolean flag = false;
    	
    	stack.push(vertex);
    	visited[vertex] = true;
    	System.out.print(vertex + " ");
    	
    	while(!stack.isEmpty()) {
	    	int top = stack.peek();
	    	
	    	flag = false;
	    	
	    	for(int i : adjList[top]) {
	    		if(visited[i] == false) {
		    		stack.push(i);
		    		visited[i] = true;
		    		System.out.print(i + " ");
		    		
		    		flag = true;
		    		break;
	    		}
	    	}
	    	
	    	if(flag == false) {
	    		stack.pop();
	    	}
    	}
    }
    
    static void bfs(ArrayList<Integer>[] adjList, boolean[] visited, int vertex) {
    	Queue<Integer> queue = new LinkedList<Integer>();
    	
    	queue.add(vertex);
    	visited[vertex] = true;
    	
    	while(!queue.isEmpty()) {
    		
    		int v = queue.poll();
    		
    		System.out.print(v + " ");
    		
	    	for(int i : adjList[v]) {
	    		if(visited[i] == false) {
	    			queue.add(i);
	    			visited[i] = true;
	    		}
	    	}
    	}
    }  
}
