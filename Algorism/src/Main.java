import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int start;
	static int target;
	static ArrayList<Integer>[] adjList;
	static int[] visited;
	static int[] distance;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	n = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	
    	start = Integer.parseInt(st.nextToken());
    	target = Integer.parseInt(st.nextToken());
    	
    	adjList = new ArrayList[n + 1];
    	for(int i=0;i<adjList.length;i++) {
    		adjList[i] = new ArrayList<Integer>();
    	}

    	visited = new int[n + 1];
    	distance = new int[n + 1];
    	
    	int m = Integer.parseInt(br.readLine());
    	
    	for(int i=0;i<m;i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		
    		adjList[x].add(y);
    		adjList[y].add(x);
    	}
    	
    	bfs();
    }
    
    static void bfs() {
    	Queue<Integer> queue = new LinkedList<Integer>();
    	queue.add(start);
    	visited[start] = 1;
    	
    	loop:
    	while(!queue.isEmpty()) {
    		int vertex = queue.poll();
    		
    		for(int i : adjList[vertex]) {
    			if(visited[i] == 0) {
    				queue.add(i);
    				visited[i] = 1;
    				distance[i] = distance[vertex] + 1;
    				
    				if(i == target) {
    					break loop;
    				}
    			}
    		}
    	}
    	
    	if(visited[target] == 0) {
    		System.out.println(-1);
    	}else {
    		System.out.println(distance[target]);
    	}
    }
  
}