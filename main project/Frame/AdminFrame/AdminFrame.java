/*
package Frame.AdminFrame;

import Frame.MainFrame.*;
import Frame.BusInfoFrame.*;
import Frame.BusSeatDetails.*;
import Frame.BookedSeatDetails.*;
import Frame.Login.CustomerLoginFrame.*;
import WindowSensor.*;
import DataAccess.*;
import person.*;
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AdminFrame extends JFrame implements ActionListener{


      JPanel panel = new JPanel();
      JButton b1 = new JButton("Read Map");
      JButton b2 = new JButton("Go To Previos Page");
      JButton b3 = new JButton("Exit");
      JLabel lb = new JLabel("MAP Reading successfully done!!");


      JLabel l1 = new JLabel("NAME");
      JLabel l2 = new JLabel("MOBILE");
      JLabel l3 = new JLabel("SEAT SELECTED");
      JLabel l4 = new JLabel("DEPARTURE TIME");
      JLabel l5 = new JLabel("SOURCE");
      JLabel l6 = new JLabel("DESTINATION");
      JLabel l7 = new JLabel("TIME OF JOURNEY(hrs,mins)");

      JLabel img = new JLabel();
      ImageIcon iconLogo = new ImageIcon("/Users/Ruhi/Desktop/ImgForJava/9iRRMGy4T.png");
      String []location = {"MIRPUR","UTTARA","BONANI","BAILY ROAD","SHANTIBAG","MOTIJHIL","MOHAKHALI","MOGBAZAR"};
      JRadioButton am= new JRadioButton("am");
      JRadioButton pm= new JRadioButton("pm");

      ButtonGroup bg1 = new ButtonGroup();
      ButtonGroup bg2 = new ButtonGroup();

      JTextField t1 = new JTextField(20);
      JTextField t2 = new JTextField(20);
      JTextField t3 = new JTextField(20);
      JTextField t4 = new JTextField(20);
      JComboBox <String> box1 = new JComboBox<>(location);
      JComboBox <String> box2 = new JComboBox<>(location);
      JTextField t7 = new JTextField(3);
      JTextField t8 = new JTextField(3);




      public AdminFrame(){

      panel.setBackground(Color.PINK);
      getContentPane().add(panel);



      l1.setBounds(80,100,100,20);
      l2.setBounds(80,150,100,20);
      l3.setBounds(80,200,100,20);
      l4.setBounds(80,250,200,20);

      l5.setBounds(80,300,100,20);
      l6.setBounds(80,350,200,20);
      l7.setBounds(80,400,300,20);

      lb.setBounds(260,200,300,20);
      img.setBounds(350,200,100,100);




      t1.setBounds(300,100,300,20);
      t2.setBounds(300,150,300,20);
      t3.setBounds(300,200,300,20);
      t4.setBounds(300,250,300,20);
      am.setBounds(600,250,70,20);
      pm.setBounds(650,250,70,20);

      bg1.add(am);
      bg1.add(pm);


      box1.setBounds(300,300,250,20);
      box2.setBounds(300,350,250,20);
      t7.setBounds(300,400,50,20);
      t8.setBounds(350,400,50,20);



    //  mins.setBounds(600,400,70,20);
      //hrs.setBounds(650,400,70,20);

    //  bg2.add(mins);
    //  bg2.add(hrs);

      b1.setBounds(250,460,200,50);
      b2.setBounds(260,300,200,40);
      b3.setBounds(260,360,200,40);

      //img.setIcon(new ImageIcon("Users\\Ruhi\\ImgForJava\\9iRRMGy4T.png"));


      panel.add(l1);
      panel.add(t1);

      panel.add(l2);
      panel.add(t2);

      panel.add(l3);
      panel.add(t3);

      panel.add(l4);
      panel.add(t4);

      panel.add(l5);
      panel.add(box1);

      panel.add(l6);
      panel.add(box2);

      panel.add(l7);
      panel.add(t7);

      panel.add(am);
      panel.add(pm);
      panel.add(t8);
    //  panel.add(hrs);

      panel.add(b1);
      panel.add(b2);
      panel.add(b3);

      panel.add(lb);
      panel.add(img);

          lb.setVisible(false);
          b2.setVisible(false);
          b3.setVisible(false);
          panel.setLayout(null);

          setSize(800,600);
          setLocationRelativeTo(null);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setTitle("AdminFrame");
          setVisible(true);
          setResizable(false);

          b1.addActionListener(this);
          panel.validate();
        }



public void actionPerformed(ActionEvent a){
  if(a.getActionCommand()=="Read Map"){

                  b1.setVisible(false);

                  l1.setVisible(false);
                  l2.setVisible(false);
                  l3.setVisible(false);
                  l4.setVisible(false);
                  l5.setVisible(false);
                  l6.setVisible(false);
                  l7.setVisible(false);


                  t1.setVisible(false);
                  t2.setVisible(false);
                  t3.setVisible(false);
                  t4.setVisible(false);
                  box1.setVisible(false);
                  box2.setVisible(false);
                  t7.setVisible(false);
                  am.setVisible(false);
                  pm.setVisible(false);
                //  mins.setVisible(false);
                  t8.setVisible(false);


                  lb.setVisible(true);
                  b2.setVisible(true);
                  b3.setVisible(true);

                  img.setIcon(iconLogo);
                  b2.addActionListener(this);
                  b3.addActionListener(this);



          }

           else if(a.getActionCommand()=="Go To Previos Page"){
                new  AdminFrame();

           }

          else if(a.getActionCommand()=="Exit"){
            System.exit(0);

           }
         }

public static void main(String []args){
              new  AdminFrame();
  }
}
