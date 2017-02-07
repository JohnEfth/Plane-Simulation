package Utilities;

import java.util.Random;
import java.lang.String;

public class Plane               
{
	String description;
	String title;
	int capacity;

	CargoBay cb;
	EquipmentCompartment[] ec;   // 3
	PassengerCompartment[] pc;		// random

	public Plane(String descr, String ttl , int cap)
	{
		description=descr;
		title=ttl;
		capacity=cap;
		String str;
		int j;

		Random rand = new Random();

		int r = rand.nextInt(capacity) + 1;    // array.length to get array's length

		ec = new EquipmentCompartment[3];
		pc = new PassengerCompartment[r];

		for(j=0; j<3; j++)
		{
			str="Place No.";
			String numberAsString = Integer.toString(j+1);
			str = str + numberAsString;
			str = str + " for Equips";
			ec[j]= new EquipmentCompartment(str);
		}

		System.out.format("\n");

		for(j=0; j<r; j++)
		{
			str="Passengers Space No.";
			String numberAsString = Integer.toString(j+1);
			str = str + numberAsString;
			pc[j]= new PassengerCompartment(str);
		}

		System.out.format("\n");

		cb = new CargoBay("Our Cargos Bay");


		System.out.println("Constructing a Plane that is: "+description+" titled: "+title+" capacity: " +capacity);
	}

	public String get_description(){return description;}
	public String get_title(){return title;}
	public int get_capacity(){return capacity;}

	public CargoBay get_cargobay(){return cb;}
	public EquipmentCompartment get_equipment(int i)
	{
		if ((i < 3 ) && (0 <= i) ) 
		{
			return ec[i];
		}
		else
		{
			System.out.println("Sorry no such Equipment Compartment exists");
			return null;
		}
	}

	public PassengerCompartment get_passengersComp(int i)
	{
		if ((i < pc.length ) && (0 <= i) ) 
		{
			return pc[i];
		}
		else
		{
			System.out.println("Sorry no such Passengers Compartment exists");
			return null;
		}
	}

	public boolean ready_check(Employee empl)
	{	
		boolean ready=true;
		int emtype,j;
		emtype=empl.employee_type();

		if(emtype == 0)
		{
			ready= ready & cb.ready_check(empl);

			for(j=0; j<3; j++)
			{
				ready= ready & ec[j].ready_check(empl);
			}

			for(j=0; j<pc.length; j++)
			{
				ready= ready & pc[j].ready_check(empl);
			}
			return ready;
		}
		else if(emtype == 1)
		{
			ready= ready & cb.ready_check(empl);

			for(j=0; j<3; j++)
			{
				ready= ready & ec[j].ready_check(empl);
			}
			return ready;
		}
		else if(emtype == 2)
		{
			ready= ready & cb.ready_check(empl);

			for(j=0; j<pc.length; j++)
			{
				ready= ready & pc[j].ready_check(empl);
			}
			return ready;
		}
		return false;
	}

	public void process(Employee empl)  
	{	
		int j;
		int emtype;
		emtype=empl.employee_type();

		if (emtype == 0)
		{	
			cb.process(empl);

			for(j=0; j<3; j++)
			{
				ec[j].process(empl);
			}

			for(j=0; j<pc.length; j++)
			{
				pc[j].process(empl);
			}
		}
		else if(emtype == 1)
		{
			cb.process(empl);

			for(j=0; j<3; j++)
			{
				ec[j].process(empl);
			}
		}
		else if(emtype == 2)
		{
			cb.process(empl);

			for(j=0; j<pc.length; j++)
			{
				pc[j].process(empl);
			}
		}
	}
}

abstract class PlaneComponent
{
	String description;
	boolean ready_check = false;

	PlaneComponent(String descr)
	{
		description=descr;
		System.out.println("A Plane Compartment is Constructed: "+description);
	}

	String get_description()
	{
		return description;
	}

	abstract void process(Employee empl); // Employe was here
	abstract boolean ready_check(Employee empl);

}

abstract class PrivateCompartment extends PlaneComponent   // since it doesn't have any operations or dynamic members I make it Interface
{
	PrivateCompartment(String description)
	{
		super(description);
	}
	abstract void process(Employee empl); // Employee was here
	abstract boolean ready_check(Employee empl);
}

abstract class Employee
{
	String name;

	Employee(String nam)
	{
		name=nam;
		String str= "Employee: " + nam + " is available for work";
		System.out.println(str);
	}

	abstract boolean workOn (PlaneComponent plcpt);

	abstract void report();

	abstract int employee_type();
}




