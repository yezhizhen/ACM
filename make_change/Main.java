package make_change;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static void printtable(int k, int v, int[][] dp){
		for(int i=1;i<=k;i++){
			for(int j=1;j<=v;j++){
				System.out.print(dp[i][j]+"\t");
			}
			System.out.println();
	}
		}
	
	static void print(int[][] choice, int i, int j){

		while (i>=1) {
			System.out.println(choice[i][j]);
			j-=choice[i][j];
			i-=1;
			
		}
		
		
	}
	
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Input k, which is the number allowed: ");
		int k = s.nextInt();
		s.nextLine();
		System.out.println("Input value you want to get");
		int v = s.nextInt();
		s.nextLine();
		int dp[][] = new int[k + 1][v + 1];
		int choice[][] = new int[k + 1][v + 1];
		System.out.println("Input coins, with -1 to end");
		int tem;
		ArrayList<Integer> coin = new ArrayList<>();
		while ((tem = s.nextInt()) != -1) {
			coin.add(tem);
		}
		coin.add(0);
		// Collections.sort
		coin.sort((Integer a, Integer b) -> {
			return (a > b) ? 1 : -1;
		});
		// System.out.println(coin);
		// int[][] dp = new int
		for (int i = 0; i <= k; i++) {
			for (Integer citem : coin) {
				if (citem < v) {
					dp[i][citem] = 1;
					choice[i][citem] = citem;
				}
				if (citem == v) {
					System.out.println("Feasible");
					System.out.println("choose: " + citem);
					System.exit(0);
				}
			}
		}

		for (int i = 2; i <= k; i++) {
			for (int j = 1; j <= v; j++) {
				for (Integer item : coin) {
					if (item < j) {
						if (dp[i - 1][j - item] == 1 || dp[i-1][j] == 1) {
							dp[i][j] = 1;
							choice[i][j] = item;
							if (j == v) {
								System.out.println("Feasible\nChoose: ");
								//printtable(k,v,dp);
								print(choice, i, j);
								System.exit(0);
								
								//System.exit(0);
							}
							break;
						}
					}
				}
			}
		}
	
		
		System.out.println("Not feasible");
		s.close();
	}

}
