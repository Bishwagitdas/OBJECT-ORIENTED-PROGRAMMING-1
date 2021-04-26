package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class StaffRepo implements IStaffRepo
{
	DatabaseConnection dbc;
	
	public StaffRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Staff s)
	{
		String query = "INSERT INTO staff VALUES ('"+s.getStfId()+"','"+s.getName()+"','"+s.getDesignation()+"',"+s.getSalary()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String stfId)
	{
		String query = "DELETE from staff WHERE stfId='"+stfId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(Staff s)
	{
		String query = "UPDATE staff SET staffName='"+s.getName()+"', designation = '"+s.getDesignation()+"', salary = "+s.getSalary()+" WHERE stfId='"+s.getStfId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Staff searchStaff(String stfId)
	{
		Staff stf = null;
		String query = "SELECT `staffName`, `designation`, `salary` FROM `staff` WHERE `stfId`='"+stfId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("staffName");
				String designation = dbc.result.getString("designation");
				double salary = dbc.result.getDouble("salary");
				
				stf = new Staff();
				stf.setStfId(stfId);
				stf.setName(name);
				stf.setDesignation(designation);
				stf.setSalary(salary);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return stf;
	}
	public String[][] getAllStaff()
	{
		ArrayList<Staff> ar = new ArrayList<Staff>();
		String query = "SELECT * FROM staff;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String stfId = dbc.result.getString("stfId");
				String name = dbc.result.getString("staffName");
				String designation = dbc.result.getString("designation");
				double salary = dbc.result.getDouble("salary");
				
				Staff s = new Staff(stfId,name,designation,salary);
				ar.add(s);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][4];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Staff)obj[i]).getStfId();
			data[i][1] = ((Staff)obj[i]).getName();
			data[i][2] = ((Staff)obj[i]).getDesignation();
			data[i][3] = (((Staff)obj[i]).getSalary())+"";
		}
		return data;
	}
}