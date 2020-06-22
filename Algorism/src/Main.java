import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] num;
	static int[] op;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	// StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	// StringBuilder sb = new StringBuilder();
    	// int n = Integer.parseInt(br.readLine());
    	
    	int n = Integer.parseInt(br.readLine());
    	num = new int[n];
    	op = new int[4];

    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
    	
    	for(int i=0;i<n;i++) {
    		num[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	st = new StringTokenizer(br.readLine()," ");
    	
    	for(int i=0;i<4;i++) {
    		op[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	bfs();
    	
    	System.out.println(max); 
    	System.out.println(min);

	}
	
	static void bfs() {
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(num[0], op));
		
		for(int i=1;i<num.length;i++) {
			
			int length = queue.size();
			
			for(int j=0;j<length;j++) {
				Pair pair = queue.poll();
				
				int pn = pair.num;
				int[] po = pair.op;
						
				if(po[0] != 0) {
					int n = pn + num[i];
					int[] o = po.clone();
					o[0]--;

					queue.add(new Pair(n, o));
				}
				
				if(po[1] > 0) {
					int n = pn - num[i];
					int[] o = po.clone();
					o[1]--;
					
					queue.add(new Pair(n, o));
				}
				
				if(po[2] > 0) {
					int n = pn * num[i];
					int[] o = po.clone();
					o[2]--;

					queue.add(new Pair(n, o));
				}
				
				if(po[3] > 0) { 
					int n = pn / num[i];
					int[] o = po.clone();
					o[3]--;
					
					queue.add(new Pair(n, o));
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int temp = queue.poll().num;
			
			if(max < temp) {
				max = temp;
			}
			
			if(min > temp) {
				min = temp;
			}
		}
		
	}
	
}
class Pair { 
	int num; 
	int[] op; 
	
	Pair(int num, int[] op) { 
		this.num = num; 
		this.op = op; 
	} 
}

