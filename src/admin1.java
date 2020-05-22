import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class admin1 extends JFrame
implements ActionListener
{
	JButton b1,b2;
	JLabel l1;
	JTextField t1;
	public void login()
	{
		super.setBounds(0, 0, 900, 900);
		super.setTitle("MAIN PAGE");
		super.setResizable(false);
		l1=new JLabel("Secret Number");
		l1.setBounds(30, 60, 200, 60);
		super.add(l1);
		t1=new JTextField();
		t1.setBounds(200, 60, 400, 100);
		super.add(t1);
		b1=new JButton("Admin login");
		b1.setBounds(150, 400, 500, 100);
		super.add(b1);
		b1.addActionListener(this);
		b2=new JButton("Resend code");
		b2.setBounds(150, 700, 500, 100);
		super.add(b2);
		b2.addActionListener(this);
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) 
	{
		admin1 a1=new admin1();
		a1.login();
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
		if(e.getSource()==b1)
		{
			String t=t1.getText();
			if(!t.isEmpty())
			{
				long  h=Long.parseLong(t);
				Class.forName("com.mysql.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project","root","admin");
				Statement sq=c.createStatement();
				
				ResultSet o=sq.executeQuery("select * from admintable");
				while(o.next())
				{
					long sn=o.getLong("secretnumber");
					if(h==sn)
					{
						JOptionPane.showMessageDialog(this, "you've been successfully logged in");
						admin2 dash=new admin2();
						super.dispose();
						dash.dashboard();
					}
					else
						JOptionPane.showMessageDialog(this,"OOPS!wrong secret number!try again");	
				}
			}
			else
				JOptionPane.showMessageDialog(this, "SECRET NUMBER CAN'T BE EMPTY");
		}
		if(e.getSource()==b2)
		{
			JOptionPane.showMessageDialog(this,"we're re-sending secret number to your mail,please wait!");
			mail m=new mail();
			m.main(null);
			admin1 a1=new admin1();
			super.dispose();
			a1.login();
		}
		
		}
		catch(Exception ex)
		{
			
		}
	}
}
