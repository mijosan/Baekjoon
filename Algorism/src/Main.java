import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static int[][] copyMap;
	static int[][] visited;
	static int[] x_move = {0, -1, 0, 1};
	static int[] y_move = {-1, 0, 1, 0};
	static int min;
	static int count;
	
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
    	copyMap = new int[n][m];
    	
    	for(int i=0;i<n;i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		
    		for(int j=0;j<m;j++) {
    			int temp = Integer.parseInt(st.nextToken());
    			map[i][j] = temp;
    			copyMap[i][j] = temp;
    		}
    	}
    	boolean flag = false;
    	
    	loop:
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			if(map[i][j] != 0) {		
    				bfs(i, j);
    				count++;
    			
	    			min = 0;
	    	    	checkBfs();
	    	    	
	    	    	if(min >= 2) {
	    	    		System.out.println(count);
	    	    		flag = true;
	    	    		break loop;
	    	    	}
    			}
    		}
    	}
    	
    	if(flag == false) {
    		System.out.println(0);
    	}
    	
    }
    
    static void bfs(int i, int j) {
    	Queue<Pair> queue = new LinkedList<Pair>();
    	queue.add(new Pair(i, j));

    	visited = new int[n][m];
    	visited[i][j] = 1;
    	
    	while(!queue.isEmpty()) {
    		Pair pair = queue.poll();
    		
    		int px = pair.i;
    		int py = pair.j;
    		
    		for(int k=0;k<4;k++) {
    			int x = px + x_move[k];
    			int y = py + y_move[k];
    			
    			if(map[x][y] == 0) {
    				copyMap[px][py]--;
    				
    				if(copyMap[px][py] < 0) {
    					copyMap[px][py] = 0;
    				}
    				
    			}else if(map[x][y] != 0 && visited[x][y] == 0) {
    				queue.add(new Pair(x, y));
    				visited[x][y] = 1;
    			}
    		}
    	}
    	
    	for(int l=0;l<n;l++) {
    		for(int o=0;o<m;o++) {
    			map[l][o] = copyMap[l][o];
    		}
    	}
    }
    
    static void checkBfs() {
    	Queue<Pair> queue = new LinkedList<Pair>();
    	visited = new int[n][m];
    	
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			if(map[i][j] != 0 && visited[i][j] == 0) {
    				visited[i][j] = 1;
    				queue.add(new Pair(i, j));
    				
    				while(!queue.isEmpty()) {
    		    		Pair pair = queue.poll();
    		    		
    		    		int px = pair.i;
    		    		int py = pair.j;
    		    		
    		    		for(int k=0;k<4;k++) {
    		    			int x = px + x_move[k];
    		    			int y = py + y_move[k];
    		    			
    		    			if(map[x][y] != 0 && visited[x][y] == 0) {
    		    				queue.add(new Pair(x, y));
    		    				visited[x][y] = 1;
    		    			}
    		    		}
    		    	}
    				
    				min++;
    			}
    		}
    	}
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