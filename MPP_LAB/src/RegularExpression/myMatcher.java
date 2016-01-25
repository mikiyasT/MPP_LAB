package RegularExpression;

import java.util.ArrayList;
import java.util.Iterator;

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
					//assuming the length is given in the form of {4,6} 4 = min leng, and 6 is the max len.
					//if there are no , separeted numbers start and end will be same.
					//if after , there is no number then start will be min leng [one character long]write
					String min_len = "";
					String max_len = "";
					// for {6,7}  at(i) is { at(i+1) is 6  at(i+2) is , and at(i+3) is 7 
					min_len = ""+pattern.charAt(i+1);
					if(pattern.charAt(i+2) ==',')
					max_len = ""+pattern.charAt(i+3);
					else
					max_len = ""+pattern.charAt(i+1);
					
					r.setMinLen(min_len);
					r.setMaxLen(max_len);
					
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
	
	public boolean check(String str, int rule_index)
	{
		
		if(rule_index >= rules.size() )
			return false;
		
		char ruleFirstChar = rules.get(rule_index).getStartingLetter().charAt(0);
		char ruleLastChar =  rules.get(rule_index).getEndingLetter().charAt(0);
		
		for(int i = 0; i < str.length(); i++)
		{
				
				char charTocheck =  str.charAt(i);
				if( i >= rules.get(rule_index).getMinLen()-1 && i <= rules.get(rule_index).getMaxLen()-1)
				{
					if(charTocheck < ruleFirstChar || charTocheck > ruleLastChar)//not with in the boundary in the rule
					{
						return false;
					}
				}
				else
				{
					//switch to next rule, and next substring
					if(rule_index < rules.size())
						return check(str.substring(i),rule_index++);
					else
						return false;
				}
				
//				if(charTocheck < ruleFirstChar || charTocheck > ruleLastChar)//not with in the boundary in the rule
//				{
//					if( i >= rules.get(rule_index).getMinLen()-1 && i <= rules.get(rule_index).getMaxLen())
//					{
//						//subString length has not yet satisfied the first rule
//						return false;
//					}
//					else
//					{
//						//switch to next rule, and next substring
//						 check(str.substring(i),rule_index++);		
//						
//					}
//				}
//				
				
		}
		return true;
			
	
//		int total_length_of_string = 0;
//		int prgoressing_len = 0;
//		for(Rule r : rules)
//		{
//			total_length_of_string += r.getLen();
//			min_total_length_of_string =r.getMinLen();
//			max_total_length_of_string = r.getMaxLen();
//		}
//		//		for(Rule r: rules)
//		{	
//			
//			total_length_of_string += r.getLen();
//			for(int i = 0; i < r.getLen(); i++)
//			{
//				char charTocheck =  str.charAt(i+prgoressing_len);
//				char ruleFirstChar = r.getStartingLetter().charAt(0);
//				char ruleLastChar =  r.getEndingLetter().charAt(0);
//				
//				if(charTocheck < ruleFirstChar || charTocheck > ruleLastChar){
//					return false;
//				}
//			}
//			prgoressing_len += r.getLen();
//			prgoressing_len += r.getMaxLen();
//		}
//		
//		return true;
	}
	

}
class Rule{
	//rule/ pattern should always be included in [] and number of occurences given in {}
	String startingLetter;
	String endingLetter;
	int len = 0;
	int max_len = 0;
	int min_len = 0;
	
	
	Rule(){
		
	}
	
	Rule(String start,String end, int len, int max_len, int min_len){
		this.startingLetter = start;
		this.endingLetter = end;
		this.len = len;
		this.max_len = len;
		this.min_len = len;
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
	public int getMaxLen() {
		return max_len;
	}
	public int getMinLen() {
		return min_len;
	}
	
	public void setLen(String len) {
		this.len = Integer.parseInt(len);
	}
	
	public void setMaxLen(String len) {
		this.max_len = Integer.parseInt(len);
	}
	
	public void setMinLen(String len) {
		this.min_len = Integer.parseInt(len);
	}
	
	
	public String toString(){
		return "Starting " + startingLetter + " Ending " + endingLetter + "Max Length " + max_len + " Min Length : " + min_len;
	}
	
	
	
}
