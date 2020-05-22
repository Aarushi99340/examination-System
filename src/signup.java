import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class signup extends JFrame
implements ActionListener
{
	JLabel l1,l2,l3,l4,l5,l6;
	JTextArea a1,a2,a3,a4;
	JComboBox box,box1;
	JButton b1;
	public void sign()
	{
		super.setBounds(0, 0, 800, 800);
		super.setTitle("SIGNUP PAGE");
		super.setResizable(false);
		l1=new JLabel("NAME");
		l1.setBounds(30, 40, 100, 50);
		super.add(l1);
		a1=new JTextArea();
		a1.setBounds(130,40, 300, 50);
		super.add(a1);
		l2=new JLabel("EMAIL");
		l2.setBounds(30, 120, 100, 50);
		super.add(l2);
		a2=new JTextArea();
		a2.setBounds(130,120, 300, 50);
		super.add(a2);
		l3=new JLabel("MOBILE");
		l3.setBounds(30, 200, 100, 50);
		super.add(l3);
		a3=new JTextArea();
		a3.setBounds(130,200, 300, 50);
		super.add(a3);
		l4=new JLabel("QUALIFICATION");
		l4.setBounds(30, 280, 100, 50);
		super.add(l4);
		box=new JComboBox();
		box.setBounds(130, 280, 300, 50);
		super.add(box);
		box.addItem("btech");
		box.addItem("bca");
		box.addItem("mca");
		box.addItem("bsc");
		box.addItem("msc");
		l5=new JLabel("Year of passing");
		l5.setBounds(30, 380, 100, 50);
		super.add(l5);
		box1=new JComboBox();
		box1.setBounds(130, 380, 300, 50);
		super.add(box1);
		box1.addItem("2016");
		box1.addItem("2017");
		box1.addItem("2018");
		box1.addItem("2019");
		box1.addItem("2020");
		l6=new JLabel("PASSWORD");
		l6.setBounds(30, 450, 100, 50);
		super.add(l6);
		a4=new JTextArea();
		a4.setBounds(130, 450, 300, 50);
		super.add(a4);
		b1=new JButton("SUBMIT");
		b1.setBounds(250, 550, 100, 50);	
		super.add(b1);
		b1.addActionListener(this);
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) 
	{
		signup s=new signup();
		s.sign();
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==b1)
			{

				Class.forName("com.mysql.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project","root","admin");
				Statement sq=c.createStatement();
				String z1=a1.getText();
				datasharing.name=z1;
				String z2=a2.getText();
				String z3=a3.getText();
				String z4=a4.getText();
				String value = (String) box.getSelectedItem();
				String value1 = (String) box1.getSelectedItem();
				ResultSet rs=sq.executeQuery("select * from studenttable");
				while(rs.next())
				{
					String email=rs.getString("email");
					if(email.equals(z2))
					{
						JOptionPane.showMessageDialog(this,z1+" student is already registered");
					}
					else
					{
						if(z1.isEmpty())
						{
							JOptionPane.showMessageDialog(this, "name can't be empty");
						}
						if(z2.isEmpty())
							JOptionPane.showMessageDialog(this, "email can't be empty");
						if(z3.isEmpty())
							JOptionPane.showMessageDialog(this, " mobile can't be empty");
						if(z4.isEmpty())
							JOptionPane.showMessageDialog(this, "password can't be empty");
						if((!z1.isEmpty())&&(!z2.isEmpty())&&(!z3.isEmpty())&&(!z4.isEmpty()))
						{
							String query="insert into studenttable values('"+z1+"','"+z2+"','"+z3+"','"+value+"','"+value1+"','"+z4+"')";
							sq.executeUpdate(query);
							JOptionPane.showMessageDialog(this, "welcome student "+z1);
							smodule s=new smodule();
							super.dispose();
							s.mainpage();
						}
					}
				}
			}
		}
		catch(Exception ex)
		{
			
		}
	}
}
