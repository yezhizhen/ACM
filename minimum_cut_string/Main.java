package minimum_cut_string;

import java.util.ArrayList;

public class Main {
	static int strlen = 40;
	static int[][] orders = new int[strlen+1][strlen+1];
	static int cost[][] = new int[strlen+1][strlen+1]; 
	
	static void printresult( int start, int end){
		
		if (start>=end || orders[start][end]< start || orders[start][end]>=end) return;
		
		System.out.println(orders[start][end]);
		
		printresult(start, orders[start][end]);
		
		printresult(orders[start][end]+1, end);
		
	}
	
	public static void main(String[] args){
		int[] cutpoint = {1,2,22};
		//ArrayList<Integer> order = new ArrayList<>();
		
		//use 1 to 30
		for(int i=strlen;i>=1;i--)
			for(int j=i+1;j<=strlen;j++){
				
				int q = Integer.MAX_VALUE;
				int cuts = -1;
				//compute cost[i][j]
				for(int t=0;t<cutpoint.length;t++){
					if(cutpoint[t]<i || cutpoint[t]>=j)	continue;
					
					if(q > cost[i][cutpoint[t]]+cost[cutpoint[t]+1][j]+j-i+1){
						q= cost[i][cutpoint[t]]+cost[cutpoint[t]+1][j]+j-i+1;
						cuts = cutpoint[t];
					}
						
				}
				//Now cost[i][j] is calculated. 
				if (q!=Integer.MAX_VALUE) {
					cost[i][j] = q;
					orders[i][j] = cuts;
				}

			}
		printresult( 1, strlen);

//		for(int i=1;i<=strlen;i++){
//			for(int j=1;j<=strlen;j++){
//				System.out.print(cost[i][j]+"\t");
//			}
//			System.out.println();
//		}
		
		
	}
	
}
