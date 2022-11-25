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
			
			
			int login = 0, mainMenuOpt = 0;	//login = customer ID e.g. 100 for bazza shnickle
			char yesNo;
			int choice = 0;	//Choice is for the *** The non-customer menu *** below
			boolean ok;
			
			My.p("Welcome to Floors Direct. Are you a customer? \n\t\t Y/N - ");
			yesNo = key.next().toUpperCase().charAt(0);
			if (yesNo == 'Y')
			{
				
					login = myVal.validInt("\nPlease enter your customer ID - ");	
					
					do 
					{
					ok = true;
					custDetails(login, choice, custID, custName, custAddress);
					
					My.p("\n\n\t\tAre the above details correct? \n\t\t\tY/N - ");
					yesNo = key.next().toUpperCase().charAt(0);
					if (yesNo == 'Y')
					{
						My.p("\n\n\t\t\tMAIN MENU");
						My.p("\n\tPlease select which type of flooring you would like to order");
						My.p("\n\n\t\t1. Carpet");
						My.p("\n\n\t\t2. Wood");
						My.p("\n\n\t\t3. Tiled");

						mainMenuOpt = myVal.validIntRange("", 1, 3);
						
						switch(mainMenuOpt)
						{
						case 1: My.p("you selected Carpet"); // put the carpet method in here
						case 2: My.p("you selected Wood"); // put the Wood method in here
						case 3: tileMainMenu(mainMenuOpt); // put the Tiles method in here

						}

					}
					else if (yesNo == 'N')
					{
						login = myVal.validInt("\nPlease retry re-entering your customer ID - ");				
						ok = false;
						My.clear();	// This is just a bunch of '\n' to make it appear as if the console has been cleared.
					}
				}while (!ok);
			}
			
			
			//==========================*** The non-customer menu ***=============================
			else 
			{	
				choice = myVal.validIntRange("Would you like to: \n 1. Continue to order menu \n2. Create an account" , 1, 2);
				
				// if 'choice' = 1 then go on to order menu
				
				if (choice == 2)
				{
					// THEN ADD CUSTOMER
				}
			}
			
	}
	
	//======================================METHOD FOR LOGING IN=========================================================
	//===================================================================================================================
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
				My.pln("\n\n\t\t\tCUSTOMER DETAILS");
				My.p("\t\t\t-----------------");

				My.p(String.format("\n\ncustomer ID: %-10d", custID.get(i)));
				My.p(String.format("| Name: %-20s", custName.get(i)));
				My.p(String.format("| Address: %-20s",  custAddress.get(i)));
			}
		}
	}
	
	//======================================METHOD THE TILE MENU=========================================================
	//===================================================================================================================
				public static void tileMainMenu(int mainMenuOpt)
				{
					if (mainMenuOpt == 3)
					{
						My.clear();
						My.p("TILE MENU WILL APPEAR HERE");
					}
				}

}
