package FirstLabWithLambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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

	      //create a big array list of person type containing all the faculty,staff and students
		  
		  Person[] all_person_array = {	frankMoore,samHoward,johnDoodle,
				  				 		johnDoe,maryJones,leeJohnson,
				  				 		frankGore,adamDavis,davidHeck
				  				 	  };
		  
		  List<Person> all_person_list = Arrays.asList(all_person_array);

		  
		  Predicate<Person> staffOrFaculty = p->((p instanceof Faculty) || (p instanceof Staff));
		  System.out.format(" *** All Person salary is $%,.2f \n ", 
				  all_person_list.stream()
		  .mapToDouble(Person::getSalary)
		  .sum());
		  
		  
		  System.out.println("Displaying all the person list in the school");
	      
		  all_person_list.stream().forEach(System.out::println);
		  
		 
		  
		  
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
	      
	      
	      Faculty[] all_faculty_array = {frankMoore,samHoward,johnDoodle};		  
		  List<Faculty> all_faculty_list = Arrays.asList(all_faculty_array);
		 
		  System.out.println("Total Units Per faculty  grouping ");
		  Map<String,List<Faculty>> groupByFaculty = all_faculty_list.stream()	
				  									.collect(Collectors.groupingBy(Faculty::getName));
		  groupByFaculty.forEach(
				  (fac,faclist)->
				  {
					  System.out.println(fac);
					  System.out.format(" -> Total Units given : %d \n ",
					  faclist.stream().mapToInt(Faculty::getTotalUnits).sum());
					  System.out.println("------------------------");
					  faclist.stream().mapToInt(Faculty::getTotalUnits).forEach(System.out::println);
				  }
				);
		  
	      
		  System.out.println("Total Units Per faculty with out grouping ");
//		  all_faculty_list.stream().forEach(
//				  (F -> { System.out.println("-> " + F.getName());
//				  		  System.out.println("\t" + F.getTotalUnits());
//						  })
//				  );
		  
		  all_faculty_list.forEach(
				  (F -> {
					  	  System.out.println("-> " + F.getName());
				  		  System.out.println("\t" + F.getTotalUnits());
						 })
				  );
	      
	     System.out.println("Students grouped by course ");
	     Student[] student_array = {johnDoe,maryJones,leeJohnson};
	     List<Student> studnet_list = Arrays.asList(student_array);
	     
	     String str;
	     //Predicate<Student,Course> studentTakingCourse = s ->(e.getTakingCourses().contains(c));
	     
	    studnet_list.stream()
	      .flatMap(student->student.getTakingCourses().stream())
	      .distinct()
	      .forEach(System.out::println);
	}
}
