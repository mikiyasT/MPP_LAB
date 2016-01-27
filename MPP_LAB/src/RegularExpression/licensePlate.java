package RegularExpression;

import javax.swing.JOptionPane;

public class licensePlate {
	private static String VALID = "VALID PLATE NUMBER";
	private static String LICENSE_PLATE_PATTERN = "[a-zA-Z]{2}\\d{4}[a-zA-Z]{4}";
	private static String INVALID = "INVALID PLATE NUMBER";
	public static void main(String args[]){
		do {
			String str = JOptionPane.showInputDialog(null, "Plate Number");
			if (str.matches(LICENSE_PLATE_PATTERN)) {
				String newstr = str.replaceAll("8", "EIGHT");
				
				JOptionPane.showMessageDialog(null, newstr + ":\n" + VALID);
			}
			else{
				JOptionPane.showMessageDialog(null, str + ":\n" + INVALID);
			}
			
		} while (true);
	}

}
