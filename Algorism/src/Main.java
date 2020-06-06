import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static char[][] map = new char[12][6];
	static int[][] visited;
	static int[] x_move = {0, -1, 0, 1};
	static int[] y_move = {-1, 0, 1, 0};
	static ArrayList<Pair> adjList;
	static int count = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	for(int i=0;i<12;i++) {
    		String temp = br.readLine();
    		
    		for(int j=0;j<6;j++) {
    			map[i][j] = temp.charAt(j); 
    		}
    	}
    	
    	while(true) {
    		boolean flag = false;
    		visited = new int[12][6];
    		
    		for(int i=0;i<12;i++) {
    			for(int j=0;j<6;j++) {
    				if(visited[i][j] == 0 && map[i][j] != '.') {
    					adjList = new ArrayList<Pair>();
    					
    					bfs(i, j);
    					
    					if(adjList.size() >= 4) {
    						flag = true;
    						
    						for(Pair p : adjList) {
    							map[p.i][p.j] = '.';
    						}
    					}				
    				}
    			}
    		}
    		
    		if(flag == false) {
    			break;
    		}else {
    			count++;
    		}
    		
    		paint();
    	}
    	System.out.println(count);
    }
	
	static void bfs(int i, int j) {
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(i, j));
		visited[i][j] = 1;
		adjList.add(new Pair(i, j));
		
		while(!queue.isEmpty()) {
			Pair pair = queue.poll();
			
			int px = pair.i;
			int py = pair.j;
			
			for(int k=0;k<4;k++) {		
				int x = pair.i + x_move[k];
				int y = pair.j + y_move[k];
				
				if(x >= 0 && x < 12 && y >= 0 && y < 6) {
					if(visited[x][y] == 0 && map[x][y] == map[px][py]) {
						adjList.add(new Pair(x, y));
						queue.add(new Pair(x, y));
						visited[x][y] = 1;
					}
				}
			}
		}
	}
	
	static void paint() {
	    for (int i = 0; i < 6; i++) {
	        for (int j = 10; j >= 0; j--) {
	            for (int k = 11; k > j; k--) {
	                if (map[j][i] != '.' && map[k][i] == '.') {
	                    map[k][i] = map[j][i];
	                    map[j][i] = '.';
	                    break;
	                }
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
