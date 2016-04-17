package model;

public class Moveunit {
	private static Moveunit instance = null;
	
	public static Moveunit getInstance()
	{
		if (instance == null){
			 
			return new Moveunit();
			}
		return instance;
	}
	
	
	
	public boolean Move(Cell initialpos, Cell finalpos){
	
		
		try{
			
			finalpos.setEntity(initialpos.getEntity());
			initialpos.setEntity(null);
			return true;
			
		}
		catch(Exception ex){
		return false;
		}
	}

}
