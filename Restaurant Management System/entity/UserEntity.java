package entity;

import java.lang.*;

public class UserEntity
{
	private String userId;
	private String password;
	private int status;
	
	public UserEntity(){}
	public UserEntity(String userId, String password, int status)
	{
		this.userId = userId;
		this.password = password;
		this.status = status;
	}
	
	public void setUserId(String userId){this.userId = userId;}
	public void setPassword(String password){this.password = password;}
	public void setStatus(int status){this.status = status;}
	
	public String getUserId(){return userId;}
	public String getPassword(){return password;}
	public int getStatus(){return status;}
}