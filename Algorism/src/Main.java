import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] x_move = {0, -1, 0, 1, 0, 0};
	static int[] y_move = {-1, 0, 1, 0, 0, 0};
	static int[] z_move = {0, 0, 0, 0, -1, 1};
	
	static char[][][] map;
	static int[][][] countMap;
	static int[][][] visited;
	
	static int l; //층
	static int r; //행
	static int c; //열
	
	public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	// StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	// StringBuilder sb = new StringBuilder();
    	// int n = Integer.parseInt(br.readLine());
    	
    	while(true) {
	    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	    	
	    	l = Integer.parseInt(st.nextToken());
	    	r = Integer.parseInt(st.nextToken());
	    	c = Integer.parseInt(st.nextToken());
	    	
	    	if(l == 0 && r == 0 && c == 0) break;
	    	
	    	map = new char[l][r][c];
	    	visited = new int[l][r][c];
	    	countMap = new int[l][r][c];
	    	
	    	for(int i=0;i<l;i++) {
	    		for(int j=0;j<r;j++) {
		    		String temp = br.readLine();
		    		
		    		for(int k=0;k<c;k++) {
		    			map[i][j][k] = temp.charAt(k);
		    		}
	    		}
	    		br.readLine();
	    	}	    	
	    	
	    	bfs();
    	}
	}
	
	static void bfs() {
		Queue<Pair> queue = new LinkedList<Pair>();
		boolean flag = false;
		
		loop1:
		for(int i=0;i<l;i++) {
			for(int j=0;j<r;j++) {
				for(int k=0;k<c;k++) {
					if(map[i][j][k] == 'S') {
						queue.add(new Pair(i, j, k));
						visited[i][j][k] = 1;
						break loop1;
					}
				}
			}
		}
		
		loop2:
		while(!queue.isEmpty()) {
			Pair pair = queue.poll();
			
			int pz = pair.z;
			int px = pair.x;
			int py = pair.y;
	
			for(int i=0;i<6;i++) {
				int z = pz + z_move[i];
				int x = px + x_move[i];
				int y = py + y_move[i];
				
				if(x >= 0 && y >= 0 && z >= 0 && x < r && y < c && z < l) {
					if((map[z][x][y] == '.' || map[z][x][y] == 'E') && visited[z][x][y] == 0) {
						visited[z][x][y] = 1;
						countMap[z][x][y] = countMap[pz][px][py] + 1;
						queue.add(new Pair(z, x, y));
						
						if(map[z][x][y] == 'E') {
							System.out.println("Escaped in " + countMap[z][x][y] + " minute(s).");
							flag = true;
							
							break loop2;
						}
					}
				}
			}
		}
		
		if(flag == false) {
			System.out.println("Trapped!");
		}
	}
}

class Pair{
	int z;
	int x;
	int y;
	
	Pair(int z, int x, int y){
		this.z = z;
		this.x = x;
		this.y = y;
	}
}