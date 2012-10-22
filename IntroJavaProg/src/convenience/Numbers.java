package convenience;

/**
 * This class [currently] contains three number methods
 * even or odd
 * add two numbers
 * multiply two numbers
 * @author B. Paroubek
 * 2012
 */
public class Numbers
{
// instance variables 
    int num1;
    int num2;
    int sum, product;
    double evenOdd;

// method add
    public int add(int num1, int num2)
    {
        sum = num1 + num2;
        
        return sum;
    }
    

// method multiply
    public int multiply(int num1, int num2)
    {
        product = num1 * num2;
        
        return product;
    }
    
   
// method even odd
    public boolean evenOdd(int num1)
    {
        boolean isEven;
        if (num1%2 == 0)
        	isEven = true;
        else
        	isEven= false;
        
        return isEven;
    }
    
    
}
