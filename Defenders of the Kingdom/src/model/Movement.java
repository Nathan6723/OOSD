package model;

public class Movement {
	//private Boardsize  size;
	
	private static Movement instance = null;
	
	public Movement(){
		
	}
	
	public static Movement getInstance()
	{
		if (instance == null)
			return new Movement();
		return instance;
	}
	
	
	
	/*public Boardsize getBoardsize() {
		return size;
	}


	public void setBoardsize(Boardsize boardsize) {
		this.size =boardsize;
	}
*/

	public boolean samePosition(int a,int b){
		if(a==b)
		return true;
		else
			return false;
	}
	
	public boolean positiveVertical(int x1,int y1,int x2,int y2,int movementradius,Boardsize size){
	//	if(!samePosition(x1,x2)){
		if(y1==y2&&x2>x1){
			int end=x1+movementradius;
			for(int x=x1;x<=end;x++){
				if(size.checkBounds(x, 0)){
				if(x==x2)
					return true;
			}
			}
		}
		//}
		return false;
	}
	
public boolean negativeVertical(int x1,int y1,int x2,int y2,int movementradius,Boardsize size){
	//if(!samePosition(x1,x2)){
		if(y1==y2&&x1>x2){
			int end=x1-movementradius;
			for(int x=x1;x>=end;x--){
				if(size.checkBounds(x, 0)){
				if(x==x2)
					return true;
			}
			}
		}
		//}
		return false;
	}
	
	
	public boolean positivehorizontal(int x1,int y1,int x2,int y2,int movementradius,Boardsize size){
		
		//if(!samePosition(y1,y2)){
		if(x1==x2&&y2>y1){
			int end=y1+movementradius;
			for(int y=y1;y<=end;y++){
				if(size.checkBounds(0,y)){
				if(y==y2)
					return true;
			}
			}
		}
	//	}
		return false;
		
	}
	
	
public boolean negativehorizontal(int x1,int y1,int x2,int y2,int movementradius,Boardsize size){
	
	
	//if(!samePosition(y1,y2)){
		if(x1==x2&&y1>y2){
			int end=y1-movementradius;
			for(int y=y1;y>=end;y--){
				if(size.checkBounds(0,y)){
				if(y==y2)
					return true;
			}
			}
		}
		//}
		return false;	
		
	}

public boolean diagonal1(int x1,int y1,int x2,int y2,int movementradius,Boardsize size){
	boolean p=false;
	int i=0;
	int j=0;
	int xend=0;
	int yend=0;
	
	//if(!samePosition(x1,x2) ||!samePosition(y1,y2))
	//return false;
		// x+ y+
	xend=x1+movementradius;
	for(int x=x1;x<=xend;x++){
		i++;
		if(size.checkBounds(x,0)){
		if(x==x2)
			break;		
		}
	}
	
	yend=y1+movementradius;
	for(int y=y1;y<=yend;y++){
		j++;
		if(size.checkBounds(0,y)){
		if(y==y2)
			break;	
		}
	}
	
	if(i==j)
	return true;
	
	//x-y-
	xend=x1-movementradius;
	yend=y1-movementradius;
	i=0;
	for(int x=x1;x>=xend;x--){
		i++;
	if(size.checkBounds(x,0)){
		if(x==x2)
      break;
	}
	}
	
	 j=0;
	for(int y=y1;y>=yend;y--){
		j++;
	if(size.checkBounds(0,y)){
		if(y==y2)
      break;
	}
	}
	
	if(i==j)
		return true;
	
	return false;
}

public boolean diagonal2(int x1,int y1,int x2,int y2,int movementradius,Boardsize size){
	boolean p=false;
	int i=0;
	int j=0;
	int xend=0;
	int yend=0;
	
//	if(!samePosition(x1,x2) ||!samePosition(y1,y2))
	//return false;
		// x- y+
	xend=x1-movementradius;
	for(int x=x1;x>=xend;x--){
		i++;
		if(size.checkBounds(x,0)){
		if(x==x2)
			break;		
		}
	}
	
	yend=y1+movementradius;
	for(int y=y1;y<=yend;y++){
		j++;
		if(size.checkBounds(0,y)){
		if(y==y2)
			break;	
		}
	}
	
	if(i==j)
	return true;
	
	//x+y-
	xend=x1+movementradius;
	yend=y1-movementradius;
	i=0;
	for(int x=x1;x<=xend;x++){
		i++;
	if(size.checkBounds(x,0)){
		if(x==x2)
      break;
	}
	}
	
	 j=0;
	for(int y=y1;y>=yend;y--){
		j++;
	if(size.checkBounds(0,y)){
		if(y==y2)
      break;
	}
	}
	
	if(i==j)
		return true;
	
	return false;
}




	
}
