import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class mainpage extends JFrame 
implements ActionListener
{
	JButton b1,b2,b3;
	public void mainp()
	{
		super.setBounds(0, 0, 1500, 1100);
		super.setTitle("MAIN PAGE");
		super.setResizable(false);
		b1=new JButton("ADMIN");
		b1.setBounds(150, 150, 400, 100);
		super.add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("STUDENT");
		b2.setBounds(150, 300, 400, 100);
		super.add(b2);
		b2.addActionListener(this);
		
		b3=new JButton("COMAPNY");
		b3.setBounds(150, 450, 400, 100);
		super.add(b3);
		b3.addActionListener(this);
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	public static void main(String[] args) 
	
	{
		mainpage p=new mainpage();
		p.mainp();
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==b1)
			{
				JOptionPane.showMessageDialog(this,"we're sending secret number to your mail,please wait!");
				mail m=new mail();
				m.main(null);
				admin1 a1=new admin1();
				super.dispose();
				a1.login();
				
			}
			if(e.getSource()==b2)
			{
				smodule s=new smodule();
				super.dispose();
				s.mainpage();
				
			}
		}
		catch(Exception ex)
		{
			
		}
	}	
}
