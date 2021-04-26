package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class MenuFrame extends JFrame implements ActionListener
{
	private JLabel mLabel, mIdLabel, mNameLabel, mPriceLabel;
	private JTextField mIdTF, mNameTF, mPriceTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable mTable;
	private JScrollPane mTableSP;
	
	private UserEntity user;
	private MenuRepo mr;
	private UserRepo ur;
	
	
	public MenuFrame(UserEntity user)
	{
		super("Menu Page");
		this.setSize(800,450);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		mr = new MenuRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", ""}};
		
		String head[] = {"Serial", "Item", "price"};
		
		mTable = new JTable(data,head);
		mTableSP = new JScrollPane(mTable);
		mTableSP.setBounds(350, 100, 400, 150);
		mTable.setEnabled(false);
		panel.add(mTableSP);
		
		mLabel = new JLabel("Menu List");
		mLabel.setBounds(350,50,100,30);
		panel.add(mLabel);
		
		mIdLabel = new JLabel("Serial :");
		mIdLabel.setBounds(100,100,100,30);
		panel.add(mIdLabel);
		
		mIdTF = new JTextField();
		mIdTF.setBounds(220,100,100,30);
		panel.add(mIdTF);
		
		mNameLabel = new JLabel("Item :");
		mNameLabel.setBounds(100,150,100,30);
		panel.add(mNameLabel);
		
		mNameTF = new JTextField();
		mNameTF.setBounds(220,150,100,30);
		panel.add(mNameTF);
		
		mPriceLabel = new JLabel("Price :");
		mPriceLabel.setBounds(100,200,100,30);
		panel.add(mPriceLabel);
		
		mPriceTF = new JTextField();
		mPriceTF.setBounds(220,200,100,30);
		panel.add(mPriceTF);
		
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
			if(!mIdTF.getText().equals("") || !mIdTF.getText().equals(null))
			{
				Menu a = mr.searchMenu(mIdTF.getText());
				if(a!= null)
				{
					mIdTF.setText(a.getSerial());
					mNameTF.setText(a.getName());
					mPriceTF.setText(a.getPrice()+"");
					
					mIdTF.setEnabled(false);
					mNameTF.setEnabled(true);
					mPriceTF.setEnabled(true);
					
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
			Menu a = new Menu();
			UserEntity u = new UserEntity();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			a.setSerial(mIdTF.getText());
			a.setName(mNameTF.getText());
			//a.setPrice(mPriceTF.getText());
			a.setPrice(Double.parseDouble(mPriceTF.getText()));
			
			u.setUserId(mIdTF.getText());
			u.setPassword(x+"");
			
			
			mr.insertInDB(a);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+mIdTF.getText()+"and Password: "+x);
			
			mIdTF.setText("");
			mNameTF.setText("");
			mPriceTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			mIdTF.setText("");
			mNameTF.setText("");
			mPriceTF.setText("");
			
			mIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Menu a = new Menu();
			
			a.setSerial(mIdTF.getText());
			a.setName(mNameTF.getText());
			//m.setPrice(mPriceTF.getText());
			a.setPrice(Double.parseDouble(mPriceTF.getText()));
			
			mr.updateInDB(a);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			mIdTF.setText("");
			mNameTF.setText("");
			mPriceTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			mIdTF.setEnabled(true);
			mNameTF.setEnabled(true);
			mPriceTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			mr.deleteFromDB(mIdTF.getText());
			ur.deleteUser(mIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			mIdTF.setText("");
			mNameTF.setText("");
			mPriceTF.setText("");
			
			mIdTF.setEnabled(true);
			mNameTF.setEnabled(true);
			mPriceTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = mr.getAllMenu();
			String head[] = {"Id", "Name", "Designation", "Salary"};
			
			panel.remove(mTableSP);
			
			mTable = new JTable(data,head);
			mTable.setEnabled(false);
			mTableSP = new JScrollPane(mTable);
			mTableSP.setBounds(350, 100, 400, 150);
			panel.add(mTableSP);
			
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