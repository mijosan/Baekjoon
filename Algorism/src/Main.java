import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine()," ");
		//StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Queue<Integer> queue = new LinkedList<Integer>();
		int[] result = new int[n];
		int index = 0;
		
		for(int i=1;i<=n;i++) {
			queue.add(i);
		}
		
		while(queue.size() != 0) {
			for(int i=0;i<k;i++) {
				if(i == k-1) {
					result[index] = queue.poll();
					index++;
				}else {
					queue.add(queue.poll());
				}
			}
		}
		
		for(int i=0;i<result.length;i++) {
			if(i == 0) {
				if(result.length == 1) {
					bw.write("<" + result[i] + ">");
				}else {
					bw.write("<" + result[i] + ", ");
				}
			}else if(i == result.length-1) {
				bw.write(result[i] + "");
				bw.write(">");
			}else {
				bw.write(result[i] + ", ");
			}
		}
		bw.flush();	
	}
}

