package Assignment1;

import java.util.ArrayList;

import general.My;
import general.myVal;

public class testPassByRef {

	public static void main(String[] args) 
	{
		ArrayList <Integer> num = new ArrayList<Integer>();
		input(num);
		output(num);
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
}
