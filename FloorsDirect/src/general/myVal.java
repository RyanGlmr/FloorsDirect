package general;

import java.util.InputMismatchException;
import java.util.Scanner;

public class myVal {
	
	public static Scanner key = new Scanner(System.in);
	
	// for entering number within range
	public static int validIntRange(String msg, int min, int max) {
		int num = 0;
		boolean ok;

		do 
		{
			try 
			{
				ok = true;
				My.p(msg);
				num = key.nextInt();
				if (num < min || num > max) 
				{
					My.p(String.format("\nError: Range is between %d - %d\n", min, max));
					key.nextLine();
					ok = false;
					
				}
			} catch (InputMismatchException e) 
			{
				My.p("\nIllegal characters enterred, please try again\n");
				key.nextLine();
				ok = false;
			}

		} while (ok == false);
		return num;
	}
	// validating int
	
	public static int validInt(String msg)
	{
		boolean ok;
		int num = 0;
		do
		{
			try 
			{
				ok = true;
				My.p(msg);
				num = key.nextInt();
				
			}
			catch (InputMismatchException e)
			{
				My.p("ERROR: Invalid character. Please enter a number.\n");
				key.nextLine();
				ok = false;
			}
		}while (!ok);
		
		return num;
	}
	
	// Valid double
	
	public static double validDouble (String msg)
	{
		boolean ok = true;
		double num1 = 0;
		do
		{
			try
			{
				ok = true;
				My.p(msg);
				num1 = key.nextDouble();
				
			}
			catch (InputMismatchException e)
			{
				My.p("ERROR: Invalid character. Please enter a number.\n");
				key.nextLine();
				ok = false;
			}
		} while(!ok);
		
		return num1;
	}
	
	
	// for entering a positive number
	public static int validIntPos(String msg)
	{
		boolean ok;
		int num = 0;
		do
		{
			try
			{
				ok = true;
				My.p(msg);
				num = key.nextInt();
				if(num<0)
				{
					My.p("Error: Negative number enterred. Please enter a number greater than or equal to 0.");
					ok = false;
				}
			}
			catch(InputMismatchException e)
			{
				My.p("\tERROR : Please enter a number\n\n");
				key.nextLine();
				ok = false;
			}
		} while(!ok);
		
		return num;
	}
	
	
	
	
	

}
