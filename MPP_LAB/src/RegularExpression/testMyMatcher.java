package RegularExpression;

import javax.swing.JOptionPane;

public class testMyMatcher {

	public static void main(String[] args) {
		
		//String str2 = JOptionPane.showInputDialog(null, "Enter Rule");
		myMatcher matcher = new myMatcher("[a-z]{4}[K-Z]{1}[0-9]{5}");
		System.out.println("Testing my matcher");
		matcher.BuildRuleSet();
		matcher.printRule();
		
		do {
			
			
			String str = JOptionPane.showInputDialog(null, "Enter String");
			if (matcher.check(str)) {
				//String newstr = str.replaceAll("8", "EIGHT");
				
				JOptionPane.showMessageDialog(null, str + ":\n" + "VALID");
			}
			else{
				JOptionPane.showMessageDialog(null, str + ":\n" + "INVALID");
			}
			
		} while (true);

	}  // mikiy78654

}
