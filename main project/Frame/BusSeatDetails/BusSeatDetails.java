
package Frame.BusSeatDetails;

import Frame.MainFrame.*;
import Frame.BusInfoFrame.*;
import Frame.AdminFrame.*;
import Frame.BookedSeatDetails.*;
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

public class BusSeatDetails extends JFrame implements ActionListener
{
	DataAccess da=new DataAccess();
	ResultSet rs=null;
	JComboBox <String> cIn = new JComboBox<>();
	JComboBox <String> cOut = new JComboBox<>();
	JComboBox <String> bName = new JComboBox<>();
		int count=0,i;
		int Booked[]=new int[25];
		int booked[]=new int[25];
		
		JPanel panel = new JPanel();
        JButton log = new JButton("LogOut");
        JButton Bus = new JButton("Bus Info");
        JButton cancel = new JButton("cancel");
		JButton exit = new JButton("Exit");
		JButton ok = new JButton("OK");
		
        JButton a1 = new JButton("A1");
        JButton a2 = new JButton("A2");
        JButton a3 = new JButton("A3");
        JButton a4 = new JButton("A4");
        JButton a5 = new JButton("A5");
        JButton b1 = new JButton("B1");
        JButton b2 = new JButton("B2");
        JButton b3 = new JButton("B3");
        JButton b4 = new JButton("B4");
        JButton b5 = new JButton("B5");
        JButton c1 = new JButton("C1");
        JButton c2 = new JButton("C2");
        JButton c3 = new JButton("C3");
        JButton c4 = new JButton("C4");
        JButton c5 = new JButton("C5");
        JButton d1 = new JButton("D1");
        JButton d2 = new JButton("D2");
        JButton d3 = new JButton("D3");
        JButton d4 = new JButton("D4");
        JButton d5 = new JButton("D5");
        JButton e1 = new JButton("E1");
        JButton e2 = new JButton("E2");
        JButton e3 = new JButton("E3");
        JButton e4 = new JButton("E4");
        JButton e5 = new JButton("E5");
		
        JButton confirm = new JButton("Confirm");
				
		JLabel lcIn=new JLabel("check in :");
		JLabel lcOut=new JLabel("check out :");
		JLabel l5=new JLabel("Bus Seat Details : ");
		
        person pn; //containership.
		
        public BusSeatDetails(person p)
  
