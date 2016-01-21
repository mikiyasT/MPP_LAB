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
	
	void BuildRuleSet(){
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
					r = new Rule();
					break;
				case ']':
					newRuleEnding = true;
					break;
				case '-':
					separateroFound = true;
					break;
				case '{':
					newRuleNumStaring = true;
					break;
				case '}':
					newRuleNumEnding = true;
					break;
				default:
					{
						if(newRuleStarting)
						{
							r.setStartingLetter(""+pattern.charAt(i)); 
							newRuleStarting = false;
							
						}
						else if(newRuleEnding)
						{
							
						}
						else if(separateroFound)
						{
							
						}
						else if(newRuleNumStaring)
						{
							
						}
						else if(newRuleNumEnding)
						{
							
						}
					
					}
					break;
					
				}
			}
		}
	}
	

}
class Rule{
	//rule/ pattern should always be included in [] and number of occurences given in {}
	String startingLetter;
	String endingLetter;
	int len;
	
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
	public void setLen(int len) {
		this.len = len;
	}
	
	
	
}
