package interfaces;

import java.lang.*;

import entity.*;

public interface IMenuRepo
{
	public void insertInDB(Menu m);
	public void deleteFromDB(String mId);
	public void updateInDB(Menu m);
	public Menu searchMenu(String mId);
	public String[][] getAllMenu();
}