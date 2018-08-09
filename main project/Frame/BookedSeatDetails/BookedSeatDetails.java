package Frame.BookedSeatDetails;

import Frame.MainFrame.*;
import Frame.BusInfoFrame.*;
import Frame.AdminFrame.*;
import Frame.BusSeatDetails.*;
import Frame.Login.CustomerLoginFrame.*;
import WindowSensor.*;
import DataAccess.*;
import person.*;
import Frame.PinNoVarification.*;
import Frame.SubMission.*;
import Frame.AdminFrame.AdminFrameP.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BookedSeatDetails extends JFrame implements ActionListener{

	DataAccess da=new DataAccess();
	ResultSet rs=null;
	
	JLabel l1 = new JLabel("NAME");
    JLabel l2 = new JLabel("MOBILE");
    JLabel l3 = new JLabel("SEAT SELECTED");
    JLabel l4 = new JLabel("BUS NAME");
    JLabel l5 = new JLabel("ARRIVAL TIME");
    JLabel l6 = new JLabel("AMOUNT PAID");
    JLabel l7 = new JLabel("CHECK-IN LOCATION");
    JLabel l8 = new JLabel("CHECK-OUT LOCATION");


    JTextField t1 = new JTextField(20);
    JTextField t2 = new JTextField(20);
    JTextField t3 = new JTextField(20);
    JTextField t4 = new JTextField(20);
    JTextField t5 = new JTextField(20);
    JTextField t6 = new JTextField(20);
    JTextField t7 = new JTextField(20);
    JTextField t8 = new JTextField(20);
	
    JPanel panel = new JPanel();
    JButton b1 = new JButton("SUBMIT");
	JButton previous = new JButton("<<Go To Previous Page");
	JButton exit = new JButton("Exit");
	
	person pn;

    public BookedSeatDetails(person p){
		
	super("Booked Seat Details : ");
	addWindowListener(new WindowSensor());
		pn=p;


    panel.setBackground(Color.PINK);
    getContentPane().add(panel);

    l1.setBounds(80,100,100,20);
    l2.setBounds(80,150,100,20);
    l3.setBounds(80,200,100,20);
    l4.setBounds(80,250,200,20);
    l5.setBounds(80,300,100,20);
    l6.setBounds(80,350,100,20);
	l7.setBounds(80,400,300,20);
	l8.setBounds(80,450,300,20);

    t1.setBounds(300,100,300,20);
    t2.setBounds(300,150,300,20);
    t3.setBounds(300,200,300,20);
    t4.setBounds(300,250,300,20);
    t5.setBounds(300,300,300,20);
    t6.setBounds(300,350,300,20);
    t7.setBounds(300,400,300,20);
    t8.setBounds(300,450,300,20);
    b1.setBounds(300,500,200,50);
    previous.setBounds(100,500,200,50);
    exit.setBounds(660,500,100,30);


    panel.add(l1);
    panel.add(t1);

    panel.add(l2);
    panel.add(t2);

    panel.add(l3);
    panel.add(t3);

    panel.add(l4);
    panel.add(t4);

    panel.add(l5);
    panel.add(t5);

    panel.add(l6);
    panel.add(t6);
	
	panel.add(l7);
    panel.add(t7);
	
	panel.add(l8);
    panel.add(t8);

    panel.add(b1);
	
	 panel.add(previous);
     panel.add(exit);


    panel.setLayout(null);

    setSize(800,600);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("BOOKED SEAT DETAILS");
    setVisible(true);
    setResizable(false);

    b1.addActionListener(this);
    previous.addActionListener(this);
    exit.addActionListener(this);
	
	String s = pn.getName();
		System.out.println(s);
		
		String sql="SELECT * FROM personinfo WHERE pName LIKE '"+s+"' ";
		rs=da.getData(sql);
		try{
			while(rs.next()){
           // String n = rs.getString("BusName");
            String l = rs.getString("pPhone");
			String n = rs.getString("seatBooked");
			String o = rs.getString("BusName");
			String q = rs.getString("cLocation");
			String r = rs.getString("dLocation");
			
			System.out.println(l+" "+n+" "+o+" "+q+" "+r);
			
		t1.setText(s);
		t2.setText(l);
		t3.setText(n);
		t4.setText(o);
		t7.setText(q);
		t8.setText(r);
        }}
		catch(Exception e){System.out.println(e.getMessage());}
		
		String s1 = t4.getText();
		String s2 = t7.getText();
		String s4 = t8.getText();
//		String sql1 ="SELECT * FROM businfo WHERE BusName LIKE '"+s1+"' AND CurrentLocation LIKE '"+s2+"' "; 
		String sql1 ="SELECT * FROM businfo WHERE BusName LIKE '"+s1+"' AND CurrentLocation LIKE '"+s2+"' AND NextLocation LIKE '"+s4+"' "; 
		rs=da.getData(sql1);
		try{
			while(rs.next()){
         
			String l = rs.getString("CurrentTime");
			String n = rs.getString("Cost");
			
			double c = Double.parseDouble(n);
			double d = Double.parseDouble(t3.getText());
			
			System.out.println(l+" "+n);
			
		t5.setText(l);
		t6.setText(String.valueOf(c*d));

        }}
		catch(Exception e){System.out.println(e.getMessage());}
		
	String sql2="update personinfo set totalAmount='"+t6.getText()+"' where pName='"+s+"'";
	da.updateDB(sql2);	

  }
  
  public void actionPerformed(ActionEvent a){
    if(a.getActionCommand()=="SUBMIT"){
		
		System.out.println("ddd");
	
		PinNoVarification p = new PinNoVarification(pn);
		p.setVisible(true);
		this.setVisible(false);
     
    }
	if(a.getActionCommand()=="Exit")
		{
			System.exit(0);	
		}
	if(a.getActionCommand()=="<<Go To Previous Page"){
                new BusSeatDetails(pn);

           }

    }

}
