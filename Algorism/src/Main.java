import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean check;
	static ArrayList<Integer>[] adjList;
	static int[] visited;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	int t = Integer.parseInt(br.readLine());
    	
    	for(int i=0;i<t;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine()," ");
    		
    		int v = Integer.parseInt(st.nextToken());
    		int e = Integer.parseInt(st.nextToken());
    		
    		adjList = new ArrayList[v + 1];
    		visited = new int[v + 1];
    		check = false;
    		
    		for(int j=1;j<adjList.length;j++) {
    			adjList[j] = new ArrayList<Integer>();
    		}
    		
    		for(int j=0;j<e;j++) {
    			st = new StringTokenizer(br.readLine()," ");
    			
    			int v1 = Integer.parseInt(st.nextToken());
    			int v2 = Integer.parseInt(st.nextToken());
    			
    			adjList[v1].add(v2);
    			adjList[v2].add(v1);
    		}
    		
    		for (int j = 1; j < v + 1; j++) {
				if(visited[j] == 0) {
					bfs(j);
				}
			}
    		
    		if(check == true) {
        		System.out.println("NO");
        	}else {
        		System.out.println("YES");
        	}
    	}	
    }
    static void bfs(int start){
    	Queue<Integer> queue = new LinkedList<Integer>();
    	queue.add(start);
  
    	visited[start] = 1;
    	
    	loop:
    	while(!queue.isEmpty()) {
    		int v = queue.poll();
    		
    		for(int i : adjList[v]) {
    			if(visited[i] == 0) {
    				queue.add(i);
    				visited[i] = visited[v] * -1;
 
    			}else if(visited[v] + visited[i] != 0) {
    				check = true;
    				break loop;
    			}
    		}
    	}     	
    }
}