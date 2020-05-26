import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int l;
	static int[][] map;
	static int[][] visited;
	static int[] x_move = {2, 1, -1, -2, -2, -1, 1, 2};
	static int[] y_move = {-1, -2, -2, -1, 1, 2, 2, 1};
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	int t = Integer.parseInt(br.readLine());
    	
    	for(int i=0;i<t;i++) {
    		l = Integer.parseInt(br.readLine());
    		map = new int[l][l];
    		visited = new int[l][l];
    		
    		StringTokenizer st = new StringTokenizer(br.readLine()," ");
    		
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		
    		st = new StringTokenizer(br.readLine()," ");
    		
    		int tx = Integer.parseInt(st.nextToken());
    		int ty = Integer.parseInt(st.nextToken());
    		
    		bfs(x, y, tx, ty);
    	}
    	
    }
    
    static void bfs(int x, int y, int tx, int ty) {
    	Queue<Node> queue = new LinkedList<Node>();
    	
    	queue.add(new Node(x, y));
    	visited[x][y] = 1;
    	
    	while(!queue.isEmpty()) {
    		Node node = queue.poll();
    		
    		int px = node.i;
    		int py = node.j;
    		
    		for(int i=0;i<8;i++) {
    			int mx = px + x_move[i];
    			int my = py + y_move[i];
    			
    			if(mx >= 0 && mx < l && my >= 0 && my < l) {
    				if(visited[mx][my] == 0) {
    					queue.add(new Node(mx, my));
    					visited[mx][my] = 1;
    					map[mx][my] = map[px][py] + 1;
    					
    					if(mx == tx && my == ty) {
    						break;
    					}
    				}
    			}
    		}
    	}
    	
    	System.out.println(map[tx][ty]);
    	
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
