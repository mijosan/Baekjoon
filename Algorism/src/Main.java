import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[][] visited;
	static int[] x_move = {0, -1, 0, 1};
	static int[] y_move = {-1, 0, 1, 0};
	static int n;
	static int m;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	map = new int[n][m];
    	visited = new int[n][m];
  
    	for(int i=0;i<n;i++) {
    		String s = br.readLine(); 
    				
    		for(int j=0;j<m;j++) {
    			map[i][j] = s.charAt(j) - '0';
    		}
    	}
    	
    	bfs();	
    }
    
    static void bfs() {
    	Queue<Node> queue = new LinkedList<Node>();
    	
    	queue.add(new Node(0, 0));
    	visited[0][0] = 1;

    	while(!queue.isEmpty()) {
    		Node node = queue.poll();
    		
    		int fx = node.i;
    		int fy = node.j;
    		
    		for(int i=0;i<4;i++) {
    			int x = x_move[i] + node.i;
    			int y = y_move[i] + node.j;
    			
    			if(x >= 0 && x < n && y >= 0 && y < m) {
    				if(map[x][y] == 1 && visited[x][y] == 0) {
    					queue.add(new Node(x, y));
    					visited[x][y] = 1;
    					map[x][y] = map[fx][fy] + 1;
    				}
    			}
    		}
    		
    	}
    	System.out.println(map[n-1][m-1]);
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
