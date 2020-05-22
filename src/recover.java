import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class recover extends JFrame
implements ActionListener
{
	JLabel l1;
	JTextArea a1;
	JButton b1;
	public void rcvr()
	{
		super.setBounds(0, 0, 800, 800);
		super.setTitle("RECOVER PASSWORD PAGE");
		super.setResizable(false);
		l1=new JLabel("EMAIL");
		l1.setBounds(30, 40, 100, 50);
		super.add(l1);
		a1=new JTextArea();
		a1.setBounds(130,40, 300, 50);
		super.add(a1);
		b1=new JButton("RECOVER PASSWORD");
		b1.setBounds(200, 300, 200, 100);
		super.add(b1);
		b1.addActionListener(this);
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) 
	{
		recover r=new recover();
		r.rcvr();
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==b1)
			{
				mail1 m=new mail1(a1.getText());
			}
		}
		catch(Exception ex)
		{
			
		}
	}
}