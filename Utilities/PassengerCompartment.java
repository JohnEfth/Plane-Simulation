package Utilities;

import java.util.Random;

class PassengerCompartment extends PlaneComponent
{
	PassengerCompartment included=null;


	PassengerCompartment()
	{
		super("Insider of Passengers' space");
		Random rand = new Random();
		int r = rand.nextInt(2);

		if(r == 1)			// it is random of how many included Passgers' Compartments will be created
		{
			included= new PassengerCompartment();
		}
	}

	PassengerCompartment(String description)
	{
		super(description);   // constracting the parent class
		Random rand = new Random();

		int r = rand.nextInt(2);

		if(r == 1)			// it is random of how many included Passgers' Compartments will be created
		{
			included= new PassengerCompartment();
		}
	}

	void process(Employee empl)   
	{                   
		empl.workOn(this);       // Call the employee to work on this Compartment

		System.out.format("%s Compartment OK!\n",description);

		ready_check=true;

		if(included != null )
		{
			included.process(empl);
		}		 
	}

	boolean ready_check(Employee empl)
	{	
		boolean ready=ready_check;

		if(included != null )
		{
			ready= ready & included.ready_check(empl);
		}
		ready_check=false;   // I set it false for the next Employee
		return ready;
	}
}