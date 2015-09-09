package red_and_black;

import java.io.BufferedInputStream;


import java.util.Scanner;

enum Color {
	red, black
};

public class Main {
	static int count=0;
	static Tile[][] t;
	static int rownum;
	static int colnum;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(new BufferedInputStream(System.in));
		int personrow=0;
		int personcol=0;
		while (true) {
			colnum = s.nextInt();
			rownum = s.nextInt();
			
			if (rownum == 0 && colnum == 0)
				break;
			t= new Tile[rownum][colnum];
			count=0;
			s.nextLine();
			//initialize
			for(int a=0;a<rownum;a++){
				
				StringBuffer sb = new StringBuffer(s.nextLine());
				
				for(int b=0;b<colnum;b++){
					
					t[a][b]= new Tile(a, b, ((sb.charAt(b)=='.'||sb.charAt(b)=='@')?Color.black:Color.red));
					if(sb.charAt(b)=='@'){
						personrow = a;
						personcol = b;
						
					}
				}
				
			}
			
			dfs(personrow,personcol);
			System.out.println(count);
				
			}
		}

	
	
	static void dfs(int startr,int startc){
		t[startr][startc].visited = true;
		count++;
		if(startc>0&&t[startr][startc-1].color==Color.black&&!t[startr][startc-1].visited){
		
			dfs(startr,startc-1);
		}
		
		if(startc<colnum-1&&t[startr][startc+1].color==Color.black&&!t[startr][startc+1].visited){
		
			dfs(startr,startc+1);
		}
		
		if(startr<rownum-1&&t[startr+1][startc].color==Color.black&&!t[startr+1][startc].visited){
		
			dfs(startr+1,startc);
		}
		
		if(startr>0&&t[startr-1][startc].color==Color.black&&!t[startr-1][startc].visited){
	
			dfs(startr-1,startc);
			
			
		}
	}
	
	static class Tile {
		private int row;
		private int column;
		Color color;
		boolean visited=false;
		public Tile(int row, int column, Color color) {
			this.row = row;
			this.column = column;
			this.color = color;

		}

	}

}
