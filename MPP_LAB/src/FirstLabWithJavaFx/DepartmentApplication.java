package FirstLabWithJavaFx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;    

public class DepartmentApplication extends Application /*implements EventHandler*/{

	private MenuItem menu_item_members;
	
	private static Department dept = null;
	
	
	public static void main(String[] args) throws IOException {
		
		  System.out.println("Eclipse system test ");
	      dept = new Department("ComputerScience");
	      
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
	      
	      StaffStudent shankar = new StaffStudent("Shankar", "5354", 23, 4, 7000);
	  	  shankar.addCourse(cs201);
	  	  shankar.addCourse(cs360);
	  	  dept.addPerson(shankar);
	      
	      
	      
	      double totsalary = 0;

//	      while(true)
//	      {
//	         putText("Enter first letter of ");
//	         putText("getTotalSalary, showAllMembers, unitsPerFaculty , nameAfaculty or quit : ");
//	         int choice = getChar();
//	         switch(choice)
//	            {
//	            case 'g':
//	               totsalary=dept.getTotalSalary();
//	               putText("Total sum of all salaries is:");
//	               //putText("$ " + String.valueOf(totsalary)+" USD \n");  
//	               System.out.format("$ %,.2f USD \n",totsalary);
//	               break;
//	            case 's':
//	               dept.showAllMembers();
//	               break;
//	            case 'u':
//	               dept.unitsPerFaculty();
//	               break;
//	            case 'n':
//	            	   putText("Enter Name of a faculty from our faculty list : ");
//	            	   listAllFaculty(dept);
//	            	   String Name = getString();
//	            	   listStudentsTakingCourseByFaculty(Name,dept);
//		              
//		               break;
//	            case 'q': return;
//	            default:
//	               putText("Invalid entry\n");
//	            }  // end switch
//	         }  // end while  
	      
	      launch(args);
	}
	
	
	private static void listAllFaculty(Department dept) {
		ArrayList<Person> person_in_cs_dept = dept.getPersonList();
	      Faculty f = null;
	     
	      //get the faculty information for the given name
	      for(Person p : person_in_cs_dept)
	      {
	    	  
	    	  if(p instanceof Faculty)
	    	  {
	    		  f = (Faculty)p;
	    		  System.out.println(" -> " + f.getName());
	    	  }   
	    	  
	      }
		
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

	@Override
	public void start(Stage stage) throws Exception {
		Group root = new Group();
	    Scene scene = new Scene(root, 400, 250, Color.WHITE);
 		stage.setTitle("My School System");
		GridPane main_grid = new GridPane();
		root.getChildren().add(main_grid);
		main_grid.setAlignment(Pos.CENTER);
		Label lblTitle= new Label("SCHOOL CONTROL SYSTEM");
		main_grid.setVgap(10);
		main_grid.setHgap(10);
		main_grid.add(lblTitle,2,2);
		//add "Add person" menu
		MenuBar add_menuBar = new MenuBar();
		//handle the event ..here
		Menu menu_addPerson = new Menu("Add Person");
		Menu menu_showInformation = new Menu("Information");
		Menu menu_showRegistrar = new Menu("Registrar");
		Menu menu_showHelp = new Menu("Help");
		
		MenuItem menu_item_fac = new MenuItem("Faculty");
		MenuItem menu_item_staff = new MenuItem("Staff");
		MenuItem menu_item_student = new MenuItem("Student");
		
		menu_addPerson.getItems().add(menu_item_fac);
		menu_addPerson.getItems().add(menu_item_staff);
		menu_addPerson.getItems().add(menu_item_student);
		
		MenuItem menu_item_sal = new MenuItem("Total Salary");
		MenuItem menu_item_members = new MenuItem("Show All Memebers");
		MenuItem menu_item_unitsPerFac = new MenuItem("Units Per Faculty");
		MenuItem menu_item_studentUnderFac = new MenuItem("Students taking course for faculty");
		
		menu_showInformation.getItems().add(menu_item_sal);
		menu_showInformation.getItems().add(menu_item_members);
		menu_showInformation.getItems().add(menu_item_unitsPerFac);
		menu_showInformation.getItems().add(menu_item_studentUnderFac);
		
		
		add_menuBar.getMenus().add(menu_addPerson);
		add_menuBar.getMenus().add(menu_showInformation);
		add_menuBar.getMenus().add(menu_showRegistrar);
		add_menuBar.getMenus().add(menu_showHelp);
		
		menu_item_members.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				ListView<String> list = new ListView<String>();
				ObservableList<String> members = FXCollections.observableArrayList();
				Label selected = new Label();
				selected.setLayoutX(10);
				selected.setLayoutY(115);
				selected.setFont(Font.font("Verdana", 20));
				
				System.out.println("Listing all members");
				
				ArrayList<Person> plist = dept.getPersonList();
				for(Person p : plist)
				members.add(p.toString());
				
				list.setItems(members);
				main_grid.add(list,3,3);
				main_grid.add(selected,4,3);			
				
			}
		});
		
		BorderPane borderPane = new BorderPane();
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());
        borderPane.setTop(add_menuBar);
        
		root.getChildren().add(borderPane);
		
	   // root.getChildren().add(list);
		stage.setScene(scene);
		
		stage.show();
		
	}
	static class ColorRectCell extends ListCell<String> {
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            Rectangle rect = new Rectangle(100, 20);
            if (item != null) {
                //rect.setFill(Color.GREEN);
                setGraphic(rect);
            }
        }
    }

}
