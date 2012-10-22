package convenience;

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
public class Strings {
	
    public int getLength(String word1) {
       int len = word1.length();
       return len;
    }
    
    public char getFirstChar(String word1) {
        char firstChar = word1.charAt(0);
        return firstChar;
    }
    
    public String getLastChar(String word1) {
        int len = word1.length();
        String lastChar = word1.substring(len-1);
        return lastChar;
    }
    
    public String getUpperCase(String word1) {
        String upperCase = word1.toUpperCase();
        return upperCase;
    }
    
    public boolean compareWords(String word1, String word2) {
        boolean equal = false;
    	if (word1.equals(word2)) {
    		equal = true;
    	} else {
    		equal = false;
    	}
	    return equal;
    }
}
