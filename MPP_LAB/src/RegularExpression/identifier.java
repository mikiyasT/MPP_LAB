

/*
Checks whether the input string is a valid identifier.
   File: Ch9MatchJavaIdentifier.java
*/
package RegularExpression;
import javax.swing.*;
class Ch9MatchJavaIdentifier {
   private static final String STOP    = "STOP";
   private static final String VALID   = "Valid Java identifier";
   private static final String INVALID = "Not a valid Java identifier";

   private static final String VALID_IDENTIFIER_PATTERN
                  = "[a-zA-Z][a-zA-Z0-9_$]*";
   //private static final String VALID_PHONE_NUM_PATTEREN =  "\\d{3}-\\d{3}-\\d{4}";//"[0-9]{3}-[0-9]{3}-[0-9]{4}";
   private static final String VALID_PHONE_NUM_PATTEREN = "\\d{3}\\s\\d{3}\\s\\d{4}";
   public static void main (String[] args) {
       String str, reply;
       while (true) {
           str = JOptionPane.showInputDialog(null, "Identifier:");

           if (str.equals(STOP)) break;
           if (str.matches(VALID_PHONE_NUM_PATTEREN)) {
               reply = VALID;

           } else {
               reply = INVALID;
           }
           JOptionPane.showMessageDialog(null,
                                         str + ":\n" + reply);
       }
   }
}
