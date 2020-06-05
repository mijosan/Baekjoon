import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Pair>[] adjList;
	static int[] visited;
	static int n;
	static int max;
	static int maxNode;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	n = Integer.parseInt(br.readLine());
    	adjList = new ArrayList[n+1];

    	for(int i=1;i<adjList.length;i++) {
    		adjList[i] = new ArrayList<Pair>();
    	}
    	
    	for(int i=0;i<n-1;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine()," ");
    		
    		int parent = Integer.parseInt(st.nextToken());
    		int child = Integer.parseInt(st.nextToken());
    		int weight = Integer.parseInt(st.nextToken());
    		
    		adjList[parent].add(new Pair(child, weight));
    		adjList[child].add(new Pair(parent, weight));	
    	}
    	
    	bfs(1);
    	
    	bfs(maxNode);
    	
    	System.out.println(max);
    }
	
	static void bfs(int j) {
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(j, 0));
		visited = new int[n+1];
		visited[j] = 1;
		
		while(!queue.isEmpty()) {
			Pair pair = queue.poll();
			
			int pv = pair.v;
			int pw = pair.w;

			for(Pair i : adjList[pv]) {
				
				if(visited[i.v] == 0) {
					int v = i.v;
					int w = pw + i.w;
					
					queue.add(new Pair(v, w));
					visited[v] = 1;
					
					if(max <= w) {
						max = w;
						maxNode = v;
					}
				}
			}
		}
	}
 
}
class Pair{
	int v;
	int w;
	
	Pair(int v, int w){
		this.v = v;
		this.w = w;
	}
}
