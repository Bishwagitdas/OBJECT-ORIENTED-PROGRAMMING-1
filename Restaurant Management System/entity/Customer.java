package entity;

import java.lang.*;

public class Customer
{
	private String cId;
	private String name;
	private String menu;
	private double price;
	
	public Customer(){}
	public Customer(String cId, String name, String menu, double price)
	{
		this.cId = cId;
		this.name = name;
		this.menu = menu;
		this.price = price;
	}
	
	public void setCId(String cId){this.cId = cId;}
	public void setName(String name){this.name = name;}
	public void setMenu(String menu){this.menu = menu;}
	public void setPrice(double price){this.price = price;}
	
	public String getCId(){return cId;}
	public String getName(){return name;}
	public String getMenu(){return menu;}
	public double getPrice(){return price;}
}