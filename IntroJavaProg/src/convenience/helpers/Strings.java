package convenience.helpers;

public class Strings {
	/**
	 * This class [currently] contains 5 string methods:
	 * get length
	 * get last character
	 * get first character
	 * get upper case
	 * compare words
	 * @author B. Paroubek
	 * 2012
	 */
	
	    // instance variables - replace the example below with your own
	    String word1, word2;

	   
//method get length
	    public int getLength(String word1)
	    {
	       int len = word1.length();
	       
	       return len;
	    }
	    

// method get first character
	    public char getFirstChar(String word1)
	    {
	        char firstChar = word1.charAt(0);
	        
	        return firstChar;
	    }
	    
	    
// method get last character	    
	    public String getLastChar(String word1)
	    {
	        int len = word1.length();
	        String lastChar = word1.substring(len-1);
	        
	        return lastChar;
	    }
	    
	    
// method get upper case	    
	     public String getUpperCase(String word1)
	    {
	        String upperCase = word1.toUpperCase();
	        
	        return upperCase;
	    }
	   

// method compare words
	     public boolean compareWords(String word1, String word2)
	    {
	        boolean equal = false;
		    	if (word1.equals(word2))
		            equal = true;
		        else
		            equal = false;
	        
		    return equal;
	    }
	     
	     public String getFirstName(String fullName) {
	    	 return fullName.substring(0, fullName.indexOf(" "));
	     }
	     
	     public String getLastName(String fullName) {
	    	 return fullName.substring((fullName.indexOf(" ") + 1));
	     }
	     
	     public String getPluralName(String name) {
	    	 if((this.getLastChar(name)).equals("s")) {
	    		 return name + "\'";
	    	 } else {
	    		 return name + "\'s";
	    	 }
	     }

	}
