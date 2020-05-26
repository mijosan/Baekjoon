import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int m;
	static int n;
	static int h;
	static int[][][] map;
	static int[][][] visited;
	static int[] x_move = {0, -1, 0, 1, 0, 0};
	static int[] y_move = {-1, 0, 1, 0, 0, 0};
	static int[] z_move = {0, 0, 0, 0, -1, 1};
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
    	h = Integer.parseInt(st.nextToken());
    	map = new int[h][n][m];
    	visited = new int[h][n][m];
    	queue = new LinkedList<Node>();
    	
    	for(int i=0;i<h;i++) {
    		for(int j=0;j<n;j++) {
    			st = new StringTokenizer(br.readLine()," ");
    			
    			for(int k=0;k<m;k++) {
    				map[i][j][k] = Integer.parseInt(st.nextToken());
    				
    				if(map[i][j][k] == 1) {
    					queue.add(new Node(i, j, k));
    					visited[i][j][k] = 1;
    				}
    			}
    		}
    	}
    	
    	bfs();
    }
    
    static void bfs() {
    	int max = 1;
    	
    	while(!queue.isEmpty()) {
    		Node node = queue.poll();
    		
    		int pi = node.i;
    		int pj = node.j;
    		int pk = node.k;
    		
    		for(int l=0;l<6;l++) {
    			int i = pi + z_move[l];
    			int j = pj + x_move[l];
    			int k = pk + y_move[l];
    			
    			if(i >= 0 && i < h && j >= 0 && j < n && k >=0 && k < m) {
    				if(map[i][j][k] == 0 && visited[i][j][k] == 0) {
	    				queue.add(new Node(i, j, k));
	    				visited[i][j][k] = 1;
	    				map[i][j][k] = map[pi][pj][pk] + 1;
	    				
	    				max = Math.max(max, map[i][j][k]);
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
    	for(int i=0;i<h;i++) {
    		for(int j=0;j<n;j++) {
    			for(int k=0;k<m;k++) {
    				if(map[i][j][k] != -1 && visited[i][j][k] == 0) {
    					return false;
    				}
    			}
    		}
    	}
    	
    	return true;
    }
}

class Node {
	int i;
	int j;
	int k;
	
	Node(int i, int j, int k){
		this.i = i;
		this.j = j;
		this.k = k;
	}
}
