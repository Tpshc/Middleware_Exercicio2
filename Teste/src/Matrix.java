import java.util.Scanner;

public class Matrix {
	
	/*
	 * 0 -> FOG
	 * 1 -> PODE ANDAR
	 * 2 -> PAREDE
	 */
	
	private char matriz[][];
	private Coordinate me;
	private Coordinate target;
	//private AppProxy proxy = new AppProxy();
	
	public Matrix(){ // CONSTRUTOR
		matriz = new char[12][12];		
		cleanMatrix();		
		me = new Coordinate();
		target = new Coordinate(11,11);
	}
	
	
	public void cleanMatrix(){		
		for(int i =0;i<12;i++)
			for(int j =0;j<12;j++)
				matriz[i][j]='0';
					
		matriz[1][1] = '1';		
	}
	
	
	public void down(AppProxy proxy) throws Throwable{
		
		int x = me.getX();
		int y = me.getY()+1;
		
		if(matriz[x][y]=='0'){
			
			char receive = proxy.canIMove(new Coordinate(x,y));			
			if(receive!=2){
				
				matriz[x][y] = '1';
				me.goUp();
				
				if(receive==0){
					target= new Coordinate(x,y);
				}
				
			}
			else{
				matriz[x][y] = '2';
			}
		}
		else if(matriz[x][y] == '1'){
			me.goUp();			
		}
		
	}
	
	public void up(AppProxy proxy) throws Throwable{

		int x = me.getX();
		int y = me.getY()-1;
		
		if(matriz[x][y]=='0'){
			
			char receive = proxy.canIMove(new Coordinate(x,y));			
			if(receive!='2'){
				
				matriz[x][y] = '1';
				me.goDown();
				
				if(receive=='0'){
					target= new Coordinate(x,y);
				}
				
			}
			else{
				matriz[x][y] = '2';
			}
		}
		else if(matriz[x][y] == '1'){
			me.goDown();			
		}
	}
	
	public void left(AppProxy proxy) throws Throwable{

		int x = me.getX()-1;
		int y = me.getY();
		
		if(matriz[x][y]=='0'){
			
			char receive = proxy.canIMove(new Coordinate(x,y));				
			if(receive!='2'){
				
				matriz[x][y] = '1';
				me.goLeft();
				
				if(receive=='0'){
					target= new Coordinate(x,y);
				}
				
			}
			else{
				matriz[x][y] = '2';
			}
		}
		else if(matriz[x][y] == '1'){
			me.goLeft();			
		}
	}
	
	public void right(AppProxy proxy) throws Throwable{


		int x = me.getX()+1;
		int y = me.getY();
		
		if(matriz[x][y]=='0'){
			
			char receive = proxy.canIMove(new Coordinate(x,y));				
			if(receive!='2'){
				
				matriz[x][y] = '1';
				me.goRight();
				
				if(receive=='0'){
					target= new Coordinate(x,y);
				}
				
			}
			else{
				matriz[x][y] = '2';
			}
		}
		else if(matriz[x][y] == '1'){
			me.goRight();			
		}
	}

	 public void print(){
		  
		  for(int j =0;j<12;j++){
		   for(int i =0;i<12;i++){
		    if(!me.equals(i,j)){
		     if(matriz[i][j]=='0') System.out.print("-");
		     if(matriz[i][j]=='1') System.out.print("+");
		     if(matriz[i][j]=='2') System.out.print("X");
		    }
		    else{
		     System.out.print("O");
		    }
		   }
		   System.out.println();
		  }  
		 }
	
	public static void main(String[] args) throws Throwable {
		Matrix matr = new Matrix();
		Scanner in = new Scanner(System.in);
		System.out.println("começou cliente");
		AppProxy proxy = new AppProxy();
		proxy.setHost("localhost");
		proxy.setPort(60004);
		while(!matr.me.equals(matr.target))
		{
			String c = in.next();
			if(c.equals("w"))
				matr.up(proxy);
			else if(c.equals("a"))
				matr.left(proxy);
			else if(c.equals("s"))
				matr.down(proxy);
			else if(c.equals("d"))
				matr.right(proxy);
			
			matr.print();
			
		}
		System.out.println("terminou cliente");
	}
}