        {
			super("Bus Seat Details : ");
			pn=p;
			
			panel.setBackground(Color.PINK);
			getContentPane().add(panel);
			
			addWindowListener(new WindowSensor());
			String sql="SELECT locationName FROM location WHERE 1 ";
			rs=da.getData(sql);
		try{
			while(rs.next()){
           
            String bn = rs.getString("locationName");
			System.out.println(bn);
			cIn.addItem(bn);
			cOut.addItem(bn);
            //comboBox_1.getSelectedItem();
        }}
		catch(Exception e){
			System.out.println(e.getMessage());
			}
			
		String sql1="SELECT BusName FROM bus WHERE 1 ";
			rs=da.getData(sql1);
		try{
			while(rs.next()){
           
            String bn = rs.getString("BusName");
			System.out.println(bn);
			bName.addItem(bn);
            //comboBox_1.getSelectedItem();
        }}
		catch(Exception e){
			System.out.println(e.getMessage());
			}	
			
			
			panel.add(l5);panel.add(Bus);panel.add(bName);panel.add(log);panel.add(ok);
			panel.add(lcIn);panel.add(cIn);  panel.add(lcOut);panel.add(cOut);
			
			
			panel.add(a1);panel.add(a2);   panel.add(a3);panel.add(a4);panel.add(a5);
			panel.add(b1);panel.add(b2);   panel.add(b3);panel.add(b4);panel.add(b5);
			panel.add(c1);panel.add(c2);   panel.add(c3);panel.add(c4);panel.add(c5);
			panel.add(d1);panel.add(d2);   panel.add(d3);panel.add(d4);panel.add(d5);
			panel.add(e1);panel.add(e2);   panel.add(e3);panel.add(e4);panel.add(e5);
			
			panel.add(cancel);panel.add(confirm);
			panel.add(exit);
			
			
			l5.setBounds(300,20,200,20);
			Bus.setBounds(140,50,100,20);
			bName.setBounds(300,50,100,20);
			ok.setBounds(400,50,100,20);
			log.setBounds(550,50,100,20);
			confirm.setBounds(550,400,100,20);
			cancel.setBounds(550,150,100,20);
			exit.setBounds(550,300,100,20);
			
			lcIn.setBounds(80,100,100,20);
			cIn.setBounds(140,100,100,20);
			lcOut.setBounds(300,100,100,20);
			cOut.setBounds(370,100,200,20);
			
			a1.setBounds(130,150,50,20);
			a2.setBounds(180,150,50,20);
			a3.setBounds(300,150,50,20);
			a4.setBounds(350,150,50,20);
			a5.setBounds(400,150,50,20);
			
			b1.setBounds(130,210,50,20);
			b2.setBounds(180,210,50,20);
			b3.setBounds(300,210,50,20);
			b4.setBounds(350,210,50,20);
			b5.setBounds(400,210,50,20);
			
			c1.setBounds(130,270,50,20);
			c2.setBounds(180,270,50,20);
			c3.setBounds(300,270,50,20);
			c4.setBounds(350,270,50,20);
			c5.setBounds(400,270,50,20);
			
			d1.setBounds(130,330,50,20);
			d2.setBounds(180,330,50,20);
			d3.setBounds(300,330,50,20);
			d4.setBounds(350,330,50,20);
			d5.setBounds(400,330,50,20);
			
			e1.setBounds(130,390,50,20);
			e2.setBounds(180,390,50,20);
			e3.setBounds(300,390,50,20);
			e4.setBounds(350,390,50,20);
			e5.setBounds(400,390,50,20);
			
		log.addActionListener(this);	
		ok.addActionListener(this);	
		exit.addActionListener(this);	
			
		a1.addActionListener(this);
		a2.addActionListener(this);
		a3.addActionListener(this);
		a4.addActionListener(this);
		a5.addActionListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		c1.addActionListener(this);
		c2.addActionListener(this);
		c3.addActionListener(this);
		c4.addActionListener(this);
		c5.addActionListener(this);
		d1.addActionListener(this);
		d2.addActionListener(this);
		d3.addActionListener(this);
		d4.addActionListener(this);
		d5.addActionListener(this);
		e1.addActionListener(this);
		e2.addActionListener(this);
		e3.addActionListener(this);
		e4.addActionListener(this);
		e5.addActionListener(this);
		confirm.addActionListener(this);
		Bus.addActionListener(this);
		cancel.addActionListener(this);
            
			panel.setLayout(null);

          setSize(800,600);
          setLocationRelativeTo(null);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setTitle("BusinfoFrame");
          setVisible(true);
          setResizable(false);
        }
		
		public void updateData(){
			for(int i=0;i<25;i++)
			{
				if(Booked[i]==1)
				{
					count++;
				}
			}
			
		
		String s1 = (String) cIn.getSelectedItem();
		String s2 = (String) cOut.getSelectedItem();
		String s3 = (String) bName.getSelectedItem();
		System.out.println(s1+" "+s2+" "+s3);
		String name = pn.getName();
		System.out.println(name);
		System.out.println(count);
		String sql2="update personinfo set BusName='"+s3+"', cLocation='"+s1+"', dLocation='"+s2+"', seatBooked='"+count+"' where pName='"+name+"'";
		System.out.println(sql2);
		da.updateDB(sql2);
		
	}
	//cchecking if the seat was booked by someone or not
	public void readData(){
		
		String s5 = (String) bName.getSelectedItem();
		System.out.println(s5);
		
	
		String sql="SELECT * FROM "+s5+" WHERE BusName LIKE '"+s5+"' ";
		rs=da.getData(sql);
		try{
			while(rs.next()){
            String l = rs.getString("Bid");
			String n = rs.getString("Booked");
			
			
			System.out.println(l+" "+n);
			int x = Integer.parseInt(l);
			
			if(n.equals("1"))
			{
				booked[x]=1;
			}
        }}
		catch(Exception e){System.out.println(e.getMessage());}
		
		if(booked[0]== 1)
		{
			a1.setBackground(Color.red);
		}
		if(booked[1]== 1)
		{
			a2.setBackground(Color.red);
		}if(booked[2]== 1)
		{
			a3.setBackground(Color.red);
		}
		if(booked[3]== 1)
		{
			a4.setBackground(Color.red);
		}
		if(booked[4]== 1)
		{
			a5.setBackground(Color.red);
		}
		if(booked[5]== 1)
		{
			b1.setBackground(Color.red);
		}
		if(booked[6]== 1)
		{
			b2.setBackground(Color.red);
		}
		if(booked[7]== 1)
		{
			b3.setBackground(Color.red);
		}
		if(booked[8]== 1)
		{
			b4.setBackground(Color.red);
		}
		if(booked[9]== 1)
		{
			b5.setBackground(Color.red);
		}
		if(booked[10]== 1)
		{
			c1.setBackground(Color.red);
		}
		if(booked[11]== 1)
		{
			c2.setBackground(Color.red);
		}
		if(booked[12]== 1)
		{
			c3.setBackground(Color.red);
		}
		if(booked[13]== 1)
		{
			c4.setBackground(Color.red);
		}
		if(booked[14]== 1)
		{
			c5.setBackground(Color.red);
		}
		if(booked[15]== 1)
		{
			d1.setBackground(Color.red);
		}
		if(booked[16]== 1)
		{
			d2.setBackground(Color.red);
		}
		if(booked[17]== 1)
		{
			d3.setBackground(Color.red);
		}
		if(booked[18]== 1)
		{
			d4.setBackground(Color.red);
		}
		if(booked[19]== 1)
		{
			d5.setBackground(Color.red);
		}
		if(booked[20]== 1)
		{
			e1.setBackground(Color.red);
		}
		if(booked[21]== 1)
		{
			e2.setBackground(Color.red);
		}
		if(booked[22]== 1)
		{
			e3.setBackground(Color.red);
		}
		if(booked[23]== 1)
		{
			e4.setBackground(Color.red);
		}
		if(booked[24]== 1)
		{
			e5.setBackground(Color.red);
		}
	}
		
		

