package Frame.AdminLoginFrame;

import Frame.MainFrame.*;
import Frame.BusInfoFrame.*;
import Frame.AdminFrame.*;
import Frame.BusSeatDetails.*;
import Frame.BookedSeatDetails.*;
import Frame.Login.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AdminLoginFrame extends JFrame implements ActionListener{

  JPanel panel = new JPanel();
  JLabel l1 = new JLabel("password :");
  JTextField t1 = new JTextField(10);
  JButton b1 = new JButton("Login");


  public AdminLoginFrame(){

          panel.setBackground(Color.PINK);
          getContentPane().add(panel);

          panel.add(l1);
          panel.add(t1);
          panel.add(b1);

        //  l1.setBounds(80,100,100,20);
        //  t1.setBounds(200,100,100,20);
        //  b1.setBounds(100,200,100,20);





          b1.addActionListener(this);




          setSize(500,100);
          setLocationRelativeTo(null);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setTitle("PIN NO. VARIFICATION");
          setVisible(true);
          setResizable(false);


}

public void actionPerformed(ActionEvent a){

      if(a.getActionCommand()=="Login"){

          b1.setVisible(false);
          t1.setVisible(false);
          l1.setVisible(false);

          l1.setText("NExt page----->>>");
          l1.setVisible(true);


      }

}



/*

public static void main(String []args){

      new AdminLoginFrame();
*/

}



}
