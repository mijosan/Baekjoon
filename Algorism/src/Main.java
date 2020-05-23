import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int[][] visited;
	static int[] x_move = {0, -1, 0, 1};
	static int[] y_move = {-1, 0, 1, 0};
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	int n = Integer.parseInt(br.readLine());
    	int max = 0;
    	
    	map = new int[n+2][n+2];
    		
    	for(int i=1;i<=n;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine()," ");
    		
    		for(int j=1;j<=n;j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	
    	
    	for(int k=0;k<=100;k++) {
    		int count = 0;
    		visited = new int[n+2][n+2];

	    	for(int i=1;i<=n;i++) {    		
	    		for(int j=1;j<=n;j++) {
	    			if(map[i][j] > k && visited[i][j] == 0) {
	    				bfs(i, j, k);
	    				count++;
	    			}
	    		}
	    	}
	    	max = Math.max(max, count);
    	}
    	System.out.println(max);

    }
    
    static void bfs(int i, int j, int height) {
    	Stack<Node> stack = new Stack<Node>();
    	
    	stack.push(new Node(i, j));
    	visited[i][j] = 1;

    	while(!stack.isEmpty()) {
    		Node node = stack.peek();
    		boolean flag = false;
    		
    		for(int k=0;k<4;k++) {
    			int x = node.i + x_move[k];
    			int y = node.j + y_move[k];

    			if(map[x][y] != 0 && map[x][y] > height && visited[x][y] == 0) {

    				stack.push(new Node(x, y));
    				visited[x][y] = 1;

    				flag = true;
    				break;
    			}
    		}
    		
    		if(flag == false) {
    			stack.pop();
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
