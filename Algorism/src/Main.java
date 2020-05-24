import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int m;
	static int n;
	static int[][] map;
	static int[][] visited;
	static int[] x_move = {0, -1, 0, 1};
	static int[] y_move = {-1, 0, 1, 0};
	static int area;
	static int[] areaCount;
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	
    	m = Integer.parseInt(st.nextToken());
    	n = Integer.parseInt(st.nextToken());
    	int k = Integer.parseInt(st.nextToken());
    	
    	map = new int[m][n];
    	visited = new int[m][n];
    	areaCount = new int[m*n];
    	
    	for(int i=0;i<k;i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		
    		int x1 = Integer.parseInt(st.nextToken());
    		int y1 = Integer.parseInt(st.nextToken());
    		int x2 = Integer.parseInt(st.nextToken());
    		int y2 = Integer.parseInt(st.nextToken());
    		
    		for(int j=y1;j<y2;j++) { 
    			for(int l=x1;l<x2;l++) {
    				map[j][l] = 1;
    			}
    		}
    	}
    	
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			if(map[i][j] == 0 && visited[i][j] == 0) {
    				areaCount[area] = 1;
    				bfs(i, j);
    				area++;
    			}
    		}
    	}
    	
    	Arrays.sort(areaCount,0,area);
    	
    	System.out.println(area);
    	
    	for(int i=0;i<area;i++) {
    		System.out.print(areaCount[i]);
    		
    		if(i != areaCount.length-1) {
    			System.out.print(" ");
    		}
    	}
    }
    
    static void bfs(int i, int j) {
    	Stack<Node> stack = new Stack<Node>();
    	
    	stack.push(new Node(i, j));
    	visited[i][j] = 1;
    	
    	while(!stack.isEmpty()) {
    		Node node = stack.peek();
    		boolean flag = false;
    		
    		for(int k=0;k<4;k++) {
    			int x = node.i + x_move[k];
    			int y = node.j + y_move[k];
    			
    			if(x >= 0 && x < m && y >=0 && y < n && map[x][y] == 0 && visited[x][y] == 0) {
    				stack.push(new Node(x, y));
    				visited[x][y] = 1;
    				areaCount[area] += 1;
    				
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
