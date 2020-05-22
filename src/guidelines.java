import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class guidelines extends JFrame
implements ActionListener
{
	JLabel l1;
	JTextArea a1;
	JButton b1;
	public void guide()
	{
		super.setBounds(0, 0, 800, 800);
		super.setTitle("GUIDELINES FOR EXAM");
		super.setResizable(false);
		l1=new JLabel("GUIDELINES FOR EXAM");
		l1.setBounds(300,10, 200, 200);
		super.add(l1);
		a1=new JTextArea();
		a1.setBounds(50, 200,600, 300);
		a1.setText("1.2.3.");
		super.add(a1);
		b1=new JButton("OK! I'M READY FOR EXAM");
		b1.setBounds(250, 600, 400, 100);
		super.add(b1);
		b1.addActionListener(this);
		super.setLayout(null);
		super.setVisible(true);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
	public static void main(String[] args)
	{
		guidelines g=new guidelines();
		g.guide();
	}
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			if(e.getSource()==b1)
			{
				exam es=new exam();
				super.dispose();
				es.ex();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
