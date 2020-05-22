import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class delques extends JFrame
implements ActionListener
{
	JComboBox box;
	JLabel l1,l2;
	JLabel[] l=new JLabel[10];
	JCheckBox[] check = new JCheckBox[10];
	String[] str = new String[10];
	 String[] str1 = new String[10];
	JButton b;
	JButton b1=new JButton();
	int i=0;
	
	public void deletequestion()
	throws Exception
	{
		super.setBounds(0, 0, 2000, 2000);
		super.setTitle("DELETE QUESTION");
		super.setResizable(false);
		l1=new JLabel("TOPIC");
		l1.setBounds(50, 50, 100, 100);
		super.add(l1);
		l2=new JLabel();
		l2.setBounds(100, 600, 200, 100);
		super.add(l2);
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
		b =new JButton("GET IT");
		b.setBounds(200, 400, 400, 100);
		super.add(b);
		b.addActionListener(this);
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) 
	{
		delques dq=new delques();
		try {
			dq.deletequestion();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==b)
			{
				String value = (String) box.getSelectedItem();
				Class.forName("com.mysql.jdbc.Driver");
				Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project1","root","admin");
				Statement sq=c.createStatement();
				setBounds(0,0, 2000, 2000);
				box.setVisible(false);
				b.setVisible(false);
				l1.setText("Questions From Topic "+value+" are:");
			  	l1.setBounds(20,5,500,50);
			  	add(l1);
			  	l[0]=new JLabel();
			  	l[0].setText("");
			  	l[0].setBounds(20,60,800,50);
			  	add(l[0]);
				
			  	l[1]=new JLabel();
			  	l[1].setText("");
			  	l[1].setBounds(20,120,800,50);
			  	add(l[1]);
				
			  	l[2]=new JLabel();
			  	l[2].setText("");
			  	l[2].setBounds(20,180,800,50);
			  	add(l[2]);
				
			  	l[3]=new JLabel();
			  	l[3].setText("");
			  	l[3].setBounds(20,240,800,50);
			  	add(l[3]);
				
			  	l[4]=new JLabel();
			  	l[4].setText("");
			  	l[4].setBounds(20,300,800,50);
			  	add(l[4]);
				
			  	l[5]=new JLabel();
			  	l[5].setText("");
			  	l[5].setBounds(20,360,800,50);
			  	add(l[5]);
				
			  	l[6]=new JLabel();
			  	l[6].setText("");
			  	l[6].setBounds(20,420,800,50);
			  	add(l[6]);
				
			  	l[7]=new JLabel();
			  	l[7].setText("");
			  	l[7].setBounds(20,480,800,50);
			  	add(l[7]);
				
			  	l[8]=new JLabel();
			  	l[8].setText("");
			  	l[8].setBounds(20,540,800,50);
			  	add(l[8]);
				
			  	l[9]=new JLabel();
			  	l[9].setText("");
			  	l[9].setBounds(20,600,800,50);
			  	add(l[9]);
		  	
			  	check[0]=new JCheckBox();
			  	check[0].setBounds(900,60,500,50);
			  	add(check[0]);
				check[0].setVisible(false);
			  	
				check[1]=new JCheckBox();
			  	check[1].setBounds(900,120,500,50);
			  	add(check[1]);
			  	check[1].setVisible(false);
			  	
			  	check[2]=new JCheckBox();
			  	check[2].setBounds(900,180,500,50);
			  	add(check[2]);
			  	check[2].setVisible(false);
			 
			  	check[3]=new JCheckBox();
			  	check[3].setBounds(900,240,250,50);
			  	add(check[3]);
			  	check[3].setVisible(false);
			  	
			  	check[4]=new JCheckBox();
			  	check[4].setBounds(900,300,500,50);
			  	add(check[4]);
			  	check[4].setVisible(false);
			
			  	check[5]=new JCheckBox();
			  	check[5].setBounds(900,360,500,50);
			  	add(check[5]);
			  	check[5].setVisible(false);
			  	
			  	check[6]=new JCheckBox();
			  	check[6].setBounds(900,420,500,50);
			  	add(check[6]);
			  	check[6].setVisible(false);
			  	
			  	check[7]=new JCheckBox();
			  	check[7].setBounds(900,480,500,50);
			  	add(check[7]);
			  	check[7].setVisible(false);
			  	
			  	check[8]=new JCheckBox();
			  	check[8].setBounds(900,540,500,50);
			  	add(check[8]);
			  	check[8].setVisible(false);
			  	
			  	check[9]=new JCheckBox();
			  	check[9].setBounds(900,600,500,50);
			  	add(check[9]);
			  	check[9].setVisible(false);
			  	b1.setText("Delete Checked Questions");
			  	b1.setBounds(500,780,340,50);
			  	b1.setVisible(true);
			  	add(b1);
			  	b1.addActionListener(this);
			  	super.setLayout(null);
				super.setVisible(true);
			  	ResultSet rs = sq.executeQuery("select ques from "+value);
				 i = 0;
				while(rs.next())
				{  
					str1[i]=rs.getString("ques");
					str[i]="Q."+(i+1)+") "+rs.getString("ques");
				 	check[i].setVisible(true);
				 	l[i].setText(str[i]);
				 	i++;
				}
			}
			if(e.getSource()==b1)
			{
				for(int j=0;j<i;j++)
				{
					if(check[j].isSelected())
					{
						String value = (String) box.getSelectedItem();
						Class.forName("com.mysql.jdbc.Driver");
						Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project1","root","admin");
						Statement sq=c.createStatement();
						sq.executeUpdate("delete from "+value+" where ques='"+str1[j]+"'"); 
						JOptionPane.showMessageDialog(this, "Selected Question(s) were deleted from selected topics");
						admin2 dash=new admin2();
						super.dispose();
						dash.dashboard();	
					}
				}
				
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	

		
		
		
	
			
		
	
		
		
}
