import java.util.Arrays;
import java.util.Scanner;

public class test{
	
	public static int[][] B = {
		{1,5,7,1},
		{1,5,7,2},
		{1,4,7,3},
		{2,8,7,4}
	};
	
	//1 30 36
	
	public static int[] A = new int[4];
	public static int i = 0;
	
	public static int text(){
		int input;
		Scanner sc = new Scanner(System.in);
		input = sc.nextInt();
		A[i] = input;
		i++;
		
		return input;
	}
	
	public static int search(){
		for(int a=0; a < 5; a++){
			for(int b=0; b < 3; b++){
				//System.out.printf("%d %d %d\n", a, b, B[a][b]);
				if(B[a][b] != A[b]){
					//System.out.printf("a%d %d %d\n", a, b, B[a][b]);
					break;
				}
				if(b == 2){
					System.out.printf("%d\n", B[a][3]);
					return 1;
				}
			}
		}
		return 0;
	}
}