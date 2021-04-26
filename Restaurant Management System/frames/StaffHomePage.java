package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class StaffHomePage extends JFrame implements ActionListener
{
	JButton logoutBtn, managestfBtn, manageProductBtn, manageCustomerBtn, changePasswordBtn;
	JPanel panel;
	
	UserEntity user;
	
	public StaffHomePage(UserEntity user)
	{
		super("Home Page Window");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 150, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(600, 100, 150, 30);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		managestfBtn = new JButton("Manage Staff");
		managestfBtn.setBounds(50, 100, 150, 30);
		managestfBtn.addActionListener(this);
		panel.add(managestfBtn);
		
		manageProductBtn = new JButton("Manage Menu");
		manageProductBtn.setBounds(225, 100, 150, 30);
		manageProductBtn.addActionListener(this);
		panel.add(manageProductBtn);
		
		manageCustomerBtn = new JButton("Customer Details");
		manageCustomerBtn.setBounds(400,100,150,30);
		manageCustomerBtn.addActionListener(this);
		panel.add(manageCustomerBtn);
		
		this.add(panel);
	
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(logoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else if(command.equals(managestfBtn.getText()))
		{
			if(user.getStatus()==0)
			{
				StaffFrame sf = new StaffFrame(user);
				sf.setVisible(true);
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Access Denied");
			}
		}
		else if(command.equals(manageProductBtn.getText()))
		{
			    MenuFrame mf = new MenuFrame(user);
				mf.setVisible(true);
				this.setVisible(false);
		}
		else if(command.equals(manageCustomerBtn.getText()))
		{
			    CustomerFrame cf = new CustomerFrame(user);
				cf.setVisible(true);
				this.setVisible(false);
		}
		else{}
	}
}