import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] map = new int[n][m];
	static int[][] visited = new int[n][m];
	static int[] x_move = {0, -1, 0, 1};
	static int[] y_move = {-1, 0, 1, 0};
	static Queue<Node> queue;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	
    	m = Integer.parseInt(st.nextToken());
    	n = Integer.parseInt(st.nextToken());
    	map = new int[n][m];
    	visited = new int[n][m];
    	queue = new LinkedList<Node>();
    	
    	for(int i=0;i<n;i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		
    		for(int j=0;j<m;j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    			
    			if(map[i][j] == 1) {
    				queue.add(new Node(i, j));
    				visited[i][j] = 1;
    			}
    		}
    	}
    	
    	bfs();
    }
    
    static void bfs() {
    	int max = 1;
    	
    	while(!queue.isEmpty()) {
    		Node node = queue.poll();
    		
    		int fx = node.i;
    		int fy = node.j;
    		
    		for(int i=0;i<4;i++) {
    			int x = fx + x_move[i];
    			int y = fy + y_move[i];
    			
    			if(x >= 0 && x < n && y >= 0 && y < m) {
    				if(map[x][y] == 0 && visited[x][y] == 0) {
    					queue.add(new Node(x, y));
    					visited[x][y] = 1;
    					
    					map[x][y] = map[fx][fy] + 1;
    					max = Math.max(max, map[x][y]);
    				}
    			}
    		}
    	}
    	
    	if(check()) {
    		System.out.println(max-1);
    	}else {
    		System.out.println(-1);
    	}
    	
    }
    
    static boolean check() {
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			if(map[i][j] != -1 && visited[i][j] == 0) {
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
   
}

class Node{
	int i;
	int j;
	
	Node(int i, int j){
		this.i = i;
		this.j = j;
	}
}
