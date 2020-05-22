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

public class choose extends JFrame
implements ActionListener
{
	JLabel l1,l2;
	JComboBox box;
	JButton b1;
	public void ch() throws Exception
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project","root","admin");
		Statement sq=c.createStatement();
		String b="select * from studenttable where email='"+datasharing.email+"'";
		ResultSet rs=sq.executeQuery(b);
		while(rs.next())
		{
			String n=rs.getString("name");
			super.setBounds(0, 0, 800, 800);
			super.setTitle("CHOOSE SUBJECT");
			super.setResizable(false);
			l1=new JLabel("HELLO "+n);
			l1.setBounds(200,10, 200, 200);
			super.add(l1);
			l2=new JLabel("PLEASE CHOOSE YOUR SUBJECT");
			l2.setBounds(50, 300,200, 100);
			super.add(l2);
			
			box=new JComboBox();
			box.addItem("C");
			box.addItem("JAVA");
			box.addItem("OS");
			box.addItem("DBMS");
			box.setBounds(300, 300, 200, 50);
			super.add(box);
			b1=new JButton("PROCEED");
			b1.setBounds(500, 600, 200, 100);
			super.add(b1);
			b1.addActionListener(this);
			
			super.setLayout(null);
			super.setVisible(true);
			super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
	}
	public static void main(String[] args) throws Exception
	{
		choose s=new choose();
		s.ch();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			String value = (String) box.getSelectedItem();
			datasharing.topic=value;
			guidelines g=new guidelines();
			super.dispose();
			g.guide();
			
		}
	}
}
