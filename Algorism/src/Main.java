import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    
	static int[][] map;
	static int[][] visited;
	static int n;
	
	static int[] x_move = {0, -1, 0, 1};
	static int[] y_move = {-1, 0, 1, 0};
	
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // StringBuilder sb = new StringBuilder();
        // int n = Integer.parseInt(br.readLine());
        
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        
        for(int i = 0; i < n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	
        	for(int j = 0; j < n; j++) {
        		map[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        bfs();
    }
    
    static void bfs() {
    	Queue<Pair> queue = new LinkedList<Pair>();
    	visited = new int[n][n];
    	
    	int label = 1;
    	
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			if(visited[i][j] == 0 && map[i][j] == 1) {
    				queue.add(new Pair(i, j));
    				visited[i][j] = 1;
    				map[i][j] = label;
    				
    				while(!queue.isEmpty()) {
    					Pair pair = queue.poll();
    					
    					int px = pair.x;
    					int py = pair.y;
    					
    					for(int k = 0; k < 4; k++) {
    						int x = px + x_move[k];
    						int y = py + y_move[k];
    						
    						if(x >= 0 && y >= 0 && x < n && y < n) {
    							if(visited[x][y] == 0 && map[x][y] == 1) {
    								queue.add(new Pair(x, y));
    								visited[x][y] = 1;
    								map[x][y] = label;
    							}
    						}
    					}
    				}
    				
    				label++;
    			}
    		}
    	}
    }
}

class Pair{
    int x;
    int y;
    
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}