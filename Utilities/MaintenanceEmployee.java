package Utilities;

public class MaintenanceEmployee extends Employee
{
	public MaintenanceEmployee(String name)
	{
		super(name);
		System.out.println("He/She is Maintenance Employee");
	}

	boolean workOn(PlaneComponent plcpt)
	{
		String str,toprint;
		str= plcpt.get_description();
		toprint="Maintenance Employee: " + name + " works on " +str;
		System.out.println(toprint);
		this.report();
		return true;
	}

	void report()
	{
		System.out.println("Maintenance OK");
	}

	int employee_type()
	{
		return 1;
	}
}