	public void actionPerformed(ActionEvent ae)
	{
		String s4 = (String) bName.getSelectedItem();
		String pname = pn.getName();
		if(ae.getActionCommand()=="OK")
		{
			readData();
		}

	if (ae.getActionCommand() == "A1")
        {
			if(Booked[0]==1){
				Booked[0]=0;
			    a1.setBackground(null);
				String sql4="update "+s4+" set Booked='0', pName='0' where Bid='0'";
				da.updateDB(sql4);
			}
			else{
			Booked[0]=1;
            a1.setBackground(Color.red);
			String sql3="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='0'";
			da.updateDB(sql3);
			}
        }
	else if (ae.getActionCommand() == "A2")
        {
           if(Booked[1]==1){
				Booked[1]=0;
			    a2.setBackground(null);
				String sql5="update "+s4+" set Booked='0', pName='0' where Bid='1'";
				da.updateDB(sql5);
			}
			else{
			Booked[1]=1;
            a2.setBackground(Color.red);
			String sql6="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='1'";
			da.updateDB(sql6);
			}
        }
	else if (ae.getActionCommand() == "A3")
        {
            if(Booked[2]==1){
				Booked[2]=0;
			    a3.setBackground(null);
				String sql8="update "+s4+" set Booked='0', pName='0' where Bid='2'";
				da.updateDB(sql8);
			}
			else{
			Booked[2]=1;
            a3.setBackground(Color.red);
			String sql7="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='2'";
			da.updateDB(sql7);
			}
        }
	else if (ae.getActionCommand() == "A4")
        {
            if(Booked[3]==1){
				Booked[3]=0;
			    a4.setBackground(null);
				String sql9="update "+s4+" set Booked='0', pName='0' where Bid='3'";
				da.updateDB(sql9);
			}
			else{
			Booked[3]=1;
            a4.setBackground(Color.red);
			String sql10="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='3'";
			da.updateDB(sql10);
			}
        }
	else if (ae.getActionCommand() == "A5")
        {
            if(Booked[4]==1){
				Booked[4]=0;
			    a5.setBackground(null);
				String sql12="update "+s4+" set Booked='0', pName='0' where Bid='4'";
				da.updateDB(sql12);
			}
			else{
			Booked[4]=1;
            a5.setBackground(Color.red);
			String sql11="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='4'";
			da.updateDB(sql11);
			}
        }
	else if (ae.getActionCommand() == "B1")
        {
            if(Booked[5]==1){
				Booked[5]=0;
			    b1.setBackground(null);
				String sql13="update "+s4+" set Booked='0', pName='0' where Bid='5'";
				da.updateDB(sql13);
			}
			else{
			Booked[5]=1;
            b1.setBackground(Color.red);
			String sql14="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='5'";
			da.updateDB(sql14);
			}
        }	
	else if (ae.getActionCommand() == "B2")
        {
           if(Booked[6]==1){
				Booked[6]=0;
			    b2.setBackground(null);
				String sql16="update "+s4+" set Booked='0', pName='0' where Bid='6'";
				da.updateDB(sql16);
			}
			else{
			Booked[6]=1;
            b2.setBackground(Color.red);
			String sql15="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='6'";
			da.updateDB(sql15);
			}
        }
	else if (ae.getActionCommand() == "B3")
        {
           if(Booked[7]==1){
				Booked[7]=0;
			    b3.setBackground(null);
				String sql17="update "+s4+" set Booked='0', pName='0' where Bid='7'";
				da.updateDB(sql17);
			}
			else{
			Booked[7]=1;
            b3.setBackground(Color.red);
			String sql18="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='7'";
			da.updateDB(sql18);
			}
        }
	else if (ae.getActionCommand() == "B4")
        {
           if(Booked[8]==1){
				Booked[8]=0;
			    b4.setBackground(null);
				String sql19="update "+s4+" set Booked='0', pName='0' where Bid='8'";
				da.updateDB(sql19);
			}
			else{
			Booked[8]=1;
            b4.setBackground(Color.red);
			String sql20="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='8'";
			da.updateDB(sql20);
			}
        }
	else if (ae.getActionCommand() == "B5")
        {
            if(Booked[9]==1){
				Booked[9]=0;
			    b5.setBackground(null);
				String sql21="update "+s4+" set Booked='0', pName='0' where Bid='9'";
				da.updateDB(sql21);
			}
			else{
			Booked[9]=1;
            b5.setBackground(Color.red);
			String sql22="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='9'";
			da.updateDB(sql22);
			}
        }	
	else if (ae.getActionCommand() == "C1")
        {
            if(Booked[10]==1){
				Booked[10]=0;
			    c1.setBackground(null);
				String sql24="update "+s4+" set Booked='0', pName='0' where Bid='10'";
				da.updateDB(sql24);
			}
			else{
			Booked[10]=1;
            c1.setBackground(Color.red);
			String sql23="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='10'";
			da.updateDB(sql23);
			}
        }	
	else if (ae.getActionCommand() == "C2")
        {
            if(Booked[11]==1){
				Booked[11]=0;
			    c2.setBackground(null);
				String sql25="update "+s4+" set Booked='0', pName='0' where Bid='11'";
				da.updateDB(sql25);
			}
			else{
			Booked[11]=1;
            c2.setBackground(Color.red);
			String sql26="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='11'";
			da.updateDB(sql26);
			}
        }
	else if (ae.getActionCommand() == "C3")
        {
            if(Booked[12]==1){
				Booked[12]=0;
			    c3.setBackground(null);
				String sql28="update "+s4+" set Booked='0', pName='0' where Bid='12'";
				da.updateDB(sql28);
			}
			else{
			Booked[12]=1;
            c3.setBackground(Color.red);
			String sql27="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='12'";
			da.updateDB(sql27);
			}
        }
	else if (ae.getActionCommand() == "C4")
        {
             if(Booked[13]==1){
				Booked[13]=0;
			    c4.setBackground(null);
				String sql29="update "+s4+" set Booked='0', pName='0' where Bid='13'";
				da.updateDB(sql29);
			}
			else{
			Booked[13]=1;
            c4.setBackground(Color.red);
			String sql30="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='13'";
			da.updateDB(sql30);
			}
        }
	else if (ae.getActionCommand() == "C5")
        {
             if(Booked[14]==1){
				Booked[14]=0;
			    c5.setBackground(null);
				String sql32="update "+s4+" set Booked='0', pName='0' where Bid='14'";
				da.updateDB(sql32);
			}
			else{
			Booked[14]=1;
            c5.setBackground(Color.red);
			String sql31="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='14'";
			da.updateDB(sql31);
			}
        }	
	else if (ae.getActionCommand() == "D1")
        {
             if(Booked[15]==1){
				Booked[15]=0;
			    d1.setBackground(null);
				String sql33="update "+s4+" set Booked='0', pName='0' where Bid='15'";
				da.updateDB(sql33);
			}
			else{
			Booked[15]=1;
            d1.setBackground(Color.red);
			String sql34="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='15'";
			da.updateDB(sql34);
			}
        }	
	else if (ae.getActionCommand() == "D2")
        {
           if(Booked[16]==1){
				Booked[16]=0;
			    d2.setBackground(null);
				String sql35="update "+s4+" set Booked='0', pName='0' where Bid='16'";
				da.updateDB(sql35);
			}
			else{
			Booked[16]=1;
            d2.setBackground(Color.red);
			String sql36="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='16'";
			da.updateDB(sql36);
			}
        }
	else if (ae.getActionCommand() == "D3")
        {
            if(Booked[17]==1){
				Booked[17]=0;
			    d3.setBackground(null);
				String sql38="update "+s4+" set Booked='0', pName='0' where Bid='17'";
				da.updateDB(sql38);
			}
			else{
			Booked[17]=1;
            d3.setBackground(Color.red);
			String sql37="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='17'";
			da.updateDB(sql37);
			}
        }
	else if (ae.getActionCommand() == "D4")
        {
           if(Booked[18]==1){
				Booked[18]=0;
			    d4.setBackground(null);
				String sql39="update "+s4+" set Booked='0', pName='0' where Bid='18'";
				da.updateDB(sql39);
			}
			else{
			Booked[18]=1;
            d4.setBackground(Color.red);
			String sql40="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='18'";
			da.updateDB(sql40);
			}
        }
	else if (ae.getActionCommand() == "D5")
        {
           if(Booked[19]==1){
				Booked[19]=0;
			    d5.setBackground(null);
				String sql41="update "+s4+" set Booked='0', pName='0' where Bid='19'";
				da.updateDB(sql41);
			}
			else{
			Booked[19]=1;
            d5.setBackground(Color.red);
			String sql42="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='19'";
			da.updateDB(sql42);
			}
        }
	else if (ae.getActionCommand() == "E1")
        {
            if(Booked[20]==1){
				Booked[20]=0;
			    e1.setBackground(null);
				String sql43="update "+s4+" set Booked='0', pName='0' where Bid='20'";
				da.updateDB(sql43);
			}
			else{
			Booked[20]=1;
            e1.setBackground(Color.red);
			String sql44="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='20'";
			da.updateDB(sql44);
			}
        }	
	else if (ae.getActionCommand() == "E2")
        {
           if(Booked[21]==1){
				Booked[21]=0;
			    e2.setBackground(null);
				String sql45="update "+s4+" set Booked='0', pName='0' where Bid='21'";
				da.updateDB(sql45);
			}
			else{
			Booked[21]=1;
            e2.setBackground(Color.red);
			String sql46="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='21'";
			da.updateDB(sql46);
			}
        }
	else if (ae.getActionCommand() == "E3")
        {
            if(Booked[22]==1){
				Booked[22]=0;
			    e3.setBackground(null);
				String sql47="update "+s4+" set Booked='0', pName='0' where Bid='22'";
				da.updateDB(sql47);
			}
			else{
			Booked[22]=1;
            e3.setBackground(Color.red);
			String sql48="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='22'";
			da.updateDB(sql48);
			}
        }
	else if (ae.getActionCommand() == "E4")
        {
            if(Booked[23]==1){
				Booked[23]=0;
			    e4.setBackground(null);
				String sql49="update "+s4+" set Booked='0', pName='0' where Bid='23'";
				da.updateDB(sql49);
			}
			else{
			Booked[23]=1;
            e4.setBackground(Color.red);
			String sql50="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='23'";
			da.updateDB(sql50);
			}
        }
	else if (ae.getActionCommand() == "E5")
        {
           if(Booked[24]==1){
				Booked[24]=0;
			    e5.setBackground(null);
				String sql51="update "+s4+" set Booked='0', pName='0' where Bid='24'";
				da.updateDB(sql51);
			}
			else{
			Booked[24]=1;
            e5.setBackground(Color.red);
			String sql52="update "+s4+" set Booked='1', pName='"+pname+"' where Bid='24'";
			da.updateDB(sql52);
			}
        }

		if(ae.getActionCommand()=="LogOut")
		{
			MainFrame f = new MainFrame();
			f.setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getActionCommand()=="Bus Info")
		{
			BusInfoFrame ff = new BusInfoFrame();
			ff.setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getActionCommand()=="Confirm")
		{
			updateData();
			BookedSeatDetails fn= new BookedSeatDetails(pn);
			fn.setVisible(true);
			this.setVisible(false);
		}
		else if(ae.getActionCommand()=="cancel")
		{
			String sql53="update "+s4+" set Booked='0' where pName='"+pname+"'";
			da.updateDB(sql53);
			BusSeatDetails ff = new BusSeatDetails(pn);
			ff.setVisible(true);
			this.setVisible(false);
		}
		if(ae.getActionCommand()=="Exit")
		{
			System.exit(0);	
		}
}

}



	

