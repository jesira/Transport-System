package WindowSensor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import WindowSensor.*;
import DataAccess.*;
import person.*;
import Frame.PinNoVarification.*;
import Frame.SubMission.*;
import Frame.AdminFrame.AdminFrameP.*;

import Frame.MainFrame.*;
import Frame.BusInfoFrame.*;
import Frame.AdminFrame.*;
import Frame.BusSeatDetails.*;
import Frame.BookedSeatDetails.*;
import Frame.Login.CustomerLoginFrame.*;



public class WindowSensor extends WindowAdapter
{
	public void windowClosing(WindowEvent we){
		System.out.println("Window close.");
		System.exit(0);
	}
}	
	