package Lab3_HumanResource;

public class CompanyApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Company  samsung = new Company("SAMSUNG",null); 
		Department visualComputing = new Department("Visual Computing","Korea",null);
		Department voiceReogntition = new Department("Voice Recognition","Isreal",null);
		
		samsung.addDepartment(visualComputing);
		samsung.addDepartment(voiceReogntition);
		
		Position VP1 = new Position("Vice Presidnet  1", "Vision Leading and directional decisions", null);
		Position VP2 = new Position("Vice Presidnet 2", "Voice Leading and directional decisions", null);
		Position engineer = new Position("Engineer", "Engineering related works", null);
		Position designer = new Position("Designer", "Designing related works", null);
		Position analyst = new Position("Analyst", "Anaysis related works", null);
		Position HR = new Position("HumanResource", "HR related works", null);
		Position marketer = new Position("Marketer", "Marketing related works", null);
		Position purchaser = new Position("Purchaser", "Purchasing related works", null);
		Position tester = new Position("Tester", "Test related works", null);
		
		
		Employee miki = new Employee("Mikiyas", "M", "Workenehe", "1982","468-D-23",5500, null);
		Employee kim = new Employee("Kim", "Y", "Peter", "1982","987-D-23",7000, null);
		Employee longman = new Employee("Longman", "R", "Adolf", "1970","567-D-23",4500, null);
		Employee tiana = new Employee("Tiana", "K", "Jeferry", "1967","789-D-23",5000, null);
		Employee drew = new Employee("Drew", "B", "More", "1975","321-D-23",9000, null);
		
		
		
		visualComputing.addPosition(VP1);
		visualComputing.addPosition(engineer);
		visualComputing.addPosition(analyst);
		visualComputing.addPosition(tester);
		visualComputing.addPosition(HR);
		
		visualComputing.addPosition(VP2);
		voiceReogntition.addPosition(marketer);
		voiceReogntition.addPosition(designer);
		voiceReogntition.addPosition(purchaser);
		
		VP1.addInferior(engineer);
		VP1.addInferior(marketer);
		
		engineer.addInferior(analyst);
		engineer.addInferior(tester);
		
		analyst.addInferior(HR);
		
		VP2.addInferior(marketer);
		marketer.addInferior(designer);
		marketer.addInferior(purchaser);
		
		engineer.setEmployee(miki);
		analyst.setEmployee(kim);
		
		marketer.setEmployee(drew);
		purchaser.setEmployee(tiana);
		
		samsung.print();
		samsung.getSalary();
		
		//System.out.println(VP1 + " Manages the following Positions: ");
		VP1.printDownLine("");
		System.out.println("--- Departmental reporting hierarchy for " + visualComputing.getName());
		visualComputing.printReportingHierarchy();
//		System.out.println("Departmental reporting hierarchy for " + voiceReogntition.getName());
//		voiceReogntition.printReportingHierarchy();
		
		
		
		
		

	}

}
