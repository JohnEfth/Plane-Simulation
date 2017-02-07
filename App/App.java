package App;

import java.util.Random;
import java.lang.String;

import Utilities.*;

class App
{
	public static void main(String[] args) 
	{
		boolean ready=true;

        Plane pl = new Plane("Awesome" , "Boeing3000" , 100);
        System.out.format("\n");
        SecurityEmployee secem= new SecurityEmployee("Totos o Fouskotos");
        MaintenanceEmployee mainem= new MaintenanceEmployee("Mitsakos o Idrablikos");
        CleaningEmployee cleanem= new CleaningEmployee("Toula h Katharoula");
		System.out.format("\nSecurity goes to work \n\n");
        pl.process(secem);
        ready= ready & pl.ready_check(secem);
        System.out.format("\nMaintenance goes to work \n\n");
        pl.process(mainem);
        ready= ready & pl.ready_check(mainem);
        System.out.format("\nCleaning goes to work \n\n");
        pl.process(cleanem);
        ready= ready & pl.ready_check(cleanem);

        if(ready == true)
        {
        	System.out.format("\nPlane ready to take off! \n\n");
        }
        else
        {
        	System.out.format("\nNot all neccesary works have been completed to take off \n\n");
        }
    }

}