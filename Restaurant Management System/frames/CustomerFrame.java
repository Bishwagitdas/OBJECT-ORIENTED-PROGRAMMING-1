package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class CustomerFrame extends JFrame implements ActionListener
{
	private JLabel cLabel, cIdLabel, cNameLabel, cMenuLabel, cPriceLabel;
	private JTextField cIdTF, cNameTF, cMenuTF, cPriceTF;
	private JButton loadBtn, insertBtn, updateBtn, deleteBtn, refreshBtn, getAllBtn, backBtn;
	private JPanel panel;
	private JTable cTable;
	private JScrollPane cTableSP;
	
	private UserEntity user;
	private CustomerRepo cr;
	private UserRepo ur;
	
	
	public CustomerFrame(UserEntity user)
	{
		super("Customer Page");
		this.setSize(800,450);
		//this.setBackground(Color.RED);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.user = user;
		
		cr = new CustomerRepo();
		ur = new UserRepo();
		
		panel = new JPanel();
		panel.setLayout(null);
		
		
		
		String data[][] = {{"", "", "", ""}};
		
		String head[] = {"Id", "Name", "Item", "Price"};
		
		cTable = new JTable(data,head);
		cTableSP = new JScrollPane(cTable);
		cTableSP.setBounds(350, 100, 400, 150);
		cTable.setEnabled(false);
		panel.add(cTableSP);
		
		cLabel = new JLabel("Customer Informations");
		cLabel.setBounds(350,50,100,30);
		panel.add(cLabel);
		
		cIdLabel = new JLabel("ID :");
		cIdLabel.setBounds(100,100,100,30);
		panel.add(cIdLabel);
		
		cIdTF = new JTextField();
		cIdTF.setBounds(220,100,100,30);
		panel.add(cIdTF);
		
		cNameLabel = new JLabel("Name :");
		cNameLabel.setBounds(100,150,100,30);
		panel.add(cNameLabel);
		
		cNameTF = new JTextField();
		cNameTF.setBounds(220,150,100,30);
		panel.add(cNameTF);
		
		cMenuLabel = new JLabel("Item : ");
		cMenuLabel.setBounds(100,200,100,30);
		panel.add(cMenuLabel);
		
		cMenuTF = new JTextField();
		cMenuTF.setBounds(220,200,100,30);
		panel.add(cMenuTF);
		
		cPriceLabel = new JLabel("Price : ");
		cPriceLabel.setBounds(100,250,100,30);
		panel.add(cPriceLabel);
		
		cPriceTF = new JTextField();
		cPriceTF.setBounds(220,250,100,30);
		panel.add(cPriceTF);
		
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
			if(!cIdTF.getText().equals("") || !cIdTF.getText().equals(null))
			{
				Customer c = cr.searchCustomer(cIdTF.getText());
				if(c!= null)
				{
					cNameTF.setText(c.getName());
					cMenuTF.setText(c.getMenu());
					cPriceTF.setText(c.getPrice()+"");
					
					cIdTF.setEnabled(false);
					cNameTF.setEnabled(true);
					cMenuTF.setEnabled(true);
					cPriceTF.setEnabled(true);
					
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
			Customer c = new Customer();
			UserEntity u = new UserEntity();
			Random rd = new Random();
			int x = rd.nextInt(9999999)+10000000;
			
			c.setCId(cIdTF.getText());
			c.setName(cNameTF.getText());
			c.setMenu(cMenuTF.getText());
			c.setPrice(Double.parseDouble(cPriceTF.getText()));
			
			u.setUserId(cIdTF.getText());
			u.setPassword(x+"");
			
			
			cr.insertInDB(c);
			ur.insertUser(u);
			
			JOptionPane.showMessageDialog(this, "Inserted, Id: "+cIdTF.getText()+"and Password: "+x);
			
			cIdTF.setText("");
			cNameTF.setText("");
			cMenuTF.setText("");
			cPriceTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
		}
		else if(command.equals(refreshBtn.getText()))
		{
			cIdTF.setText("");
			cNameTF.setText("");
			cMenuTF.setText("");
			cPriceTF.setText("");
			
			cIdTF.setEnabled(true);
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(updateBtn.getText()))
		{
			Customer c = new Customer();
			
			c.setCId(cIdTF.getText());
			c.setName(cNameTF.getText());
			c.setMenu(cMenuTF.getText());
			c.setPrice(Double.parseDouble(cPriceTF.getText()));
			
			cr.updateInDB(c);
			
			JOptionPane.showMessageDialog(this, "Updated");
			
			cIdTF.setText("");
			cNameTF.setText("");
			cMenuTF.setText("");
			cPriceTF.setText("");
			
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
			
			cIdTF.setEnabled(true);
			cNameTF.setEnabled(true);
			cMenuTF.setEnabled(true);
			cPriceTF.setEnabled(true);
		}
		else if(command.equals(deleteBtn.getText()))
		{
			cr.deleteFromDB(cIdTF.getText());
			ur.deleteUser(cIdTF.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			cIdTF.setText("");
			cNameTF.setText("");
			cMenuTF.setText("");
			cPriceTF.setText("");
			
			cIdTF.setEnabled(true);
			cNameTF.setEnabled(true);
			cMenuTF.setEnabled(true);
			cPriceTF.setEnabled(true);
	
			loadBtn.setEnabled(true);
			insertBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			refreshBtn.setEnabled(false);
		}
		else if(command.equals(getAllBtn.getText()))
		{
			String data[][] = cr.getAllCustomer();
			String head[] = {"Id", "Name", "Item", "Price"};
			
			panel.remove(cTableSP);
			
			cTable = new JTable(data,head);
			cTable.setEnabled(false);
			cTableSP = new JScrollPane(cTable);
			cTableSP.setBounds(350, 100, 400, 150);
			panel.add(cTableSP);
			
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