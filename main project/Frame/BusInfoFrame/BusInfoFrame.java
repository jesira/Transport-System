package Frame.BusInfoFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import Frame.MainFrame.*;
import Frame.AdminFrame.*;
import Frame.BusSeatDetails.*;
import Frame.BookedSeatDetails.*;
import Frame.Login.CustomerLoginFrame.*;
import WindowSensor.*;
import DataAccess.*;
import person.*;
import Frame.PinNoVarification.*;
import Frame.SubMission.*;
import Frame.AdminFrame.AdminFrameP.*;


public class BusInfoFrame extends JFrame implements ActionListener
{
	DataAccess da=new DataAccess();
	ResultSet rs=null;
	JComboBox <String> cBusName = new JComboBox<>();
	JComboBox <String> cTime = new JComboBox<>();
	
	  JPanel panel = new JPanel();
      JButton previous = new JButton("<<Go To Previous Page");
      JButton next = new JButton("Show Details>>");
	
        JButton log = new JButton("Login");
        JButton exit = new JButton("Exit");
		JTextField it=new JTextField( 20);
		JTextField it1=new JTextField( 20);
		JTextField it2=new JTextField( 20);
		JTextField it3=new JTextField( 20);
		JTextField it4=new JTextField( 20);
		
		JLabel l1=new JLabel("Bus Name :");
		JLabel l7=new JLabel("Current Time :");
		JLabel l2=new JLabel("Booked Seat :");
		JLabel l3=new JLabel("Free Seat :");
		JLabel l4=new JLabel("Current Location :");
		JLabel l6=new JLabel("Bus Information :");
		
        
        public BusInfoFrame()
        {
			super("Bus Details : ");
			panel.setBackground(Color.PINK);
			getContentPane().add(panel);
			
		//adding busname from database --> table "bus" into combobox cBusName 
			String sql="SELECT BusName FROM bus WHERE 1 ";
			rs=da.getData(sql);
		try{
			while(rs.next()){
           
            String bn = rs.getString("BusName");
			System.out.println(bn);
			cBusName.addItem(bn);
        }}
		catch(Exception e){
			System.out.println(e.getMessage());
			}
			
		////adding Current time from database --> table "businfo" into combobox cTime	
		String sql10="SELECT Time FROM location WHERE 1 ";
			rs=da.getData(sql10);
		try{
			while(rs.next()){
           
            String bn = rs.getString("Time");
			System.out.println(bn);
			cTime.addItem(bn);
        }}
		catch(Exception e){
			System.out.println(e.getMessage());
			}	
			
			addWindowListener(new WindowSensor());
			
			l6.setFont(new Font( "Arial", Font.BOLD, 20));
			l1.setFont(new Font( "Arial", Font.BOLD, 18));
			l2.setFont(new Font( "Arial", Font.BOLD, 18));
			l3.setFont(new Font( "Arial", Font.BOLD, 18));
			l4.setFont(new Font( "Arial", Font.BOLD, 18));
			l7.setFont(new Font( "Arial", Font.BOLD, 18));
			
            panel.add(l6);
			panel.add(log);
			
            panel.add(l1);
            panel.add(cBusName);
			panel.add(l7);
			panel.add(cTime);
            panel.add(l2);
            panel.add(it2);
            panel.add(l3);
            panel.add(it3);
            panel.add(l4);
            panel.add(it4);
            panel.add(exit);
            panel.add(previous);
            panel.add(next);
			
			exit.setBounds(650,500,100,20);
			
			l6.setBounds(270,20,280,20);
			log.setBounds(550,50,100,30);
			
			l1.setBounds(80,100,280,20);
			l7.setBounds(80,150,280,20);
			l2.setBounds(80,200,280,20);
			l3.setBounds(80,250,280,20);
			l4.setBounds(80,300,280,20);
        
			cBusName.setBounds(300,100,300,20);
			cTime.setBounds(300,150,300,20);
			it2.setBounds(300,200,300,20);
			it3.setBounds(300,250,300,20);
			it4.setBounds(300,300,300,20);
			
			previous.setBounds(200,460,200,50);
			next.setBounds(400,460,200,50);
			
		log.addActionListener(this);	
		exit.addActionListener(this);	
		previous.addActionListener(this);	
		next.addActionListener(this);	
  
			
		cBusName.addActionListener(this);
		cTime.addActionListener(this);
		
		
            
			panel.setLayout(null);

          setSize(800,600);
          setLocationRelativeTo(null);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setTitle("BusinfoFrame");
          setVisible(true);
          setResizable(false);
			
        }

	public void readData(){
		
		String s = (String) cBusName.getSelectedItem();
		String s1 = (String) cTime.getSelectedItem();
		System.out.println(s);
		
	
		String sql="SELECT * FROM businfo WHERE BusName LIKE '"+s+"' AND CurrentTime LIKE '"+s1+"' ";
		rs=da.getData(sql);
		try{
			while(rs.next()){
           // String n = rs.getString("BusName");
            String l = rs.getString("CurrentTime");
			String n = rs.getString("BookedSeat");
			String o = rs.getString("FreeSeat");
			String q = rs.getString("CurrentLocation");
			
			System.out.println(l+" "+n+" "+o+" "+q);
			
		it1.setText(l);
		it2.setText(n);
		it3.setText(o);
		it4.setText(q);
        }}
		catch(Exception e){System.out.println(e.getMessage());}
		
	}
		
		public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand()=="Exit")
		{
			System.exit(0);	
		}
		else if(ae.getActionCommand()=="Login")
		{
			System.out.println("Login");
            CustomerLoginFrame frame2 = new CustomerLoginFrame();
			frame2.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getActionCommand()=="<<Go To Previous Page"){
                new MainFrame();


				}

          else if(ae.getActionCommand()=="Show Details>>"){
            readData();
			System.out.println("ok");

           }
         }
		
	

}

