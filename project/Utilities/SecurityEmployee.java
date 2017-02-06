package Utilities;

public class SecurityEmployee extends Employee
{
	public SecurityEmployee(String name)
	{
		super(name);
		System.out.println("He/She is Security Employee");
	}

	boolean workOn(PlaneComponent plcpt)
	{
		String str,toprint;
		str= plcpt.get_description();
		toprint="Security Employee: " + name + " works on " +str;
		System.out.println(toprint);
		this.report();
		return true;
	}

	void report()
	{
		System.out.println("Security OK");
	}

	int employee_type()
	{
		return 0;
	}
}
