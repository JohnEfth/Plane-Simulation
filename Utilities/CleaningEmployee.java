package Utilities;

public class CleaningEmployee extends Employee
{
	public CleaningEmployee(String name)
	{
		super(name);
		System.out.println("He/She is Cleaning Employee");
	}

	boolean workOn(PlaneComponent plcpt)
	{
		String str,toprint;
		str= plcpt.get_description();
		toprint="Cleaning Employee: " + name + " works on " +str;
		System.out.println(toprint);
		this.report();
		return true;
	}

	void report()
	{
		System.out.println("Cleaning OK");
	}

	int employee_type()
	{
		return 2;
	}
}