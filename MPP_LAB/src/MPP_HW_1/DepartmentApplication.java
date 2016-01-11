package MPP_HW_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DepartmentApplication {

	public static void main(String[] args) throws IOException {
		  System.out.println("Eclipse system test ");
	      Department dept = new Department("ComputerScience");
	      
	      Faculty frankMoore = new Faculty("Frank Moore","472-5921",43,10000);	
	      Faculty samHoward = new Faculty("Sam Howard","472-7222",55,9500);
	      Faculty johnDoodle = new Faculty("John Doodle","472-6190",39,8600);
	      
	      dept.addPerson(frankMoore);
		  dept.addPerson(samHoward);
		  dept.addPerson(johnDoodle);

	      
	      Student johnDoe = new Student("John Doe","472-1121",22,4.0);
	      Student maryJones = new Student("Mary Jones","472-7322",32,3.80);
	      Student leeJohnson = new Student("Lee Johnson","472-6009",19,3.65);
	      
	      dept.addPerson(johnDoe);
		  dept.addPerson(maryJones);
		  dept.addPerson(leeJohnson);

	      
	      Staff frankGore = new Staff("Frank Gore","472-3321",33,4050);
	      Staff adamDavis = new Staff("Adam Davis","472-7552",50,5500);
	      Staff davidHeck = new Staff("David Heck","472-8890",29,3600);
	      
	      dept.addPerson(frankGore);
		  dept.addPerson(adamDavis);
		  dept.addPerson(davidHeck);

	      
	      Course cs201 = new Course("cs201","programming",4, johnDoodle);
	      Course cs360 = new Course("cs360","database",3, samHoward);
	      Course cs404 = new Course("cs404","compiler",4, johnDoodle);
	      Course cs240 = new Course("cs240","datastructure",2, johnDoodle);
	      Course cs301 = new Course("cs301","Software engg",3, samHoward);
	      Course cs450 = new Course("cs450","Advanced architecture",5,frankMoore);
	      
	      
	      double totsalary = 0;

	      while(true)
	         {
	         putText("Enter first letter of ");
	         putText("getTotalSalary, showAllMembers, unitsPerFaculty or quit : ");
	         int choice = getChar();
	         switch(choice)
	            {
	            case 'g':
	               totsalary=dept.getTotalSalary();
	               putText("Total sum of all salaries is:");
	               putText(String.valueOf(totsalary)+"\n");              
	               break;
	            case 's':
	               dept.showAllMembers();
	               break;
	            case 'u':
	               dept.unitsPerFaculty();
	               break;
	            case 'q': return;
	            default:
	               putText("Invalid entry\n");
	            }  // end switch
	         }  // end while  

	}

	private static char getChar() throws IOException {
		String s = getString();
	      return s.charAt(0);

	}

	private static String getString() throws IOException {
		 	BufferedReader isr = new BufferedReader(new InputStreamReader(System.in));
			String s = isr.readLine();
			return s;
	}

	private static void putText(String string) {
		System.out.println(string);
		
	}

}
