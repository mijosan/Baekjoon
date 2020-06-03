import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int f;
	static int s;
	static int g;
	static int u;
	static int d;
	static int[] map;
	static int[] visited;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	
    	f = Integer.parseInt(st.nextToken());
    	s = Integer.parseInt(st.nextToken());
    	g = Integer.parseInt(st.nextToken());
    	u = Integer.parseInt(st.nextToken());
    	d = Integer.parseInt(st.nextToken());
    	
    	map = new int[f + 1];
    	visited = new int[f + 1];
    	
    	bfs();
    	
    }
    
    static void bfs() {
    	Queue<Integer> queue = new LinkedList<Integer>();
    	
    	queue.add(s);
    	visited[s] = 1;
    	boolean flag = false;
    	
    	while(!queue.isEmpty()) {
    		int p = queue.poll();
    		
    		int x = p + u;
    		int y = p - d;
    		
    		if(p == g) {
    			System.out.println(map[p]);
    			flag = true;
    			break;
    		}
    		
    		if(x >= 1 && x <= f) {
    			if(visited[x] == 0) {
    				queue.add(x);
    				visited[x] = 1;
    				map[x] = map[p] + 1;
    				
    				if(x == g) {
    					System.out.println(map[x]);
    					flag = true;
    					break;
    				}
    			}
    		}
    		if(y >= 1 && y <= f) {	
    			if(visited[y] == 0) {
    				queue.add(y);
    				visited[y] = 1;
    				map[y] = map[p] + 1;
    				
    				if(y == g) {
    					System.out.println(map[y]);
    					flag = true;
    					break;
    				}
    			}
    		}
    	}

    	if(flag == false) {
    		System.out.println("use the stairs");
    	}
    }
}
