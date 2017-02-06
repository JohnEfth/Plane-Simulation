package Utilities;

class EquipmentCompartment extends PrivateCompartment  
{
	EquipmentCompartment(String description)
	{
		super(description);
	}

	void process(Employee empl)
	{
		empl.workOn(this);

		System.out.format("%s Compartment OK!\n",description);
		ready_check=true;
	}
	boolean ready_check(Employee empl)
	{	
		boolean ready=ready_check;

		ready_check=false;  // I set it false for the next Employee
		return ready;
	}
}