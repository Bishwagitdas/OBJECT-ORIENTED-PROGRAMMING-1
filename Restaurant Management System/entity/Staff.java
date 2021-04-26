package entity;

import java.lang.*;

public class Staff
{
	private String stfId;
	private String name;
	private String designation;
	private double salary;
	
	public Staff(){}
	public Staff(String stfId, String name, String designation, double salary)
	{
		this.stfId = stfId;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	
	public void setStfId(String stfId){this.stfId = stfId;}
	public void setName(String name){this.name = name;}
	public void setDesignation(String designation){this.designation = designation;}
	public void setSalary(double salary){this.salary = salary;}
	
	public String getStfId(){return stfId;}
	public String getName(){return name;}
	public String getDesignation(){return designation;}
	public double getSalary(){return salary;}
}