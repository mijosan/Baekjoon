import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine()," ");
		//StringBuilder sb = new StringBuilder();
		
		
		int n = Integer.parseInt(br.readLine());
		Stack stack = new Stack(n);
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			String cmd = st.nextToken();
			
			if(cmd.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			}else if(cmd.equals("pop")) {
				stack.pop();
			}else if(cmd.equals("size")) {
				stack.size();
			}else if(cmd.equals("empty")) {
				stack.empty();
			}else if(cmd.equals("top")) {
				stack.top();
			}
		}
	}
	
}

class Stack{
	
	int[] stack;
	int top;
	
	
	Stack(int n){
		stack = new int[n];
	}
	
	
	void push(int x) {
		stack[top] = x;
		top++;
	}
	
	void pop() {
		if(top == 0) {
			System.out.println("-1");
		}else {
			--top;
			System.out.println(stack[top]);
			stack[top] = 0;
		}
	}
	
	void size() {
		System.out.println(top);
	}
	
	void empty() {
		if(top == 0) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}
	}
	
	void top() {
		if(top == 0) {
			System.out.println("-1");
		}else {
			System.out.println(stack[top-1]);
		}
	}
}
