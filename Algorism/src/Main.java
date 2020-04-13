import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine(),".");
		//StringBuilder sb = new StringBuilder();
		
		Stack<Character> stack = new Stack<Character>();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(),".");
			String s = null;
			if(st.hasMoreTokens()) {
				s = st.nextToken();
			}else {
				break;
			}
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i) == '(' || s.charAt(i) == '[') {
					stack.push(s.charAt(i));
					//System.out.println(s.charAt(i) + " Çª½Ã");
				}else if(stack.isEmpty() == false && s.charAt(i) == ')' && stack.peek() == '(') {
					//System.out.println(stack.peek() + " ÆË");
					stack.pop();
				}else if(stack.isEmpty() == false && s.charAt(i) == ']' && stack.peek() == '[') {
					//System.out.println(stack.peek() + " ÆË");
					stack.pop();
				}else if(s.charAt(i) == ')' || s.charAt(i) == ']'){
					stack.push('x');
					break;
				}
			}
			
			if(stack.isEmpty()) {
				System.out.println("yes");
			}else {
				System.out.println("no");
			}

			stack.clear();
		}
	
	}
	
}

