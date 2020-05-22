import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class exam extends JFrame
implements ActionListener
{
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2,b3;
	ResultSet rs,rs1;
	Statement s1,s2;
	JRadioButton r1=new JRadioButton();
	JRadioButton r2=new JRadioButton();
	JRadioButton r3=new JRadioButton();
	JRadioButton r4=new JRadioButton();
	
	
	String[] q=new String[0];
	int i=0,count=0;
	
	
	public void ex() 
	{
		super.setBounds(0, 0, 1000, 1000);
		super.setTitle("EXAM FOR "+datasharing.topic);
		super.setResizable(false);
		l1=new JLabel();
		l1.setBounds(50, 100, 300, 100);
		super.add(l1);
		l2=new JLabel();
		l2.setBounds(40, 300, 300, 100);
		super.add(l2);
		l3=new JLabel();
		l3.setBounds(40, 400, 300, 100);
		super.add(l3);
		l4=new JLabel();
		l4.setBounds(40, 500, 300, 100);
		super.add(l4);
		l5=new JLabel();
		l5.setBounds(40, 600, 300, 100);
		super.add(l5);
		
		
		b2=new JButton("START TEST");
		b2.setBounds(400,700,200,100);
		super.add(b2);
		b2.addActionListener(this);
	
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent a)
	{
	
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project1","root","admin");
			Statement s1=c.createStatement();
			Statement s2=c.createStatement();
			if(a.getSource() == b2)
			{
				
				b2.setVisible(false);
				b1=new JButton("NEXT");
				b1.setBounds(400, 700, 100, 50);
				super.add(b1);
				b1.addActionListener(this);
				rs=s1.executeQuery("select * from "+datasharing.topic);
				while(rs.next())
				{ 
					
					String f=rs.getString("ques");
					String f1=rs.getString("ans1");
					String f2=rs.getString("ans2");
					String f3=rs.getString("ans3");
					String f4=rs.getString("ans4");
					String f5=rs.getString("ca");
					l1.setText(f);
					l2.setText(f1);
					l3.setText(f2);
					l4.setText(f3);
					l5.setText(f4);
					
					r1.setBounds(400, 300, 100, 50);
				
					this.add(r1);
					
					r2.setBounds(400, 400, 100, 50);
					this.add(r2);
					
					r3.setBounds(400, 500, 100, 50);
					this.add(r3);
					
					r4.setBounds(400, 600, 100, 50);
					this.add(r4);
					
					ButtonGroup g1=new ButtonGroup();
					g1.add(r1);
					g1.add(r2);
					g1.add(r3);
					g1.add(r4);
					
					break;
				}
				
					
			}	
			if(a.getSource()==b1)
				
		        {
				
				
				String f,f1,f2,f3,f4,f5="";
				

				ButtonGroup g1=new ButtonGroup();
				if (!r1.isSelected()&&!r2.isSelected()&&!r3.isSelected()&&!r4.isSelected()) 
                { 
                	JOptionPane.showMessageDialog(this, "please select an option"); 
                    
                } 
				else
				{
					
					
					
					
				rs1=s2.executeQuery("select * from "+datasharing.topic);
				while(rs.next())
				{ 
					
					f=rs.getString("ques");
					f1=rs.getString("ans1");
					f2=rs.getString("ans2");
					f3=rs.getString("ans3");
					f4=rs.getString("ans4");
					 f5=rs.getString("ca");
					l1.setText(f);
					l2.setText(f1);
					l3.setText(f2);
					l4.setText(f3);
					l5.setText(f4);
					 
					r1.setBounds(400, 400, 100, 50);
					this.add(r1);
					r2.setBounds(400, 400, 100, 50);
					this.add(r2);					
					r3.setBounds(400, 500, 100, 50);
					this.add(r3);					
					r4.setBounds(400, 600, 100, 50);
					this.add(r4);
					
					
					g1.add(r1);
					g1.add(r2);
					g1.add(r3);
					g1.add(r4);  
					
				
					
					
	               
					break;
					
						
				}
				}
				
				
				 
				 
				
					
			}
			if(a.getSource()==b3)
			{
				

			}
		
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	

			
		
	public static void main(String[] args) 
	{
		exam e=new exam();
		e.ex();
	}
}
