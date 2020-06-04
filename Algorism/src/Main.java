import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static int[][] countMap;
	static int[][][] visited;
	static int[] x_move = {0, -1, 0, 1};
	static int[] y_move = {-1, 0, 1, 0};
	static int min = Integer.MAX_VALUE;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	
    	map = new int[n + 1][m + 1];
    	countMap = new int[n + 1][m + 1];
    	visited = new int[n + 1][m + 1][2];
    	
    	for(int i=1;i<=n;i++) {
    		String temp = br.readLine();

    		for(int j=1;j<=m;j++) {	 			
    			map[i][j] = temp.charAt(j-1) - '0';
    		}
    	}

    	bfs(); 	
    }
    
    static void bfs() {
    	Queue<Pair> queue = new LinkedList<Pair>();
    	
    	queue.add(new Pair(1, 1, 0));
    	visited[1][1][0] = 1;
    	boolean flag = false;
    	
    	loop:
    	while(!queue.isEmpty()) {
    		Pair pair = queue.poll();
    		
    		int px = pair.i;
    		int py = pair.j;
    		int wall = pair.k;
    		
    		for(int i=0;i<4;i++) {
    			int x = px + x_move[i];
    			int y = py + y_move[i];	
    			
    			if(x >= 1 && x <= n && y >= 1 && y <= m) {
    				if(wall == 0) {
    					if(map[x][y] == 0 && visited[x][y][0] == 0) {			
    						queue.add(new Pair(x, y, 0));
    						visited[x][y][0] = 1;
    						countMap[x][y] = countMap[px][py] + 1;
    					}else if(map[x][y] == 1 && visited[x][y][0] == 0) {
    						queue.add(new Pair(x, y, 1));
    						visited[x][y][1] = 1;
    						countMap[x][y] = countMap[px][py] + 1;
    					}
    					
    				}else if(wall == 1) {
    					if(map[x][y] == 0 && visited[x][y][1] == 0) {
    						queue.add(new Pair(x, y, 1));
    						visited[x][y][1] = 1;
    						countMap[x][y] = countMap[px][py] + 1;
    					}
    				}
    			}
    			
    			if(x == n && y == m) {
    				flag = true;
    				break loop;
    			}
    		}
    	}

    	if(flag == true || (n == 1 && m == 1)) {
    		System.out.println(countMap[n][m] + 1);
    	}else {
    		System.out.println(-1);
    	}
    }

}
class Pair{
	int i;
	int j;
	int k;
	
	Pair(int i, int j, int k){
		this.i = i;
		this.j = j;
		this.k = k;
	}
}