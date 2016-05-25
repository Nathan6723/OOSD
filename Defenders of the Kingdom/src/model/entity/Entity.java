package model.entity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property="type")
public class Entity
{
	protected char icon;
	
	public char getIcon()
	{
		return icon;
	}
}
