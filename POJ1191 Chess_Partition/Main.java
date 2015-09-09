package chess_partition;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	final static int maxpart=14;
	static double avg;
	static int total;
	static double dp[][][][][]= new double[9][9][10][10][maxpart];
	static int chess[][]= new int[9][9];
	static int areasq[][][][] = new int[9][9][10][10]; 
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		// number of partitions
		int partitions = s.nextInt()-1;
		total = partitions+1;
		//System.out.println(total); 
		// initialize chess
		for (int i=1;i<=8;i++)
			for(int j=1;j<=8;j++){
				chess[i][j]=s.nextInt();
			}
		calculate();
		//initialize Dynamic Programming
//		for(int x1=0;x1<=8;x1++)
//			for(int x2=0;x2<=8;x2++)
//				for(int x3=0;x3<=9;x3++)
//					for(int x4=0;x4<=9;x4++)
//						for(int x5=0;x5<maxpart;x5++)
//							dp[x1][x2][x3][x4][x5]=-1;
		for(double[][][][] a:dp)
			for(double[][][] b:a)
				for(double[][]c:b)
					for(double[] d:c)
						Arrays.fill(d, -1);
		
		double result = rec(partitions,1,1,9,9);
		System.out.printf("%.3f\n",Math.sqrt(result/total-avg*avg));
	}
	
	public static void calculate(){
			
		for(int x=1;x<=8;x++)
			for(int y=1;y<=8;y++){
				avg+=chess[x][y];
			}
		avg/=total;
		for(int x1=1;x1<=8;x1++)
			for(int x2=2;x2<=9;x2++)
				for(int y1=1;y1<=8;y1++)
					for(int y2=2;y2<=9;y2++){
						int sum=0;
						for(int x=x1; x<=x2-1; x++)
							for(int y=y1;y<=y2-1;y++){
								sum+= chess[x][y];
							}
						areasq[x1][y1][x2][y2] = sum*sum;
					}
						
	}
	
	public static double rec(int k,int x1,int y1,int x2,int y2){
		if((int)dp[x1][y1][x2][y2][k]!=-1) return dp[x1][y1][x2][y2][k];
		
		if(k==0) return areasq[x1][y1][x2][y2];
		
		double minrow= Double.MAX_VALUE;
		//find the min sum of squares when partition in column direction
		for(int a=x1+1;a<=x2-1;a++){
			minrow = Math.min(Math.min(rec(k-1,a,y1,x2,y2)+areasq[x1][y1][a][y2], areasq[a][y1][x2][y2]
					+rec(k-1,x1,y1,a,y2)),minrow);
		}
		double mincol = Double.MAX_VALUE;
		
		for(int b=y1+1; b<=y2-1;b++){
			mincol = Math.min(Math.min(rec(k-1,x1,b,x2,y2)+areasq[x1][y1][x2][b], areasq[x1][b][x2][y2]
					+rec(k-1,x1,y1,x2,b)),mincol);
		}
		dp[x1][y1][x2][y2][k] = Math.min(minrow, mincol);
		return dp[x1][y1][x2][y2][k];
	}
	
}
