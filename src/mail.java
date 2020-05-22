import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

class BabyOfAuthenticator extends Authenticator
{
	public PasswordAuthentication getPasswordAuthentication()
	{
		PasswordAuthentication pa = 
	    new PasswordAuthentication
	    ("cutehasan17@gmail.com", "cutehasan");

		return pa;
	}
}

public class mail
{
	public static void main(String[] args) throws Exception
	{
		Properties p = new Properties();

		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "587");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		p.put("mail.debug", "true");
		BabyOfAuthenticator baby = new BabyOfAuthenticator();
		Session session = Session.getInstance(p, baby);
		MimeMessage message = new MimeMessage(session);
		message.setSubject("Darna mana hai !!");
		InternetAddress address=new InternetAddress("aaru.raghuvanshi99@gmail.com");
		message.addRecipient(Message.RecipientType.TO, address);
		MimeBodyPart body1 = new MimeBodyPart();
		long r1=System.currentTimeMillis();
		body1.setText("hi!"+r1+" is your secret number");
		body1.setText("hi!"+r1+" is your secret number");
		MimeMultipart part = new MimeMultipart();
		part.addBodyPart(body1);
		message.setContent(part);
		Transport.send(message);
		Class.forName("com.mysql.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project","root","admin");
		Statement sq=c.createStatement();
		String query="update admintable set secretnumber='"+r1+"'";
		sq.executeUpdate(query);
	}
}












