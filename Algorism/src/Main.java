import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	static int max;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
		
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
  
    	n = Integer.parseInt(st.nextToken()); //세로 
    	m = Integer.parseInt(st.nextToken()); //가로
  
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
		 
    	for(int x1=0;x1<n;x1++){
    		for(int y1=0;y1<m;y1++){
    			if(copyMap[x1][y1] != 0) continue;
    			
    			for(int x2=0;x2<n;x2++){
    				for(int y2=0;y2<m;y2++){
    					if(x1==x2 && y1==y2) continue;
    					if(copyMap[x2][y2] != 0) continue;
    					
    					for(int x3=0;x3<n;x3++){
    						for(int y3=0;y3<m;y3++){
    					       if((x1==x3 && y1==y3) || (x2==x3 && y2==y3)) continue;
    					       if(copyMap[x3][y3] != 0) continue;
    					       
    					       copyMap[x1][y1] = 1;
    					       copyMap[x2][y2] = 1;
    					       copyMap[x3][y3] = 1;
    		
    					       bfs();
    						}
    					}
    				}
    			}
    		}
    	}
    	
    	System.out.println(max);
    }
    static void bfs() {
    	visited = new int[n][m];
    	Queue<Node> queue = new LinkedList<Node>();
    	
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			if(map[i][j] == 2) {
    				visited[i][j] = 1;
    				queue.add(new Node(i, j));
    				
    				while(!queue.isEmpty()) {
    					Node node = queue.poll();
    					
    					int px = node.i;
    					int py = node.j;
    					
    					for(int k=0;k<4;k++) {
    						int x = px + x_move[k];
    						int y = py + y_move[k];
    						
    						if(x >= 0 && x < n && y >= 0 && y < m) {
    							if(copyMap[x][y] == 0 && visited[x][y] == 0) {
    								queue.add(new Node(x, y));
    								visited[x][y] = 1;
    								copyMap[x][y] = 2;
    							}
    						}
    					}
    				}
    			}
    		}
    	}
    	
    	int count = 0;
    	
    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			if(copyMap[i][j] == 0) {
    				count++;
    			}
    		}
    	}
    	
    	max = Math.max(max, count);

    	for(int i=0;i<n;i++) {
    		for(int j=0;j<m;j++) {
    			copyMap[i][j] = map[i][j];
    		}
    	}	
    }
}
class Node{
	int i;
	int j;
	
	Node(int i, int j) {
		this.i = i;
		this.j = j;
	}
}