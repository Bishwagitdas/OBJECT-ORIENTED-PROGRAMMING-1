package repository;

import java.lang.*;

import entity.*;
import interfaces.*;

public class UserRepo implements IUserEntityRepo
{
	DatabaseConnection dbc;
	
	public UserRepo()
	{
		dbc = new DatabaseConnection();
	}
	public UserEntity getUser(String userId, String pass)
	{
		UserEntity user = null;
		String query = "SELECT userId, password, status FROM login WHERE userId='"+userId+"' AND password='"+pass+"';";
		try
		{
			System.out.println(query);
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				user = new UserEntity();
				user.setUserId(dbc.result.getString("userId"));
				user.setPassword(dbc.result.getString("password"));
				user.setStatus(dbc.result.getInt("status"));
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		dbc.closeConnection();
		return user;
	}
	public void insertUser(UserEntity u)
	{
		String query = "INSERT INTO login VALUES ('"+u.getUserId()+"','"+u.getPassword()+"',"+u.getStatus()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void updateUser(UserEntity u){}
	public void deleteUser(String userId)
	{
		String query = "DELETE from login  WHERE userId='"+userId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
}