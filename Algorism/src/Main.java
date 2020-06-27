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
	
	static int[] hx_move = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] hy_move = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	static int[][] map;
	static int[][][] visited;
	static int[][] countMap;
	
	static int k;
	static int w;
	static int h;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	// StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	// StringBuilder sb = new StringBuilder();
    	// int n = Integer.parseInt(br.readLine());
    	
    	k = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	
    	w = Integer.parseInt(st.nextToken());
    	h = Integer.parseInt(st.nextToken());
    	
    	map = new int[h][w];
    	countMap = new int[h][w];
    	
    	for(int i=0;i<h;i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		
    		for(int j=0;j<w;j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	bfs();
	}
	
	static void bfs() {
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(0, 0, k));
		
		visited = new int[h][w][k+1];
		visited[0][0][k] = 1;
		
		Boolean flag = false;
		
		while(!queue.isEmpty()) {
			Pair pair = queue.poll();
			
			int px = pair.x;
			int py = pair.y;
			int pk = pair.k;
			
			if(px == h-1 && py == w-1) {
				flag = true;
				break;
			}
			
			for(int i=0;i<4;i++) {
				int x = px + x_move[i];
				int y = py + y_move[i];

				if(x >= 0 && y >= 0 && x < h && y < w) {
					if(map[x][y] == 0 && visited[x][y][pk] == 0) {
						countMap[x][y] = countMap[px][py] + 1;
						visited[x][y][pk] = 1;

						queue.add(new Pair(x, y, pk));
					}
				}
			}
			
			if(pk >= 1) {
				for(int i=0;i<8;i++) { 
					int x = px + hx_move[i];
					int y = py + hy_move[i];
					
					if(x >= 0 && y >= 0 && x < h && y < w) {
						if(map[x][y] == 0 && visited[x][y][pk-1] == 0) {
							countMap[x][y] = countMap[px][py] + 1;
							visited[x][y][pk-1] = 1;
							
							queue.add(new Pair(x, y, pk-1));
						}
					}
				} 
			}
			
		}

		if(flag == true) {
			System.out.println(countMap[h-1][w-1]);
		}else {
			System.out.println(-1);
		}
	}
	
}

class Pair{
	int x;
	int y;
	int k;
	
	Pair(int x, int y, int k){
		this.x = x;
		this.y = y;
		this.k = k;
	}
}


