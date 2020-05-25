import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//그 수에 도달했다는 뜻은 가장 빨리 도착했다는 뜻임
public class Main {
	static int[] map;
	static int[] visited;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	
    	int n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	map = new int[100001];
    	visited = new int[100001];
    	
    	bfs(n, k);
    }
    
    static void bfs(int n, int k) {
    	Queue<Integer> queue = new LinkedList<Integer>();
    	visited[n] = 1;
    	queue.add(n);
    	
    	loop:
    	while(!queue.isEmpty()) {
    		int fLocation = queue.poll();

    		for(int i=0;i<3;i++) {
    			if(i == 0) {
    				int location = fLocation + 1;
    				
    				if(location >= 0 && location <= 100000 && visited[location] == 0) {
	    				queue.add(location);
	    				visited[location] = 1;
	    				map[location] = map[fLocation] + 1;

	    				if(location == k) {
	    					break loop;
	    				}
    				}		
    			}else if(i == 1) {
    				int location = fLocation - 1;
    				
    				if(location >= 0 && location <= 100000 && visited[location] == 0) {
	    				queue.add(location);
	    				visited[location] = 1;
	    				map[location] = map[fLocation] + 1;
	    				
	    				if(location == k) {
	    					break loop;
	    				}
    				}	
    			}else if(i == 2) {
    				int location = fLocation * 2;
    				
    				if(location >= 0 && location <= 100000 && visited[location] == 0) {
	    				queue.add(location);
	    				visited[location] = 1;
	    				map[location] = map[fLocation] + 1;
	    				
	    				if(location == k) {
	    					break loop;
	    				}
    				}	
    			}    			
    		}
    	}
    	
    	System.out.println(map[k]);
    }
    
}
