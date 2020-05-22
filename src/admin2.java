import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class admin2 extends JFrame
implements ActionListener
{
	JButton b1,b2,b3,b4,b5,b6,b7;
	public void dashboard()
	{
		super.setBounds(0, 0, 900, 1100);
		super.setTitle("Admin Dashboard");
		super.setResizable(false);
		b1=new JButton("ADD A TOPIC");
		b1.setBounds(50, 20, 600, 100);
		super.add(b1);
		b1.addActionListener(this);
		b2=new JButton("DELETE A TOPIC");
		b2.setBounds(50, 150, 600, 100);
		super.add(b2);
		b2.addActionListener(this);
		b3=new JButton("ADD QUESTION IN TOPIC");
		b3.setBounds(50, 280, 600, 100);
		super.add(b3);
		b3.addActionListener(this);
		b4=new JButton("DELETE QUESTION/S FROM TOPIC");
		b4.setBounds(50, 410, 600, 100);
		super.add(b4);
		b4.addActionListener(this);
		b5=new JButton("FIND STUDENTS");
		b5.setBounds(50, 540, 600, 100);
		super.add(b5);
		b5.addActionListener(this);
		b6=new JButton("SHOW COMPANIES");
		b6.setBounds(50, 670, 600, 100);
		super.add(b6);
		b6.addActionListener(this);
		b7=new JButton("TUTORIALS");
		b7.setBounds(50, 800, 600, 100);
		super.add(b7);
		b7.addActionListener(this);
		
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) 
	{
		admin2 dash=new admin2();
		dash.dashboard();
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==b1)
			{
				addtopic a=new addtopic();
				super.dispose();
				a.add();
			}
			if(e.getSource()==b2)
			{
				deltopic d=new deltopic();
				super.dispose();
				d.del();
			}
			if(e.getSource()==b3)
			{
				addques aq=new addques();
				super.dispose();
				aq.addquestion();
			}
			if(e.getSource()==b4)
			{
				delques dq=new delques();
				super.dispose();
				dq.deletequestion();
			}
		}
		catch(Exception ex)
		{
			
		}
		
	}
}
