
public class ASCiiValue {
	
	    public static void printNumbers()
	    {
	       
	        for(char i = '0'; i <= '9'; ++i)
	        {
	            System.out.print(i);
	        }
	        System.out.println();
	    }

	    public static void printLowerCase()
	    {
	        
	        for(char a = 'a'; a <= 'z'; ++a)
	        {
	            System.out.print(a);
	        }
	        System.out.println();
	    }

	    public static void printUpperCase()
	    {
	        
	        for(char A = 'A'; A <= 'Z'; ++A)
	        {
	            System.out.print(A);
	        }
	        System.out.println();
	    }
	    
	    public static void main(String args[])
	    {
	        printNumbers();
	        printLowerCase();
	        printUpperCase();
	    }
	}

