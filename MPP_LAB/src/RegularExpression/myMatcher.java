package RegularExpression;

import java.util.ArrayList;

public class myMatcher {
	
	//private int numberOfRules;
	ArrayList<Rule> rules = new ArrayList<Rule>();
	String pattern;
	String input;
	myMatcher(String pattern){
		this.pattern = pattern;
	}
	
	void BuildRuleSet()
	{
		Rule r = null;
		//count how many [] combinations you have. This count will be the nubmber of rules
		 //should start with '[' and end with ']' or '}'
		//this can be checked with stack .. expression mathching
		
		boolean newRuleStarting = false;
		boolean newRuleEnding = false;
		boolean separateroFound = false; // found '-'
		boolean newRuleNumStaring = true;
		boolean newRuleNumEnding = true;
		
		for(int i = 0; i < pattern.length(); i++){
			if(i == 0 && pattern.charAt(i) != '[')
			{
				System.out.println("Inalid rule");
			}
			else
			{
				switch(pattern.charAt(i))
				{
				case '[':
					newRuleStarting = true;
					r = null;
					r = new Rule();
					
					r.setStartingLetter(""+pattern.charAt(i+1)); 
					newRuleStarting = false;
					break;
				case ']':
					newRuleEnding = true;
					r.setEndingLetter(""+pattern.charAt(i-1)); 
					newRuleEnding = false;
					break;
				case '-':
					separateroFound = true;
					break;
				case '{':
					newRuleNumStaring = true;
					String len = ""+pattern.charAt(i+1);
					r.setLen(len);
					newRuleNumStaring = false;
					break;
				case '}':
					newRuleNumEnding = true;
					rules.add(r);
					r = null;
					break;
				default:

					break;
					
				}
			}
		}
	}
	
	public void printRule(){
		for(Rule r : rules)
			System.out.println(" -> " + r);
	}
	
	public boolean check(String str)
	{
		int total_length_of_string = 0;
		int prgoressing_len = 0;
		for(Rule r : rules)
			total_length_of_string += r.getLen();
		
		if(str.length() != total_length_of_string)
			return false;
		
		for(Rule r: rules)
		{
			for(int i = 0; i < r.getLen(); i++)
			{
				char charTocheck =  str.charAt(i+prgoressing_len);
				char ruleFirstChar = r.getStartingLetter().charAt(0);
				char ruleLastChar =  r.getEndingLetter().charAt(0);
				
				if(charTocheck < ruleFirstChar || charTocheck > ruleLastChar){
					return false;
				}
			}
			prgoressing_len += r.getLen();
		}
		
		return true;
	}
	

}
class Rule{
	//rule/ pattern should always be included in [] and number of occurences given in {}
	String startingLetter;
	String endingLetter;
	int len = 0;
	
	Rule(){
		
	}
	Rule(String start,String end, int len){
		this.startingLetter = start;
		this.endingLetter = end;
		this.len = len;
	}
	
	public String getStartingLetter() {
		return startingLetter;
	}
	
	public void setStartingLetter(String startingLetter) {
		this.startingLetter = startingLetter;
	}
	public String getEndingLetter() {
		return endingLetter;
	}
	public void setEndingLetter(String endingLetter) {
		this.endingLetter = endingLetter;
	}
	public int getLen() {
		return len;
	}
	public void setLen(String len) {
		this.len = Integer.parseInt(len);
	}
	
	public String toString(){
		return "Starting " + startingLetter + " Ending " + endingLetter + " Length " + len;
	}
	
	
	
}
