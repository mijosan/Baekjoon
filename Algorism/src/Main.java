import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine(),".");
		//StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		Queue queue = new Queue(n);
		for(int i=0;i<n;i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			String cmd = st.nextToken();

			if(cmd.equals("push")) {
				queue.push(Integer.parseInt(st.nextToken()));
			}else if(cmd.equals("pop")) {
				queue.pop();
			}else if(cmd.equals("size")) {
				queue.size();
			}else if(cmd.equals("empty")) {
				queue.empty();
			}else if(cmd.equals("front")) {
				queue.front();
			}else if(cmd.equals("back")) {
				queue.back();
			}
		}
		queue.bw.flush();
		
	}
}

class Queue {
	
	int[] queue;
	int next;
	int first;
	BufferedWriter bw;
	
	Queue(int n) {
		queue = new int[n];
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}

	void push(int x) {
		queue[next] = x;
		next++;
	}
	
	void pop() throws IOException {
		if(next == first) {
			bw.write("-1");
		}else {
			bw.write(queue[first] + "");
			queue[first] = 0;
			first++;
		}
		bw.newLine();
	}
	
	void size() throws IOException {
		bw.write(next-first + "");
		bw.newLine();
	}
	
	void empty() throws IOException {
		if(next == first) {
			bw.write("1");
		}else {
			bw.write("0");
		}
		bw.newLine();
	}
	
	void front() throws IOException {
		if(next == first) {
			bw.write("-1");
		}else {
			bw.write(queue[first] + "");
		}
		bw.newLine();
	}
	
	void back() throws IOException {
		if(next == first) {
			bw.write("-1");
		}else {
			bw.write(queue[next-1] + "");
		}
		bw.newLine();
	}
}
