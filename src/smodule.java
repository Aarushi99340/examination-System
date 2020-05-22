import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class smodule extends JFrame
implements ActionListener
{
	JButton b1,b2;
	public void mainpage()
	{
		super.setBounds(0, 0, 1500, 1100);
		super.setTitle("MAIN PAGE");
		super.setResizable(false);
		b1=new JButton("SIGNUP");
		b1.setBounds(150, 150, 400, 100);
		super.add(b1);
		b1.addActionListener(this);
		b2=new JButton("LOGIN");
		b2.setBounds(150, 300, 400, 100);
		super.add(b2);
		b2.addActionListener(this);
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) 
	{
		smodule s=new smodule();
		s.mainpage();
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==b1)
			{
				signup s=new signup();
				super.dispose();
				s.sign();
			}
			if(e.getSource()==b2)
			{
				login s=new login();
				super.dispose();
				s.lgn();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
