package person;

import Frame.MainFrame.*;
import Frame.BusInfoFrame.*;
import Frame.AdminFrame.*;
import Frame.BusSeatDetails.*;
import Frame.BookedSeatDetails.*;
import WindowSensor.*;
import DataAccess.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class person
{
	private String name;
	private String phone;
	
	public person(String name, String phone)
	{
		this.name=name;
		this.phone=phone;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return this.name;
	}
	public void setphone(String phone)
	{
		this.phone=phone;
	}
	public String getphone()
	{
		return this.phone;
	}
}