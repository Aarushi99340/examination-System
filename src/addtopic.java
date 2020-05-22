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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class addtopic extends JFrame
implements ActionListener
{
	JButton b1;
	JLabel l1;
	JTextArea a1;
	public void add()
	{
		super.setBounds(0, 0, 900, 1100);
		super.setTitle("ADD TOPIC");
		super.setResizable(false);
		l1=new JLabel("TOPIC");
		l1.setBounds(70,70, 200, 100);
		super.add(l1);
		a1=new JTextArea();
		a1.setBounds(300, 70, 500, 100);
		super.add(a1);
		b1=new JButton("ADD THIS TOPIC");
		b1.setBounds(150, 600, 500, 200);
		super.add(b1);
		b1.addActionListener(this);
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) 
	{
		addtopic a=new addtopic();
		a.add();
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==b1)
			{
				String b=a1.getText();
				if(!b.isEmpty())
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project1","root","admin");
					Statement sq=c.createStatement();
					String l="create table "+b+" "+"(sno int,ques varchar(100),ans1 varchar(100),ans2 varchar(100),ans3 varchar(100),ans4 varchar(100),ca varchar(100))";
					sq.executeUpdate(l);
					JOptionPane.showMessageDialog(this,b+" has been added");
					admin2 dash=new admin2();
					super.dispose();
					dash.dashboard();	
				}
				else
					JOptionPane.showMessageDialog(this, "TOPIC CAN'T BE EMPTY");
			}
		}
		catch(Exception ex)
		{
			String b=a1.getText();
			JOptionPane.showMessageDialog(this,b+" table exists");
		}
	}
}
