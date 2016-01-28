package FirstLabWithLambda;


public class Course {
	private String Number;
	private String Title;
	private int Units;
	//private Faculty F;
	
	Course(String number,String title,int units, Faculty f){
		Number = number;
		Title = title;
		Units = units;
		f.addCourse(this);
	}
	public String getNumber() {
		return Number;
	}
	public void setNumber(String number) {
		Number = number;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public int getUnits() {
		return Units;
	}
	public void setUnits(int units) {
		Units = units;
	}
}
