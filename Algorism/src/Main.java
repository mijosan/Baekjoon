import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] x_move = {0, -1, 0, 1};
	static int[] y_move = {-1, 0, 1, 0};
	static char[][] map;
	static int[][] countMap;
	static int[][] visited;
	static int w;
	static int h;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	// StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	// StringBuilder sb = new StringBuilder();
    	// int n = Integer.parseInt(br.readLine());
    	
    	int t = Integer.parseInt(br.readLine());
    	
    	for(int i=0;i<t;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    		w = Integer.parseInt(st.nextToken());
    		h = Integer.parseInt(st.nextToken());
    		
    		map = new char[h][w];
    		countMap = new int[h][w];
    		visited = new int[h][w];
    		
    		for(int j=0;j<h;j++) {
    			String temp = br.readLine();
    			
    			for(int k=0;k<w;k++) {
    				map[j][k] = temp.charAt(k);
    			}
    		}
    		
    		bfs();
    	}
	}
	
	static void bfs() {
		Queue<Pair> queue = new LinkedList<Pair>();
		boolean flag = false;
		int count = 0;
		
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(map[i][j] == '*') {
					queue.add(new Pair(i, j, '*'));
					visited[i][j] = 1;
				}
			}
		}
		
		for(int i=0;i<h;i++) {
			for(int j=0;j<w;j++) {
				if(map[i][j] == '@') {
					queue.add(new Pair(i, j, '@'));
					visited[i][j] = 1;
				}
			}
		}
		loop:
		while(!queue.isEmpty()) {
			Pair pair = queue.poll();
			
			int px = pair.x;
			int py = pair.y;
			char type = pair.type;
			
			if(count == 0 && type == '@' && (px == 0 || py == 0 || px == h-1 || py == w-1)) {
				 System.out.println(countMap[px][py] + 1);
				 flag = true;
				 break loop;
			}
			
			for(int i=0;i<4;i++) {
				int x = px + x_move[i];
				int y = py + y_move[i];
				
				if(x >= 0 && y >= 0 && x < h && y < w) {
					 if(type == '*' && (map[x][y] == '.' || map[x][y] == '@') && visited[x][y] == 0) {
						 map[x][y] = type;
						 queue.add(new Pair(x, y, type));
						 visited[x][y] = 1;
					 }
					 
					 if(type == '@' && map[x][y] == '.' && visited[x][y] == 0) { 
						 map[x][y] = type;
						 map[px][py] = '.';
						 countMap[x][y] = countMap[px][py] + 1;
						 queue.add(new Pair(x, y, type));
						 visited[x][y] = 1;		
						 count++;
						 
						 if(x == 0 || y == 0 || x == h-1 || y == w-1) {
							 System.out.println(countMap[x][y] + 1);
							 flag = true;
							 break loop;
						 }
					 }
				}
			}
		}
		
		if(flag == false) {
			System.out.println("IMPOSSIBLE");
		}

	}
	
}
class Pair{
	int x;
	int y;
	char type;
	
	Pair(int x, int y, char type){
		this.x = x;
		this.y = y;
		this.type = type;
	}
}