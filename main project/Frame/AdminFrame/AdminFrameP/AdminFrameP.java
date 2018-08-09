
package Frame.AdminFrame.AdminFrameP;

import Frame.MainFrame.*;
import Frame.BusInfoFrame.*;
import Frame.BusSeatDetails.*;
import Frame.BookedSeatDetails.*;
import Frame.Login.CustomerLoginFrame.*;
import WindowSensor.*;
import DataAccess.*;
import person.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class AdminFrameP extends JFrame implements ActionListener{

	  DataAccess da=new DataAccess();
	  ResultSet rs=null;
	  person pn;
      JPanel panel = new JPanel();
      JButton show = new JButton("Show");
      JButton add = new JButton("Add Person");
      JButton delete = new JButton("Delete Person");
	  JButton next = new JButton("Next Page");
	  JButton exit = new JButton("Exit");

      JLabel l1 = new JLabel("NAME");
      JLabel l2 = new JLabel("MOBILE");
	  String []option = {"NO","YES"};
      JLabel l3 = new JLabel("ADMIN ACCESS");
      JLabel l4 = new JLabel("PERSON ID");
      JLabel l5 = new JLabel("PASSWORD");

	  JComboBox <String> aa = new JComboBox<>(option); // aa=admin Access option
	
      JTextField t1 = new JTextField(20);
      JTextField t2 = new JTextField(20);
      JTextField t3 = new JTextField(20);
      JTextField t4 = new JTextField(20);


      public AdminFrameP(person p){
		
		super("Admin Frame for Person : ");		
		addWindowListener(new WindowSensor());
		pn=p;
      panel.setBackground(Color.PINK);
      getContentPane().add(panel);



      l1.setBounds(80,100,100,20);
      l2.setBounds(80,150,100,20);
      l3.setBounds(80,200,100,20);
      l4.setBounds(80,250,200,20);
      l5.setBounds(80,300,300,20);

      t1.setBounds(300,100,300,20);
      t2.setBounds(300,150,300,20);
      aa.setBounds(300,200,300,20);
      t3.setBounds(300,250,300,20);
      t4.setBounds(300,300,300,20);
      show.setBounds(80,400,100,20);
      add.setBounds(200,400,100,20);
      delete.setBounds(320,400,100,20);
      next.setBounds(440,400,100,20);
      exit.setBounds(560,400,100,20);


      panel.add(l1);
      panel.add(t1);

      panel.add(l2);
      panel.add(t2);

      panel.add(l3);
      panel.add(aa);

      panel.add(l4);
      panel.add(t3);
	  
	  panel.add(l5);
      panel.add(t4);

      panel.add(show);
      panel.add(add);
      panel.add(delete);
      panel.add(next);
      panel.add(exit);
  
		 show.addActionListener(this);
		 add.addActionListener(this);
		 delete.addActionListener(this);
		 next.addActionListener(this);
		 exit.addActionListener(this);

          panel.setLayout(null);

          setSize(800,600);
          setLocationRelativeTo(null);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setTitle("AdminFrame");
          setVisible(true);
          setResizable(false);

        }

public void actionPerformed(ActionEvent a){
  if(a.getActionCommand()=="Show")
  {
	  String s = t3.getText();//getting person id from textfield  
	  String sql="SELECT * FROM personinfo WHERE pId LIKE '"+s+"'  ";
		rs=da.getData(sql);
		try{
			while(rs.next()){
            String l = rs.getString("pName");
			String n = rs.getString("pPhone");
			String o = rs.getString("pId");
			String q = rs.getString("pPassword");
			
			System.out.println(l+" "+n+" "+o+" "+q);
			
		t1.setText(l);
		t2.setText(n);
		t3.setText(o);
		t4.setText(q);
        }}
		catch(Exception e){System.out.println(e.getMessage());}
  }
   if(a.getActionCommand()=="Add Person")
   {
	   String s1=t1.getText();
	   String s2=t2.getText();
	   String s3=t3.getText();
	   String s4=t4.getText();
	   	
		String sql2 = "INSERT INTO personinfo (pId, pName, pPassword, pPhone, seatBooked, BusName, totalAmount, aAccess, cLocation, dLocation) VALUES ('"+s3+"', '"+s1+"', '"+s4+"', '"+s2+"', '0', '0', '0', '"+(String) aa.getSelectedItem()+"', '0', '0')";
		da.updateDB(sql2);
   }
   if(a.getActionCommand()=="Delete Person")
   {
	   String sql3="delete from personinfo where pId ='"+t3.getText()+"'";
	   da.updateDB(sql3);
   }
   if(a.getActionCommand()=="Next Page")
   {
	    BusSeatDetails f= new BusSeatDetails(pn);
		f.setVisible(true);
		this.setVisible(false);
   }
   if(a.getActionCommand()=="Exit")
   {
	   System.exit(0);
   }

              

        }
/*
public static void main(String []args){

              new  AdminFrameP(pn);
  }
  */
}
