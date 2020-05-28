import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static ArrayList<Integer>[] adjList;
	static int[] visited;
	static int[] distance;
	static int min = Integer.MAX_VALUE;
	static int[] count;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	count = new int[n + 1];
    	
    	adjList = new ArrayList[n + 1];
    	for(int i=0;i<adjList.length;i++) {
    		adjList[i] = new ArrayList();
    	}
    	
    	for(int i=0;i<m;i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		
    		int vertex1 = Integer.parseInt(st.nextToken());
    		int vertex2 = Integer.parseInt(st.nextToken());
    		
    		adjList[vertex1].add(vertex2);
    		adjList[vertex2].add(vertex1);
    	}
    	
    	bfs();
    	
    }
    
    static void bfs() { 	
    	for(int i=1;i<=n;i++) {
    		Queue<Integer> queue = new LinkedList<Integer>();
    		visited = new int[n + 1];
    		distance = new int[n + 1];

    		
        	queue.add(i);
        	visited[i] = 1;
        	
        	while(!queue.isEmpty()) {
        		int vertex = queue.poll();
        		
        		for(int j : adjList[vertex]) {
        			if(visited[j] == 0) {
        				queue.add(j);
        				visited[j] = 1;
        				distance[j] = distance[vertex] + 1;
        				count[i] = count[i] + distance[j];
        			}
        		}
        	}
    	}
    	
    	int temp = 0;
    	
    	for(int i=1;i<count.length;i++) {
    		if(min > count[i]) {
    			min = count[i];
    			temp = i;
    		}
    	}
    	System.out.println(temp);
    }
}