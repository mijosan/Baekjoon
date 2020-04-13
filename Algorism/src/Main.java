import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine()," ");
		//StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
	
		for(int i=0;i<n;i++) {
			Stack<Character> stack = new Stack<Character>();
			String s = br.readLine();
			
			for(int j=0;j<s.length();j++) {

				if(s.charAt(j) == '(') {
					stack.add('(');
				}else {
					if(stack.empty()) {
						stack.add('x');
						break;
					}else {
						stack.pop();
					}
				}
			}
			if(stack.empty()) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
		
	}
	
}

