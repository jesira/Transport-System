package Frame.MainFrame;

import Frame.BusInfoFrame.*;
import WindowSensor.*;
import DataAccess.*;
import Frame.AdminFrame.*;
import Frame.BusSeatDetails.*;
import Frame.BookedSeatDetails.*;
import Frame.Login.CustomerLoginFrame.*;
import person.*;
import Frame.PinNoVarification.*;
import Frame.SubMission.*;
import Frame.AdminFrame.AdminFrameP.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;



public class MainFrame extends JFrame implements ActionListener
{
	
	JPanel panel = new JPanel();
	JButton BusInfo = new JButton("Bus Info");
	JButton Login = new JButton("Login");
	JButton exit = new JButton("Exit");
	JLabel welN = new JLabel("Welcome to Degital Transport System!!!");
	
	public MainFrame()
	{
		super("Main Page : ");
		
		panel.setBackground(Color.PINK);
        getContentPane().add(panel);
		
		addWindowListener(new WindowSensor());
		BusInfo.setFont(new Font( "Arial", Font.BOLD, 18));
		Login.setFont(new Font( "Arial", Font.BOLD, 18));
		welN.setFont(new Font( "Arial", Font.BOLD, 22));
		exit.setFont(new Font( "Arial", Font.BOLD, 18));
		
		panel.add(welN);
		panel.add(BusInfo);
		panel.add(Login);
		panel.add(exit);
		
		welN.setBounds(200,20,500,100);
		BusInfo.setBounds(300,180,200,100);
        Login.setBounds(300,320,200,100);
        exit.setBounds(700,500,80,30);
		
		BusInfo.addActionListener(this);
		Login.addActionListener(this);
		exit.addActionListener(this);
		
		  panel.setLayout(null);
		  setSize(800,600);
          setLocationRelativeTo(null);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setTitle("MainFrame");
          setVisible(true);
          setResizable(false);
		
			
	}
	
	public void actionPerformed(ActionEvent ae)
	{	 
		if (ae.getActionCommand() == "Bus Info") 
		{
			System.out.println("Bus Information : ");
			BusInfoFrame frame = new BusInfoFrame();
			frame.setVisible(true);
			this.setVisible(false);
        }
        if (ae.getActionCommand() == "Login") 
		{
			System.out.println("Login");
            CustomerLoginFrame frame2 = new CustomerLoginFrame();
			frame2.setVisible(true);
			this.setVisible(false);
        }
		if (ae.getActionCommand() == "Exit") 
		{
			System.out.println("Exit");
            System.exit(0);
        }
	}

}


