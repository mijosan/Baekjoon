import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static char[][] map;
	static int[][] countMap;
	static int[][] visited;
	static int[] x_move = {0, -1, 0, 1};
	static int[] y_move = {-1, 0, 1, 0};
	static int max;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	map = new char[n][m];
    	
    	for(int i=0;i<n;i++) {
    		String temp = br.readLine();
    		
    		for(int j=0;j<m;j++) {
    			map[i][j] = temp.charAt(j);
    		}
    	}
    	
    	bfs();
    }
    
    static void bfs() {
    	Queue<Pair> queue = new LinkedList<Pair>();
    	
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			if(map[i][j] == 'L') {
    				visited = new int[n][m];
    				countMap = new int[n][m];
    				
    				queue.add(new Pair(i, j));
    				visited[i][j] = 1;
    				
    				while(!queue.isEmpty()) {
    					Pair pair = queue.poll();
    					
    					int px = pair.i;
    					int py = pair.j;
    					
    					for(int k=0;k<4;k++) {
    						int x = px + x_move[k];
    						int y = py + y_move[k];
    						
    						if(x >= 0 && x < n && y >=0 && y < m) {
    							if(visited[x][y] == 0 && map[x][y] == 'L') {
    								queue.add(new Pair(x, y));
    								visited[x][y] = 1;
    								countMap[x][y] = countMap[px][py] + 1;
    								
    								max = Math.max(max, countMap[x][y]);
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    	
    	System.out.println(max);
    }
}
class Pair{
	int i;
	int j;
	
	Pair(int i, int j){
		this.i = i;
		this.j = j;
	}
}
