package entity;

import java.lang.*;

public class Menu
{
	private String mId;
	private String name;
	//private String price;
	private double price;
	
	public Menu(){}
	public Menu(String mId, String name, /*String price*/ double price)
	{
		this.mId = mId;
		this.name = name;
		//this.price = price;
		this.price = price;
	}
	
	public void setSerial(String mId){this.mId = mId;}
	public void setName(String name){this.name = name;}
	//public void setPrice(String designation){this.designation = designation;}
	public void setPrice(double price){this.price = price;}
	
	public String getSerial(){return mId;}
	public String getName(){return name;}
	//public String getPrice(){return Price;}
	public double getPrice(){return price;}
}