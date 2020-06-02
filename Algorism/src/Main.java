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
	static int[][] count;
	static int[][] visited;
	static int[] x_move = {0, -1, 0, 1};
	static int[] y_move = {-1, 0, 1, 0};
	
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
    	count = new int[n][m];
    	visited = new int[n][m];
    	
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
    	boolean flag = false;
    	
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			if(map[i][j] == '*') {
    				queue.add(new Pair(i, j, '*'));
    				visited[i][j] = 1;
    			}
    		}
    	}
    	
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			if(map[i][j] == 'S') {
    				queue.add(new Pair(i, j, 'S'));
    				visited[i][j] = 1;
    			}
    		}
    	}
    	loop:
    	while(!queue.isEmpty()) {
    		Pair pair = queue.poll();
    		
    		int px = pair.i;
    		int py = pair.j;
    		char pc = pair.k;
    		
    		for(int i=0;i<4;i++) {
    			int x = px + x_move[i];
    			int y = py + y_move[i];
    			
    			if(x >= 0 && x < n && y >= 0 && y < m) {
    				if(pc == '*') {
	    				if(map[x][y] == '.' && visited[x][y] == 0) {
	    					queue.add(new Pair(x, y, '*'));
	    					map[x][y] = '*';
	    					visited[x][y] = 1;	
	    				}
    				}
    				
    				if(pc == 'S') {
	    				if(map[x][y] == '.' && visited[x][y] == 0) {
	    					queue.add(new Pair(x, y, 'S'));
	    					visited[x][y] = 1;
	    					count[x][y] = count[px][py] + 1;    					
	    				}
	    				
	    				if(map[x][y] == 'D') {
	    					count[x][y] = count[px][py] + 1;
	    					System.out.println(count[x][y]);
	    					flag = true;
	    					break loop;
	    				}
    				}
    			}
    		}
    	}
    	
    	if(flag == false) {
    		System.out.println("KAKTUS");
    	}
    }
}
class Pair{
	int i;
	int j;
	char k;
	
	Pair(int i, int j, char k){
		this.i = i;
		this.j = j;
		this.k = k;
	}
}

