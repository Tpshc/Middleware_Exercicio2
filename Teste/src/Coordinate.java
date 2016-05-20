import java.io.Serializable;

public class Coordinate implements Serializable{
	private int x;
	private int y;
	
	public Coordinate(){
		setX(1);
		setY(1);
	}

	public Coordinate(int x, int y){
		setX(x);
		setY(y);
	}
	public Coordinate(Coordinate c){
		setX(c.getX());
		setY(c.getY());
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void goUp(){
		setY(y+1);
	}
	
	public void goDown(){
		setY(y-1);
	}
	
	public void goLeft(){
		setX(x-1);
	}
	
	public void goRight(){
		setX(x+1);
	}
	
	public boolean equals(Coordinate c){
		return (x==c.getX() && y==c.getY());
	}
	
	public boolean equals(int nX,int nY){
		  return (x==nX && y==nY);
		 }
	
}
