import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static char[][] map;
	static char[][] colorMap;
	static int[][] visited;
	static int[] x_move = {0, -1, 0, 1};
	static int[] y_move = {-1, 0, 1, 0};
	static int color;
	static int normal;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	n = Integer.parseInt(br.readLine());
    	
    	map = new char[n][n];
    	colorMap = new char[n][n];
    	visited = new int[n][n];
    	
    	for(int i=0;i<n;i++) {
    		String temp = br.readLine();
    		
    		for(int j=0;j<n;j++) {
    			char color = temp.charAt(j);
    			
    			map[i][j] = color;
    			
    			if(color == 'G') {
    				colorMap[i][j] = 'R';
    			}else {
    				colorMap[i][j] = color;
    			}
    					
    		}
    	}
    	
    	//Á¤»ó
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			if(visited[i][j] == 0) {
    				bfs(i, j, "normal");
    				normal++;
    			}
    		}
    	}
    	
    	visited = new int[n][n];
    	
    	//»ö¸Í
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<n;j++) {
    			if(visited[i][j] == 0) {
    				bfs(i, j, "color");
    				color++;
    			}
    		}
    	}
    	
    	System.out.println(normal + " " + color);
    }
    
    static void bfs(int i, int j, String state) {
    	Queue<Node> queue = new LinkedList<Node>();
    	queue.add(new Node(i, j));
    	visited[i][j] = 1;
    	
    	while(!queue.isEmpty()) {
    		Node node = queue.poll();
    		
    		int fx = node.i;
    		int fy = node.j;
    		
    		for(int k=0;k<4;k++) {
    			int x = fx + x_move[k];
    			int y = fy + y_move[k];
    	
    			if(x >= 0 && x < n && y >= 0 && y < n) {
    				if(state == "normal" && visited[x][y] == 0 && map[x][y] == map[fx][fy]) {		
    					queue.add(new Node(x, y));
    					visited[x][y] = 1;
    				}
    				
    				if(state == "color" && visited[x][y] == 0 && colorMap[x][y] == colorMap[fx][fy]) {		
    					queue.add(new Node(x, y));
    					visited[x][y] = 1;
    				}
    			}
    		}
    	}
    	
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

