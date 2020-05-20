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
	static int[][] map;
	static int[][] visited;
	static int[] homeCount;
	static int complexCount;
	static int[] x_move = {-1, 0, 1, 0};
	static int[] y_move = {0, 1, 0, -1};
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    	int n = Integer.parseInt(br.readLine());
    	
    	map = new int[n+2][n+2];
    	visited = new int[n+2][n+2];
    	homeCount = new int[n*n];
    	
    	for(int i=1;i<=n;i++) {
    		String input = br.readLine();
    		
    		for(int j=1;j<=n;j++) {
    			map[i][j] = input.charAt(j-1) - '0';
    		}
    	}
    	
    	for(int i=1;i<=n;i++) {
    		for(int j=1;j<=n;j++) {
    			if(map[i][j] == 1 && visited[i][j] == 0) {
    				homeCount[complexCount] = 1;
    				DFS(i, j);
    				complexCount++;
    			}
    		}
    	}
    	
    	System.out.println(complexCount);
    	
    	Arrays.sort(homeCount,0,complexCount);
    	for(int i=0;i<complexCount;i++) {
    		System.out.println(homeCount[i]);
    	}
    }
    
    static void DFS(int i, int j) {
    	Stack<Node> stack = new Stack<Node>();
    	
    	stack.add(new Node(i,j));
    	visited[i][j] = 1;
    	
    	while(!stack.isEmpty()) {
    		Node node = stack.peek();
    		boolean flag = false;
    		
    		for(int k=0;k<4;k++) {
    			int x = node.x + x_move[k];
    			int y = node.y + y_move[k];
    			
    			if(map[x][y] == 0 || visited[x][y] == 1) {
    				continue;
    			}
    			
    			stack.add(new Node(x, y));
    			visited[x][y] = 1;
    			homeCount[complexCount] += 1;
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
