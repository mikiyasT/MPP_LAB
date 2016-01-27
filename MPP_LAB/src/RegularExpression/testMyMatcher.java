/*
@Mikiyas Teshome
@984615, MPP extra credit assignment
*/
package RegularExpression;
import javax.swing.JOptionPane;    
public class testMyMatcher {

	public static void main(String[] args) {
		
		// pass the pattern to the constructor
		final String PATTERN = "[#]{1}[a-z]{3,7}[-]{1}[K-Z]{1,3}[-]{1}[0-9]{6}[x]{1}"; 
		myMatcher matcher = new myMatcher(PATTERN);
		System.out.println("Testing string matcher class");
		matcher.BuildRuleSet();
		matcher.printRule();
		
		do {
			
			
			String str = JOptionPane.showInputDialog(null, "Enter String");
			//pass the input string str to the method check as check(str,0)
			if (matcher.check(str,0)) {
				JOptionPane.showMessageDialog(null, str + ":\n" + "VALID");
			}
			else{
				JOptionPane.showMessageDialog(null, str + ":\n" + "INVALID");
			}
			
		} while (true);

	}  // miki-T-984615x

}
