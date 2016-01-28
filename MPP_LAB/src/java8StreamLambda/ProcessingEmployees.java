package java8StreamLambda;

//Program 4: Employee.java
//Employee class.

//Program 4: ProcessingEmployees.java
//Processing streams of Employee objects.
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


class Employee
{
private String firstName;
private String lastName;
private double salary; 
private String department;

// constructor 
public Employee(String firstName, String lastName, 
   double salary, String department)
{
   this.firstName = firstName;
   this.lastName = lastName;
   this.salary = salary;
   this.department = department;
} 

// set firstName
public void setFirstName(String firstName)
{
   this.firstName = firstName;
}

// get firstName
public String getFirstName()
{
   return firstName;
}

// set lastName
public void setLastName(String lastName)
{
   this.lastName = lastName;
}

// get lastName
public String getLastName()
{
   return lastName;
}

// set salary
public void setSalary(double salary)
{
   this.salary = salary;
}

// get salary
public double getSalary()
{
   return salary;
}

// set department
public void setDepartment(String department)
{
   this.department = department;
}

// get department
public String getDepartment()
{
   return department;
}

// return Employee's first and last name combined
public String getName()
{
   return String.format("%s %s", getFirstName(), getLastName());
}

// return a String containing the Employee's information
@Override
public String toString() 
{
   return String.format("%-8s %-8s %8.2f   %s", 
      getFirstName(), getLastName(), getSalary(), getDepartment());
} // end method toString
} // end class Employee



public class ProcessingEmployees
{
public static void main(String[] args)
{
   // initialize array of Employees
   Employee[] employees = {
      new Employee("Jason", "Red", 5000, "IT"),
      new Employee("Ashley", "Green", 7600, "IT"),
      new Employee("Matthew", "Indigo", 3587.5, "Sales"),
      new Employee("James", "Indigo", 4700.77, "Marketing"),
      new Employee("Adams", "Bobi", 4700.77, "Marketing"),
      new Employee("Luke", "Indigo", 6200, "IT"),
      new Employee("Jason", "Blue", 3200, "Sales"),
      new Employee("Wendy", "Brown", 4236.4, "Marketing"),
      new Employee("Brooks", "Inreque", 4236.4, "Marketing")};

   // get List view of the Employees
   List<Employee> list = Arrays.asList(employees);

   // display all Employees
   System.out.println("Complete Employee list:");
   list.stream().forEach(System.out::println);
   
   //count last names that begin with B
   System.out.println("Counting number of employees whose last name begins with B");
   Predicate<Employee> beginsWithB = e->(e.getLastName().startsWith("B") || e.getLastName().startsWith("b"));
   
   Comparator<Employee> SortbyLastName = Comparator.comparing(Employee::getLastName);
   System.out.println("There are " + list.stream().filter(beginsWithB).count()
		+ " Employees whose name begins with letter B");
   list.stream().filter(beginsWithB).sorted(SortbyLastName).forEach(System.out::println);
   String sr = "miki";
   //sr.toUpperCase()
   
   System.out.println("All employee whose last name begins with B capitalized ");
   Function<Employee,String> toUpperCase = e->( e.getFirstName().toUpperCase() +" "+ e.getLastName().toUpperCase());
   list.stream().filter(beginsWithB).map(toUpperCase).forEach(System.out::println);
   
   System.out.println();
   System.out.println("All employees and those whose last name begins with B capitalized ");
   
   Function<Employee,String> toUpperCaseifB = e->( (e.getLastName().startsWith("B") || e.getLastName().startsWith("b"))
		   											? 
		   											( e.getFirstName().toUpperCase() +" "+ e.getLastName().toUpperCase())
		   											: 
		   											(e.getFirstName() +" "+ e.getLastName())
   												  	
   												);
   list.stream().map(toUpperCaseifB).forEach(System.out::println);
   
   //
   System.out.println("All employee whose names begine with I , sorted and no uplicates");
   Predicate<Employee> beginsWihtI = e->(e.getLastName().startsWith("i") || e.getLastName().startsWith("I"));
   
   list.stream()
   .filter(beginsWihtI)
   .sorted(Comparator.comparing(Employee::getLastName))
   .map(Employee::getLastName)
   .distinct()  
   .forEach(System.out::println);
   
   System.out.format("Average of all salaries %,.2f: ", 
   list.stream()
   .mapToDouble(Employee::getSalary)
   .average()
   .getAsDouble());
   
   System.out.format("\nSum of all salaries of employees %,.2f \n",
		   list.stream().mapToDouble(Employee::getSalary).reduce(0,(v1,v2)-> v1 +v2));
   
   System.out.println("Only first names of all Employees ");
   list.stream().map(Employee::getFirstName).forEach(System.out::println);
   
   System.out.println("Stream generating sequence of even numbers");
   Stream<Integer> stream_of_evens = Stream.iterate(0,n-> n + 2).limit(20);
   stream_of_evens.forEach(System.out::println);
   
   //----------------------------------------------------------
// group Employees by department
// System.out.printf("%nEmployees by department:%n"); 
// Map<String, List<Employee>> groupedByDepartment =
//    list.stream()
//        .collect(Collectors.groupingBy(Employee::getDepartment));
// groupedByDepartment.forEach(
//    (department, employeesInDepartment) -> 
//    {
//       System.out.println(department);
//       employeesInDepartment.forEach(
//          employee -> System.out.printf("   %s%n", employee));
//    }
// );
//
// 
// // count number of Employees in each department
// System.out.printf("%nCount of Employees by department:%n"); 
// Map<String, Long> employeeCountByDepartment =
//    list.stream()
//        .collect(Collectors.groupingBy(Employee::getDepartment, 
//           TreeMap::new, Collectors.counting()));
// employeeCountByDepartment.forEach(
//    (department, count) -> System.out.printf(
//       "%s has %d employee(s)%n", department, count));
 //------------------------- *******
   
   
   
   
} // end main
} // end class ProcessingEmployees

