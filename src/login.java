import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class login extends JFrame
implements ActionListener
{
	JLabel l1,l2,l,l3;
	JLabel as1,as2,as3,as4;
	JButton b1,b2,b,proceed;
	JTextArea a1,a2,a3;
	JComboBox box;
	
	JTextArea[] ll=new JTextArea[10];
	int i=0;
	String[] str = new String[10];
	 String[] str1 = new String[10];
	 String[] str2 = new String[10];
	
	public void lgn()
	{
		super.setBounds(0, 0, 800, 800);
		super.setTitle("LOGIN PAGE");
		super.setResizable(false);
		l1=new JLabel("EMAIL/MOBILE");
		l1.setBounds(30, 40, 100, 50);
		super.add(l1);
		a1=new JTextArea();
		a1.setBounds(130,40, 300, 50);
		super.add(a1);
		l2=new JLabel("PASSWORD");
		l2.setBounds(30, 120, 100, 50);
		super.add(l2);
		a2=new JTextArea();
		a2.setBounds(130,120, 300, 50);
		super.add(a2);
		b1=new JButton("LOGIN");
		b1.setBounds(200, 550, 200, 50);	
		super.add(b1);
		b1.addActionListener(this);
		b2=new JButton("RECOVER PASSWORD");
		b2.setBounds(150, 650, 400, 50);	
		super.add(b2);
		b2.addActionListener(this);
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) 
	{
		login s=new login();
		s.lgn();
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
				datasharing.email=z1;
				String z2=a2.getText();
				if(z1.contains("@"))
				{
					String v="select * from studenttable";
					ResultSet rr=sq.executeQuery(v);
					while(rr.next())
					{
						String ee=rr.getString("email");
						String name=rr.getString("name");
						String pass=rr.getString("password");
						if(z1.equals(ee)&&(z2.equals(pass)))
						{
							JOptionPane.showMessageDialog(this,"you've been successfully logged in");
							choose s=new choose();
							super.dispose();
							s.ch();
							
								
						}
					}	
				}
				if((!z1.contains("@")))
				{
					String v1="select * from studenttable ";
					ResultSet rr=sq.executeQuery(v1);
					while(rr.next())
					{
						String mb=rr.getString("mobile");
						String name=rr.getString("name");
						String pass=rr.getString("password");
						if(z1.equals(mb)&&(z2.equals(pass)))
						{
							JOptionPane.showMessageDialog(this,"you've been successfully logged in");
							choose s=new choose();
							super.dispose();
							s.ch();
							
						}
					}
				}
			}
			
			if(e.getSource()==b2)
			{
				recover r=new recover();
				super.dispose();
				r.rcvr();
				
				
			}
		}
			
			
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}


}

