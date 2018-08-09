package Frame.SubMission;

import Frame.MainFrame.*;
import Frame.BusInfoFrame.*;
import Frame.AdminFrame.*;
import Frame.BusSeatDetails.*;
import Frame.Login.CustomerLoginFrame.*;
import WindowSensor.*;
import DataAccess.*;
import person.*;
import Frame.AdminFrame.AdminFrameP.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class SubMission extends JFrame implements ActionListener{
	
	
	JPanel panel = new JPanel();
	JLabel lb = new JLabel("Submission done!!");
//	JLabel img= new JLabel();
	JButton previous = new JButton("<<Go To Previous Page");
	JButton exit = new JButton("Exit");
//	ImageIcon iconLogo = new ImageIcon("C:\Users\Mahfuz Mission\Desktop\java project\main project");
	
	person pn;
	
	public SubMission(person p)
	{
		super("Submission Complete");
		addWindowListener(new WindowSensor());
		
			pn=p;


    panel.setBackground(Color.PINK);
    getContentPane().add(panel);
	
	previous.setBounds(100,500,200,50);
    exit.setBounds(660,500,100,30);
    lb.setBounds(100,350,200,50);

    panel.add(lb);
	//panel.add(img);
	
	panel.add(previous);
    panel.add(exit);
	
	panel.setLayout(null);

    setSize(800,600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("SubMission Completed");
    setVisible(true);
    setResizable(false);

    previous.addActionListener(this);
    exit.addActionListener(this);
	
//	panel.validate();
	
	}
	
	public void actionPerformed(ActionEvent a){
     
    
	if(a.getActionCommand()=="Exit")
		{
			System.exit(0);	
		}
	if(a.getActionCommand()=="<<Go To Previous Page"){
                new BusSeatDetails(pn);
				this.setVisible(false);

           }

    }
	
}