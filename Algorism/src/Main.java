import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine()," ");
		//StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			int n2 = Integer.parseInt(st.nextToken()); //문서의 수
			int location = Integer.parseInt(st.nextToken()); //위치
			int count = 0; // 몇번째로 출력
			
			Queue<Pair> queue = new LinkedList<Pair>(); // 짝으로 큐에 저장 
			PriorityQueue<Integer> queue2 = new PriorityQueue(Collections.reverseOrder());//가중치 정렬

			StringTokenizer weightList = new StringTokenizer(br.readLine()," ");
			
			for(int j=0;j<n2;j++) {
				int priority = Integer.parseInt(weightList.nextToken());
				
				queue.offer(new Pair(j,priority));
				queue2.offer(priority);
			}
			
			while(!queue.isEmpty()) {
				Pair pair = queue.poll();
				if(pair.weight == queue2.peek()) {
					queue2.poll();
					count++;
					if(pair.number == location) {
						break;
					}
					
				}else {
					queue.offer(pair);
				}
			}
			System.out.println(count);
		}
	}
}

class Pair{
	
	int number;
	int weight;
	
	public Pair(int number, int weight) {
		this.number = number;
		this.weight = weight;
	}
	
}

