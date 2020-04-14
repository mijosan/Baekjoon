import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine(),".");
		//StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(int i=1;i<=n;i++) {
			queue.add(i);
		}
		
		while(queue.size() != 1) {
			queue.remove();
			
			queue.add(queue.poll());
		}
		
		System.out.println(queue.peek());
		
	}
}

