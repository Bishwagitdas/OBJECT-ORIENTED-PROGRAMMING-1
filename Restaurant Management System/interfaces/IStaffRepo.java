package interfaces;

import java.lang.*;

import entity.*;

public interface IStaffRepo
{
	public void insertInDB(Staff s);
	public void deleteFromDB(String stfId);
	public void updateInDB(Staff s);
	public Staff searchStaff(String stfId);
	public String[][] getAllStaff();
}