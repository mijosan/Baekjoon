import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.regex.Pattern;
//^[0-9]*$ : 숫자만
//^[가-힣]*$ : 한글만
//^[a-zA-Z0-9]*$ : 영어/숫자만
public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// StringTokenizer st = new StringTokenizer(br.readLine()," ");
		// StringBuilder sb = new StringBuilder();
		// int n = Integer.parseInt(br.readLine());
    	
    	String str = br.readLine();
    	
    	if(Pattern.matches("^[a-zA-Z]*$", str)) {
    		char[] ch = str.toCharArray();
    		
    		Stack<Character> stack = new Stack<Character>();
    		
    		for(char i : ch) {
    			stack.push(i);
    		}
    		
    		for(int i=0;i<ch.length;i++) {
    			ch[i] = stack.pop();
    		}
    		
    		str = String.valueOf(ch);
    		
    		System.out.println(str);

    	}else {
    		System.out.println("영어가 아닙니다");
    	}
    
    }
}
