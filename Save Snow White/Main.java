package save_snow_white;

import java.util.Scanner;




public class Main {
	
	static int row;
	static int col;
	static Tile[][] t;
	static int rowS, colS, rowW,colW;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int cases = s.nextInt();
		
		for(int a=0;a<cases;a++){
			row = s.nextInt();
			col = s.nextInt();
			s.nextLine();
			t = new Tile[row][col];
			//read data of tiles
			for (int r=0;r<row;r++){
				StringBuffer sb = new StringBuffer(s.nextLine());
				for(int c=0;c<col;c++){
					char tem = sb.charAt(c);
					
					if(tem=='S'){
						rowS = r;
						colS = c;
						t[rowS][colS] = new Tile(false);
						continue;
					}
					
					if(tem=='W'){
						rowW = r;
						colW = c;
						t[rowW][colW] = new Tile(false);
						continue;
					}
					
					if(tem=='*'||tem=='#'){
						t[r][c]=new Tile(true);
					}
					else
						t[r][c]=new Tile(false);
				}
			}
			//after reading
			if(dfs(rowS,colS))
				System.out.println("Yes");
			else
				System.out.println("No");
		}
		
	}
	
	public static boolean dfs(int startr, int startc){
		
		if(startr==rowW&&startc==colW)
				return true;
		
		
		
		if(startr+1<row&&!t[startr+1][startc].istrap){
			if(dfs(startr+1,startc))
				return true;
				
		}
		
		if(startc+1<col&&!t[startr][startc+1].istrap){
			if(dfs(startr,startc+1))
				return true;
				
		}
		return false;
	}
	
	static class Tile {

		boolean istrap;
		public Tile(boolean a){
			this.istrap = a;
		}

	}
	
}
