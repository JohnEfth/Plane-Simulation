package Utilities;

class CargoBay extends PrivateCompartment
{
	EquipmentCompartment equicom;

	CargoBay(String description)
	{
		super(description);

		equicom= new EquipmentCompartment("Equipment inside Cargo Bay");
	}

	void process(Employee empl)
	{
		int emtype;
		empl.workOn(this);
		System.out.format("%s Compartment OK!\n",description);
		emtype=empl.employee_type();

		ready_check=true;
		if(emtype != 2)
		{
			equicom.process(empl);
		}
	}
	boolean ready_check(Employee empl)
	{	
		boolean ready=ready_check;
		int emtype;
		emtype=empl.employee_type();

		if(emtype != 2)
		{
			ready= ready & equicom.ready_check(empl);
		}

		ready_check=false;  // I set it false for the next Employee
		return ready;
	}
}