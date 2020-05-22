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
import javax.swing.JTextField;

public class addques extends JFrame
implements ActionListener
{
	JComboBox box;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextArea a1;
	JTextField t1,t2,t3,t4,t5;
	JButton b;
	public void addquestion()
	throws Exception
	{
		super.setBounds(0, 0, 900, 1100);
		super.setTitle("ADD QUESTION");
		super.setResizable(false);
		l1=new JLabel("TOPIC");
		l1.setBounds(50, 50, 100, 100);
		super.add(l1);
		box =new JComboBox();
		box.setBounds(260, 100, 200, 40);
		super.add(box);
		Class.forName("com.mysql.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project1","root","admin");
		Statement sq=c.createStatement();
		ResultSet rs=sq.executeQuery("show tables in project1");
		while(rs.next())
		{
			String z=rs.getString("Tables_in_project1");
			box.addItem(z);
		}
		l2=new JLabel("QUESTION");
		l2.setBounds(50, 200, 100, 100);
		super.add(l2);
		a1=new JTextArea();
		a1.setBounds(250, 200, 400, 200);
		super.add(a1);
		l3=new JLabel("ANSWER 1");
		l3.setBounds(50,400,100, 100);
		super.add(l3);
		t1=new JTextField();
		t1.setBounds(250, 430, 400, 50);
		super.add(t1);
		
		l4=new JLabel("ANSWER 2");
		l4.setBounds(50,480,100, 100);
		super.add(l4);
		t2=new JTextField();
		t2.setBounds(250, 500, 400, 50);
		super.add(t2);
		
		l5=new JLabel("ANSWER 3");
		l5.setBounds(50,550,100, 100);
		super.add(l5);
		t3=new JTextField();
		t3.setBounds(250, 580, 400, 50);
		super.add(t3);
		
		l6=new JLabel("ANSWER 4");
		l6.setBounds(50,630,100, 100);
		super.add(l6);
		t4=new JTextField();
		t4.setBounds(250, 660, 400, 50);
		super.add(t4);
		
		l7=new JLabel("CORRECT ANSWER ");
		l7.setBounds(50,700,200, 100);
		super.add(l7);
		t5=new JTextField();
		t5.setBounds(250, 730, 400, 50);
		super.add(t5);
		b=new JButton("ADD QUESTION");
		b.setBounds(250, 800, 400, 100);
		super.add(b);
		b.addActionListener(this);
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) 
	{
		addques aq=new addques();
		try {
			aq.addquestion();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			String f=a1.getText();
			String f1=t1.getText();
			String f2=t2.getText();
			String f3=t3.getText();
			String f4=t4.getText();
			String f5=t5.getText();
			int sno=0;
			if(f.isEmpty())
			{
				JOptionPane.showMessageDialog(this,"question can't be empty");
			}
			if(f1.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "ans 1 can't be empty");
			}
			if(f2.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "ans 2 can't be empty");
			}
			if(f3.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "ans 3 can't be empty");
			}
			if(f4.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "ans 4 can't be empty");
			}
			if(f5.isEmpty())
			{
				JOptionPane.showMessageDialog(this, "correct answer can't be empty");
			}
			if(!f.isEmpty()&&(!f1.isEmpty())&&(!f2.isEmpty())&&(!f3.isEmpty())&&(!f4.isEmpty())&&(!f5.isEmpty()))
			{
				String value = (String) box.getSelectedItem();
				Class.forName("com.mysql.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project1","root","admin");
				Statement sq=c.createStatement();
				ResultSet rs=sq.executeQuery("select * from "+value);
				int num,num1=0;
				while(rs.next())
				{
					num=rs.getInt("sno");
					num1=num+1;
					
				}
				if(num1<=10)
				{
					String query="insert into "+value+" values('"+num1+"','"+f+"','"+f1+"','"+f2+"','"+f3+"','"+f4+"','"+f5+"')";
					sq.execute(query);
					JOptionPane.showMessageDialog(this, "your question has been added");
					admin2 dash=new admin2();
					super.dispose();
					dash.dashboard();	
				}
				else
				{
					JOptionPane.showMessageDialog(this, "sorry! can't add more than 10 questions in a topic");
				admin2 dash=new admin2();
				super.dispose();
				dash.dashboard();
				}
				
				
				
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
}
