import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
//DP : 주어진 문제를 여러 개의 부분 문제들로 나누어 푼 다음, 그 결과들로 주어진 문제를 푼다.

public class Main {
	static int[] x_move = {-1, 0, 1, 0};
	static int[] y_move = {0, 1, 0, -1};
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	int t = Integer.parseInt(br.readLine());
    	
    	for(int i=0;i<t;i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine()," ");
    		
    		int m = Integer.parseInt(st.nextToken()); //가로 길이
    		int n = Integer.parseInt(st.nextToken()); //세로 길이
    		int k = Integer.parseInt(st.nextToken()); //배추 위치 개수
    		int[][] map = new int[m+2][n+2];
    		int[][] visited = new int[m+2][n+2];
    		int count = 0;
    		
    		for(int j=0;j<k;j++) {
    			st = new StringTokenizer(br.readLine()," ");
    			
    			int x = Integer.parseInt(st.nextToken());
    			int y = Integer.parseInt(st.nextToken());

    			
    			map[x+1][y+1] = 1;					
    		}
    		
    		for(int l=1;l<=m;l++) { 
				for(int o=1;o<=n;o++) {
					if(map[l][o] == 1 && visited[l][o] == 0) {
						dfs(map, visited, l, o);
						count++;
					}
				} 
			}	
    		
    		System.out.println(count);
    	}
   
    }
    
    static void dfs(int[][] map, int[][] visited, int l, int o) {
    	Stack<Node> stack = new Stack<Node>();
    	
    	stack.add(new Node(l,o));
    	visited[l][o] = 1;
    	
    	while(!stack.isEmpty()) {
    		Node node = stack.peek();
    		boolean flag = false;
    		
    		for(int i=0;i<4;i++) {
    			int x = node.x + x_move[i];
    			int y = node.y + y_move[i];
    			
    			if(map[x][y] == 0 || visited[x][y] == 1) {
    				continue;
    			}
    			
    			stack.add(new Node(x, y));
    			visited[x][y] = 1;
    			flag = true;
    			
    			break;
    		}
    		
    		if(flag == false) {
    			stack.pop();
    		}
    		
    		
    	}
    }
    
}

class Node{
	int x;
	int y;
	
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}
