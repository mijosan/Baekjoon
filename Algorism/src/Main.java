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
    	// StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	// StringBuilder sb = new StringBuilder();
    	// int n = Integer.parseInt(br.readLine());
    	
    	int t = Integer.parseInt(br.readLine());
    	
    	for(int i=0;i<t;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		
    		int n = Integer.parseInt(st.nextToken());
    		int m = Integer.parseInt(st.nextToken());
    		
    		ArrayList<Integer>[] adjList = new ArrayList[n + 1];
    		
    		for(int j=0;j<adjList.length;j++) {
    			adjList[j] = new ArrayList<Integer>();
    		}
    		
    		for(int j=0;j<m;j++) {
    			st = new StringTokenizer(br.readLine(), " ");
    			
    			int a = Integer.parseInt(st.nextToken());
    			int b = Integer.parseInt(st.nextToken());
    			
    			adjList[a].add(b);
    			adjList[b].add(a);
    		}
    		
    		int[] visited = new int[n + 1];
    		int count = 0;
    		
    		bfs(adjList, visited, count);
    	}
    	
	}
	
	static void bfs(ArrayList<Integer>[] adjList, int[] visited, int count) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		visited[1] = 1;
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			
			for(int i : adjList[v]) {
				if(visited[i] == 0) {
					queue.add(i);
					visited[i] = 1;
					count++;
				}
			}
		}
		
		System.out.println(count);
	}
}


