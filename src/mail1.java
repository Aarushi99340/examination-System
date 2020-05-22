import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
class ChildOfAuthenticator extends Authenticator
{
	public PasswordAuthentication getPasswordAuthentication()
	{
		PasswordAuthentication pa = 
	    new PasswordAuthentication
	    ("kingbrooker21@gmail.com", "Robin@1999");

		return pa;
	}
}
public class mail1 extends JFrame
{
	private String email;
	public mail1(String em) throws Exception
	{
		this.email=em;
		
			Properties p = new Properties();

			p.put("mail.smtp.host", "smtp.gmail.com");
			p.put("mail.smtp.port", "587");
			p.put("mail.smtp.starttls.enable", "true");
			p.put("mail.smtp.auth", "true");
			p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			p.put("mail.debug", "true");
			ChildOfAuthenticator baby = new ChildOfAuthenticator();
			Session session = Session.getInstance(p, baby);
			MimeMessage message = new MimeMessage(session);
			message.setSubject("hi this is your password");
			InternetAddress address=new InternetAddress(email);
			message.addRecipient(Message.RecipientType.TO, address);
			MimeBodyPart body1 = new MimeBodyPart();
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project","root","admin");
			Statement sq=c.createStatement();
			String query="select * from studenttable";
			ResultSet rr=sq.executeQuery(query);
			while(rr.next())
			{
				String ee=rr.getString("email");
				String pass=rr.getString("password");
				if(email.equals(ee))
				{
					
					body1.setText("hi!"+pass+" is your password");
					MimeMultipart part = new MimeMultipart();
					part.addBodyPart(body1);
					message.setContent(part);
					Transport.send(message);
					JOptionPane.showMessageDialog(this, "we've sent password on your mail");
					login l=new login();
					super.dispose();
					l.lgn();
				}
			}
			
		
		
	}
}
