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
    	
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	int[] count = new int[n + 1];
    	ArrayList<Integer>[] adjList = new ArrayList[n + 1];
    	
    	for(int i=0;i<adjList.length;i++) {
    		adjList[i] = new ArrayList<Integer>();
    	}
    	
    	for(int i=0;i<m;i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		
    		adjList[b].add(a);
    	}
    	
    	bfs(n, adjList, count);
    	
    }
    
    static void bfs(int n, ArrayList<Integer>[] adjList, int[] count) {
    	for(int i=1;i<=n;i++) {
    		Queue<Integer> queue = new LinkedList<Integer>();
    		int[] visited = new int[n + 1];
    		
    		queue.add(i);
    		visited[i] = 1;
    		
    		while(!queue.isEmpty()) {
    			int v = queue.poll();
    			
    			for(int j : adjList[v]) {
    				if(visited[j] == 0) {
    					queue.add(j);
    					visited[j] = 1;
    					count[i] = count[i] + 1;
    				}
    			}
    		}
    		
    	}
    	int max = Integer.MIN_VALUE;
    	
    	for(int i=1;i<=n;i++) {
    		if(max <= count[i]) {
    			max = count[i];
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i=1;i<=n;i++) {
    		if(count[i] == max) {
    			sb.append(i + " ");
    		}
    	}
    	System.out.println(sb.toString().trim());
    	
    }

}