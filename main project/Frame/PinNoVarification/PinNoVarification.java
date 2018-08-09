package Frame.PinNoVarification;

import Frame.MainFrame.*;
import Frame.BusInfoFrame.*;
import Frame.AdminFrame.*;
import Frame.BusSeatDetails.*;
import Frame.Login.CustomerLoginFrame.*;
import WindowSensor.*;
import DataAccess.*;
import person.*;
import Frame.SubMission.*;
import Frame.AdminFrame.AdminFrameP.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class PinNoVarification extends JFrame implements ActionListener{

  JPanel panel = new JPanel();
  JTextField t1 = new JTextField();
  JButton button = new JButton("send");
  JLabel lbl = new JLabel("PIN NO. SENT TO THE SERVER");
	
	person pn;

  public PinNoVarification(person p){

          panel.setBackground(Color.PINK);
          getContentPane().add(panel);
          t1.setPreferredSize(new Dimension(200,20));
		  
		  pn=p;
		  
          panel.add(t1);
          panel.add(button);

          button.addActionListener(this);
          panel.add(lbl);

          lbl.setVisible(false);

          setSize(500,100);
          setLocationRelativeTo(null);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setTitle("PIN NO. VARIFICATION");
          setVisible(true);
          setResizable(false);


}

public void actionPerformed(ActionEvent a){

      if(a.getActionCommand()=="send"){

		if(t1.getText().equals("123"))
		{
			SubMission s = new SubMission(pn);
			this.setVisible(false);
		}
		else
		{
			JOptionPane.showMessageDialog(this,"Pin doesn't match,try again !");
		}
	  
      }

}

}
