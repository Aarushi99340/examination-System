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

public class deltopic extends JFrame
implements ActionListener
{
	JButton b1;
	JLabel l1;
	JComboBox box;
	public void del()
	throws Exception
	{
		super.setBounds(0, 0, 900, 1100);
		super.setTitle("DELETE TOPIC");
		super.setResizable(false);
		l1=new JLabel("TOPIC");
		l1.setBounds(70,70, 200, 100);
		super.add(l1);
		box = new JComboBox();
		box.setBounds(260, 100, 150, 40);
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
		b1=new JButton("DELETE THIS TOPIC");
		b1.setBounds(150, 600, 500, 200);
		super.add(b1);
		b1.addActionListener(this);
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) 
	{
		deltopic d=new deltopic();
		try {
			d.del();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==b1)
			{
				String value = (String) box.getSelectedItem();
				Class.forName("com.mysql.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project1","root","admin");
				Statement sq=c.createStatement();
				sq.executeUpdate("drop table "+value);
				JOptionPane.showMessageDialog(this,value+ " has been deleted");
				admin2 dash=new admin2();
				super.dispose();
				dash.dashboard();	
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
