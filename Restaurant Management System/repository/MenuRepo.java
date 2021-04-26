package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class MenuRepo implements IMenuRepo
{
	DatabaseConnection dbc;
	
	public MenuRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Menu a)
	{
		String query = "INSERT INTO menu VALUES ('"+a.getSerial()+"','"+a.getName()+"',"+a.getPrice()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String mId)
	{
		String query = "DELETE from menu WHERE mId='"+mId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(Menu a)
	{
		String query = "UPDATE menu SET item='"+a.getName()+"', price = "+a.getPrice()+" WHERE mId='"+a.getSerial()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Menu searchMenu(String mId)
	{
		Menu a = null;
		String query = "SELECT `item`, `price` FROM `menu` WHERE `mId`='"+mId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("item");
				double price = dbc.result.getDouble("price");
				
				a = new Menu();
				a.setSerial(mId);
				a.setName(name);
				a.setPrice(price);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return a;
	}
	public String[][] getAllMenu()
	{
		ArrayList<Menu> ar = new ArrayList<Menu>();
		String query = "SELECT * FROM menu;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String mId = dbc.result.getString("Serial");
				String name = dbc.result.getString("item");
				double price = dbc.result.getDouble("price");
				
				 Menu a = new Menu(mId,name,price);
				ar.add(a);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Menu)obj[i]).getSerial();
			data[i][1] = ((Menu)obj[i]).getName();
			data[i][2] = (((Menu)obj[i]).getPrice())+"";
		}
		return data;
	}
}