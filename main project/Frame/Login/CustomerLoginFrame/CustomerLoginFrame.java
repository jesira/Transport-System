package Frame.Login.CustomerLoginFrame;

import Frame.MainFrame.*;
import Frame.BusInfoFrame.*;
import Frame.AdminFrame.*;
import Frame.BusSeatDetails.*;
import Frame.BookedSeatDetails.*;
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


public class CustomerLoginFrame extends JFrame implements ActionListener{

	ResultSet rs=null;
	DataAccess da = new DataAccess();
	person p;
	
  JPanel panel = new JPanel();
  JLabel l1 = new JLabel("Password :");
  JLabel l2 = new JLabel("Username :");
  JTextField tp = new JTextField(10);
  JTextField tn = new JTextField(10);
  JButton b1 = new JButton("Login");
  
  JButton previous = new JButton("<<Go To Previous Page");
  JButton exit = new JButton("Exit");


  public CustomerLoginFrame(){
	  
		super("Login Page : ");
		addWindowListener(new WindowSensor());
		
		
		
          panel.setBackground(Color.PINK);
          getContentPane().add(panel);

          panel.add(l2);
          panel.add(tn);
          panel.add(l1);
          panel.add(tp);
          panel.add(b1);
          panel.add(previous);
          panel.add(exit);
		  
		  l2.setBounds(80,20,100,20);
		  tn.setBounds(180,20,120,20);
		  l1.setBounds(80,80,100,20);
		  tp.setBounds(180,80,120,20);
		  b1.setBounds(320,40,120,40);
		  previous.setBounds(80,120,150,50);
		  exit.setBounds(230,120,150,50);

          b1.addActionListener(this);
          previous.addActionListener(this);
          exit.addActionListener(this);
		  
		  panel.setLayout(null);

          setSize(500,280);
          setLocationRelativeTo(null);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setTitle("Login to Coninue");
          setVisible(true);
          setResizable(false);


}

public void actionPerformed(ActionEvent ae){
	
	String uName = new String(tn.getText());
	String uPass = new String(tp.getText());
	
	String l=new String();
	String n=new String();
	String pn=new String();
	String pp=new String();
	
	String sql="SELECT * FROM personinfo WHERE pName LIKE '"+uName+"' ";

		rs=da.getData(sql);
		try{
			while(rs.next()){
             l = rs.getString("pPassword");
			 n = rs.getString("aAccess");
			 pp = rs.getString("pPhone");
			 pn = rs.getString("pName");
			
			System.out.println(l+" "+n);
        }}
		catch(Exception e){System.out.println(e.getMessage());}
		int count=0;
		
		p = new person(pn,pp); 
		if(uPass.equals(l) && n.equals("YES")){
			System.out.println(l);
			count+=2;
			}
		else if(uPass.equals(l) && n.equals("NO")){
			count+=1;
			}
		else{
			System.out.println("check");
		}
		
      if(ae.getActionCommand()=="Login"){
		  if(uName.equals("") || uPass.equals(""))
		  {
			b1.setVisible(false);
			tp.setVisible(false);
			tn.setVisible(false);
			l1.setVisible(false);
			l2.setVisible(false);

			l1.setText("incorrect UserName or Password ");
			l1.setVisible(true);
			CustomerLoginFrame frame = new CustomerLoginFrame();
			frame.setVisible(true);
			this.setVisible(false);
			
		  }
		  else if(count==1)
		  {
			b1.setVisible(false);
			tp.setVisible(false);
			tn.setVisible(false);
			l1.setVisible(false);
			l2.setVisible(false);

			l1.setText("Logged in As a Customer----->>>");
			l1.setVisible(true);
		  
			BusSeatDetails frame = new BusSeatDetails(p);
			frame.setVisible(true);
			this.setVisible(false);  
		  }
		  else if(count==2)
		  {
			b1.setVisible(false);
			tp.setVisible(false);
			tn.setVisible(false);
			l1.setVisible(false);
			l2.setVisible(false);

			l1.setText("Logged in As an Admin----->>>");
			l1.setVisible(true);
		  
			AdminFrameP frame = new AdminFrameP(p);
			frame.setVisible(true);
			this.setVisible(false);  
		  }
		  else
		  {
			  JOptionPane.showMessageDialog(this,"Password doesn't match,try again !");
		  }

      }
	  if(ae.getActionCommand()=="Exit")
		{
			System.exit(0);	
		}
	if(ae.getActionCommand()=="<<Go To Previous Page")
		{
            new MainFrame();

        }

}

}
