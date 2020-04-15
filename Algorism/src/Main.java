import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//StringTokenizer st = new StringTokenizer(br.readLine()," ");
		//StringBuilder sb = new StringBuilder();
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int count = 0;
		
		for(int i=1;i<=n;i++) {
			list.add(i);
		}	
		st = new StringTokenizer(br.readLine()," ");
		
		while(st.hasMoreTokens()) {
			
			int target = Integer.parseInt(st.nextToken());
			
			int front = list.indexOf(target) - list.indexOf(list.peekFirst());
			int back = list.indexOf(list.peekLast()) - list.indexOf(target);

			while(true) {
				if(front <= back) { 

					if(list.peekFirst() == target) {
						list.pollFirst();
						break;
					}else {
						list.addLast(list.pollFirst());
						count ++;
					}
				}else { 
					if(list.peekFirst() == target) {
						list.pollFirst();
						break;
					}else {
						list.addFirst(list.pollLast());
						count ++;
					}
				}
			}
		}
		System.out.println(count);
	}
}


