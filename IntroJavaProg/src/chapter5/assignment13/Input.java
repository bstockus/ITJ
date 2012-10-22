package chapter5.assignment13;

import javax.swing.JOptionPane;
public class Input {

/**
This class has the following methods
getString 	(returns String)
getInteger	(returns int, or 0 if nothing/non mumeric is entered)
getDouble	(returns double, or 0 if nothing/non mumeric is entered)
getFloat	(returns float, or 0 if nothing/non mumeric is entered)
writeMessage(writes a message box according to the values passed) 
		
Each "get" method accepts message text, message title, and message type
message type numbers are below
0=x error
1=i information 
2=caution triangle
3=? QUESTION_MESSAGE	
*/

// instance variables
String 	answer = "";
int 	answerInt = 0;
double 	answerDouble = 0;
float 	answerFloat = 0;
//String  answer4 = "";
		

		// *************************************************************************************************************
		// accessor method getString 
		// requires message text, message title and type as arguments
		
		// using a, b, c here for argument variables simply shows
		// that the variable names do NOT need to be the same as those that were passed to this method

	    public String getString(String a, String b, int c)
	    {
	    	answer = JOptionPane.showInputDialog(null,a,b,c); 
	    	if (answer.equals(""))
	    		return "";
	    	else
	    		return answer;
	    }
	    
	    
	    
	    
	    // *************************************************************************************************************
	    // accessor method getInteger
	    // requires message text, message title and type as arguments
	    public int getInteger(String messageText, String title, int type)
	    {
	    	answer = JOptionPane.showInputDialog(null,messageText,title,type); 
	    	
	    	//test for numeric
	    	boolean isNumber =  answer.matches("-?\\d+(.\\d+)?");
	    	
	    	// test for a numeric value
	    	if (isNumber==false)
	    	{
	    		//call error message method
	    		writeMessage("Error.  You have not entered a valid INTEGER.\nThe program will now terminate.","ERROR",0);
	    		// terminate the program
	    		System.exit(0);
	    		return answerInt = 0;// must have a return statement in accessor method
	    	}
	    		
	    	else
	    		return answerInt = Integer.parseInt(answer); 	

	    }
	     
	    
	    
	    
	    // *************************************************************************************************************
	    // accessor method getDouble
	    public double getDouble(String a, String b, int c)
	    {
	    	answer = JOptionPane.showInputDialog(null,a,b,c); 
	    	
	    	//test for numeric
	    	boolean isNumber =  answer.matches("-?\\d+(.\\d+)?");
	    	
	    	// test for a numeric value
	    	if (isNumber==false)
	    	{
	    		//call error message method
	    		writeMessage("Error.  You have not entered a valid number of the type DOUBLE.\nThe program will now terminate.","ERROR",0);
	    		// terminate the program
	    		System.exit(0);
	    		return answerDouble = 0;// must have a return statement in accessor method
	    	}
	    	else
	    		return answerDouble = Double.parseDouble(answer);  
	    	
	    }
	    
	    
	    // *************************************************************************************************************
	    // accessor method getFloat
	    public float getFloat(String messageText, String title, int type)
	    {
	    	answer = JOptionPane.showInputDialog(null,messageText,title,type); 
	    	
	    	//test for numeric
	    	boolean isNumber =  answer.matches("-?\\d+(.\\d+)?");
	    	
	    	// test for a numeric value
	    	if (isNumber==false)
	    	{
	    		//call error message method
	    		writeMessage("Error.  You have not entered a valid number of the type FLOAT.\nThe program will now terminate.","ERROR",0);
	    		// terminate the program
	    		System.exit(0);
	    		return answerFloat = 0;// must have a return statement in accessor method
	    	}
	    	else
	    		return answerFloat = Float.parseFloat(answer);
	    }


	    
	    // *************************************************************************************************************
	    // mutator method - shows a message box
	    // requires message text, message title and type as arguments
	  public void writeMessage(String messageText,String title,int type)
	  {
		  JOptionPane.showMessageDialog(null,messageText,title,type); 
	  }
	    

	  
	  
	  
	  
	
}