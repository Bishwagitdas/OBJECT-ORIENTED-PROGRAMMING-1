package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class StaffFrame extends JFrame implements ActionListener
{
	private JLabel stfLabel, stfIdLabel, stfNameLabel, stfDesignationLabel, stfSalaryLabel;
	private JTextField stfIdTF, stfNameTF, stfDesignationTF, stfSalaryTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable stfTable;
	private JScrollPane stfTableSP;
	
	private UserEntity user;
	private StaffRepo sr;
	private UserRepo ur;
	
	
	public StaffFrame(UserEntity user)
	{
		super("Staff Page");
		this.setSize(800,450);
		//this.setBackground(Color.RED);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		sr = new StaffRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"Id", "Name", "Designation", "Salary"};
		
		stfTable = new JTable(data,head);
		stfTableSP = new JScrollPane(stfTable);
		stfTableSP.setBounds(350, 100, 400, 150);
		stfTable.setEnabled(false);
		panel.add(stfTableSP);
		
		stfLabel = new JLabel("Staff Details");
		stfLabel.setBounds(350,50,100,30);
		panel.add(stfLabel);
		
		stfIdLabel = new JLabel("ID :");
		stfIdLabel.setBounds(100,100,100,30);
		panel.add(stfIdLabel);
		
		stfIdTF = new JTextField();
		stfIdTF.setBounds(220,100,100,30);
		panel.add(stfIdTF);
		
		stfNameLabel = new JLabel("Name :");
		stfNameLabel.setBounds(100,150,100,30);
		panel.add(stfNameLabel);
		
		stfNameTF = new JTextField();
		stfNameTF.setBounds(220,150,100,30);
		panel.add(stfNameTF);
		
		stfDesignationLabel = new JLabel("Designation: ");
		stfDesignationLabel.setBounds(100,200,100,30);
		panel.add(stfDesignationLabel);
		
		stfDesignationTF = new JTextField();
		stfDesignationTF.setBounds(220,200,100,30);
		panel.add(stfDesignationTF);
		
		stfSalaryLabel = new JLabel("Salary: ");
		stfSalaryLabel.setBounds(100,250,100,30);
		panel.add(stfSalaryLabel);
		
		stfSalaryTF = new JTextField();
		stfSalaryTF.setBounds(220,250,100,30);
		panel.add(stfSalaryTF);
		
		loadBtn = new JButton("Load");
		loadBtn.setBounds(100,300,80,30);
		loadBtn.addActionListener(this);
		panel.add(loadBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.setBounds(200,300,80,30);
		insertBtn.addActionListener(this);
		panel.add(insertBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(300,300,80,30);
		updateBtn.addActionListener(this);
		updateBtn.setEnabled(false);
		panel.add(updateBtn);
		
		deleteBtn = new JButton("Delete");
		deleteBtn.setBounds(400,300,80,30);
		deleteBtn.addActionListener(this);
		deleteBtn.setEnabled(false);
		panel.add(deleteBtn);
		
		refreshBtn = new JButton("Refresh");
		refreshBtn.setBounds(500,300,80,30);
		refreshBtn.addActionListener(this);
		refreshBtn.setEnabled(false);
		panel.add(refreshBtn);
		
		getAllBtn = new JButton("Get All");
		getAllBtn.setBounds(500,260,80,30);
		getAllBtn.addActionListener(this);
		panel.add(getAllBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(600, 350, 80, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		this.add(panel);
	}
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(loadBtn.getText()))
		{
			if(!stfIdTF.getText().equals("") || !stfIdTF.getText().equals(null))
			{
				Staff s = sr.searchStaff(stfIdTF.getText());
				if(s!= null)
				{
					stfNameTF.setText(s.getName());
					stfDesignationTF.setText(s.getDesignation());
					stfSalaryTF.setText(s.getSalary()+"");
					
					stfIdTF.setEnabled(false);
					stfNameTF.setEnabled(true);
					stfDesignationTF.setEnabled(true);
					stfSalaryTF.setEnabled(true);
					
					updateBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					refreshBtn.setEnabled(true);
					insertBtn.setEnabled(false);
					loadBtn.setEnabled(false);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if(command.equals(insertBtn.getText()))
		{
			Staff s = new Staff();
			UserEntity u = new UserEntity();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			s.setStfId(stfIdTF.getText());
			s.setName(stfNameTF.getText());
			s.setDesignation(stfDesignationTF.getText());
			s.setSalary(Double.parseDouble(stfSalaryTF.getText()));
			
			u.setUserId(stfIdTF.getText());
			u.setPassword(x+"");
			
			if(((stfDesignationTF.getText()).equals("Manager")) || ((stfDesignationTF.getText()).equals("manager")))
			{
				u.setStatus(0);
			}
			else
			{
				u.setStatus(1);
			}
			
			sr.insertInDB(s);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+stfIdTF.getText()+"and Password: "+x);
			
			stfIdTF.setText("");
			stfNameTF.setText("");
			stfDesignationTF.setText("");
			stfSalaryTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			stfIdTF.setText("");
			stfNameTF.setText("");
			stfDesignationTF.setText("");
			stfSalaryTF.setText("");
			
			stfIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Staff s = new Staff();
			
			s.setStfId(stfIdTF.getText());
			s.setName(stfNameTF.getText());
			s.setDesignation(stfDesignationTF.getText());
			s.setSalary(Double.parseDouble(stfSalaryTF.getText()));
			
			sr.updateInDB(s);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			stfIdTF.setText("");
			stfNameTF.setText("");
			stfDesignationTF.setText("");
			stfSalaryTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			stfIdTF.setEnabled(true);
			stfNameTF.setEnabled(true);
			stfDesignationTF.setEnabled(true);
			stfSalaryTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			sr.deleteFromDB(stfIdTF.getText());
			ur.deleteUser(stfIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			stfIdTF.setText("");
			stfNameTF.setText("");
			stfDesignationTF.setText("");
			stfSalaryTF.setText("");
			
			stfIdTF.setEnabled(true);
			stfNameTF.setEnabled(true);
			stfDesignationTF.setEnabled(true);
			stfSalaryTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = sr.getAllStaff();
			String head[] = {"Id", "Name", "Designation", "Salary"};
			
			panel.remove(stfTableSP);
			
			stfTable = new JTable(data,head);
			stfTable.setEnabled(false);
			stfTableSP = new JScrollPane(stfTable);
			stfTableSP.setBounds(350, 100, 400, 150);
			panel.add(stfTableSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		else if(command.equals(backBtn.getText()))
		{
			StaffHomePage sh = new StaffHomePage(user);
			sh.setVisible(true);
			this.setVisible(false);
		}
		else{}
		
	}
}