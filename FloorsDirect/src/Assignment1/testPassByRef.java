package Assignment1;

import java.util.ArrayList;

import general.My;
import general.myVal;

public class testPassByRef {

	public static void main(String[] args) 
	{
		ArrayList <String> info = new ArrayList <String>();
		
		
	}
	
	public static void passToString (ArrayList <String> info)
	{
		
		info.add()
		
	}
	
	public static void input(ArrayList <Integer> num)
	{
		
		for (int i = 0; i<5; i++)
		{
		num.add(myVal.validInt("\nEnter num: "));
		}
		
	}
	
	public static void output(ArrayList <Integer> num)
	{
		
		for (int i = 0; i<num.size(); i++)
		{
			My.p(" - " + num.get(i));
		}
	}
	
	public static void overwrite ()
	{
		ArrayList <Integer> num1 = new ArrayList <Integer>();
		//ArrayList <Integer> num2 = new ArrayList <Integer>();
		int num2 = 0;
		num1.add(1);
		num1.add(2);
		num1.add(3);
		num2 = 5;
		num1.set(0, num2);

		for(int i = 0; i<num1.size(); i++)
		{
			My.p("\n" + num1.get(i));
		}
	}
}
