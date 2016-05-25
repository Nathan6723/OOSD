package model.item;

// Unimplemented
public class Item
{
	private String name;
	private Effect[] effects;
	private String image;
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public Effect[] getEffects()
	{
		return effects;
	}
	
	public void setEffects(Effect[] effects)
	{
		this.effects = effects;
	}
	
	public String getImage()
	{
		return image;
	}
	
	public void setImage(String image)
	{
		this.image = image;
	}
}