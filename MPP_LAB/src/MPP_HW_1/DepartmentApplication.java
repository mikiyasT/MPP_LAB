package MPP_HW_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

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
	      
	      johnDoe.addCourse(cs201);
	      johnDoe.addCourse(cs360);
	      johnDoe.addCourse(cs404);
	      johnDoe.addCourse(cs301);
	      
	      maryJones.addCourse(cs201);
	      maryJones.addCourse(cs404);
	      maryJones.addCourse(cs450);
	      
	      leeJohnson.addCourse(cs201);
	      leeJohnson.addCourse(cs360);
	      leeJohnson.addCourse(cs240);
	      leeJohnson.addCourse(cs450);
	      
	      
	      
	      
	      double totsalary = 0;

	      while(true)
	         {
	         putText("Enter first letter of ");
	         putText("getTotalSalary, showAllMembers, unitsPerFaculty , nameAfaculty or quit : ");
	         int choice = getChar();
	         switch(choice)
	            {
	            case 'g':
	               totsalary=dept.getTotalSalary();
	               putText("Total sum of all salaries is:");
	               putText("$ " + String.valueOf(totsalary)+" USD \n");              
	               break;
	            case 's':
	               dept.showAllMembers();
	               break;
	            case 'u':
	               dept.unitsPerFaculty();
	               break;
	            case 'n':
	            	   putText("Enter Name of a faculty ");
	            	   String Name = getString();
	            	   listStudentsTakingCourseByFaculty(Name,dept);
		              
		               break;
	            case 'q': return;
	            default:
	               putText("Invalid entry\n");
	            }  // end switch
	         }  // end while  

	}

	private static void listStudentsTakingCourseByFaculty(String name, Department dept) {
	      
		ArrayList<Person> person_in_cs_dept = dept.getPersonList();
	      Student s = null;
	      Faculty f = null;
	      ArrayList<Course> course_learned = null;
	      ArrayList<Course> course_taught = null;
	      //get the faculty information for the given name
	      for(Person p : person_in_cs_dept)
	      {
	    	  
	    	  if(p instanceof Faculty)
	    	  {
	    		  f = (Faculty)p;
	    		  if(name.equals(f.getName())){
	    			  course_taught = f.getTeachingCourses();
	    			  break;
	    		  }
	    	  }   
	    	  
	      }
	      
	 	 System.out.println("List of students taking course given by faculty " + f.getName());
	      for(Person p : person_in_cs_dept){
	    	  if(p instanceof Student)
	    	  {
	    		 s = (Student)p;
	    		 course_learned = s.getTakingCourses();
	    	   	 Iterator it = course_learned.iterator();
	    	
	    	   
	    	   	 while(it.hasNext()){
	    	   		 Course course = (Course)it.next();
	    	   		 String course_number = course.getNumber();
	    	   		 if(course_taught.contains(course)){
	    	   			 System.out.println(" Student : " + s.getName() + " , Course Num :" + course_number);
	    	   		 }
	    	   	 }
	    	  }
	    	  
	      }
		
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
