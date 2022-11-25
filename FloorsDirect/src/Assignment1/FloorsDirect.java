package Assignment1;

import java.util.ArrayList;
import java.util.Scanner;

import general.My;
import general.myVal;

public class FloorsDirect {
	
	public static Scanner key = new Scanner (System.in);
	
	public static void main(String[] args) 
	{
			//Arrays below are for customer details
			ArrayList <Integer> custID = new ArrayList <Integer>();
			ArrayList <String> custName = new ArrayList <String>();
			ArrayList <String> custAddress = new ArrayList <String>();
			
			//login = customer ID e.g. 100
			int login = 0;
			char yesNo;
			int choice = 0;	//Choice is for the *** The non-customer menu *** below
			My.pln("Welcome to Floors Direct. Are you a customer? \n Y/N");
			yesNo = key.next().charAt(0);
			if (yesNo == 'Y')
			{
				login = myVal.validInt("\nPlease enter your customer ID - ");				
				custDetails(login, choice, custID, custName, custAddress);
				
				My.p("Are the above details correct?");
				yesNo = key.next().charAt(0);
				
				/*IF (yesNo == 'Y')
				{
					Then continue to order menu, ie. 
					1. Carpet
					2. Wood
					3. Tiles
				}*/
			}
			else 
			{	///*** The non-customer menu ***
				choice = myVal.validIntRange("Would you like to: \\n 1. Continue to order menu \\n2. Create an account" , 1, 2);
				
				// if 'choice' = 1 then go on to order menu
				
				if (choice == 2)
				{
					// THEN ADD CUSTOMER
				}
			}
			
	}
	
	
	public static void custDetails (int login, int choice, ArrayList <Integer> custID, ArrayList <String> custName, ArrayList <String> custAddress)
	{
		int id = 100;
		String Name;

		custName.add("Bazza McShmickle");
		custName.add("Aaron Tech");
		custName.add("Eimear Morrison");
		custName.add("Ryan Gilmour");
		custName.add("Teresa Deeney");
		
		//populating first 5 addresses
		custAddress.add("123 Yes Street");
		custAddress.add("10 Common house");
		custAddress.add("3 Seventree rd");
		custAddress.add("601 Abbeydale");
		custAddress.add("25 Santa rd");

		//populating first 5 ID's starting from 100
		for (int i = 0; i<5; i++)
		{
			custID.add(id);
			id++;
			
			if (custID.get(i) == login)
			{
				My.p(String.format("\n\ncustomer ID: %-10d", custID.get(i)));
				My.p(String.format("| Name: %-20s", custName.get(i)));
				My.p(String.format("| Address: %-20s",  custAddress.get(i)));
			}
		}
		
		
		

	}

}
