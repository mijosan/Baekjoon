import java.io.IOException;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) throws NumberFormatException, IOException {
    	Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a=sc.nextInt();
        int b=sc.nextInt();
        double pita=Math.sqrt(Math.pow(a, 2)+Math.pow(b, 2)); //�ִ� ���� 
        
        for(int i=0;i<n;i++) {             
            System.out.println(sc.nextInt()<=pita?"DA":"NE");           
        }
    	
    }
}