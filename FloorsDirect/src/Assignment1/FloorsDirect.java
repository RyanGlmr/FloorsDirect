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
			
			populateDB(custID, custName, custAddress);		//method to populate first 5 customers details

			
			int login = 0;	//login = customer ID e.g. 100 for bazza shnickle
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
					checkDetails(login, custID, custName, custAddress);
					My.p("\n\n\t\tAre the above details correct? \n\t\t\tY/N - ");
					yesNo = key.next().toUpperCase().charAt(0);
					if (yesNo == 'Y')
					{
						mainMenu();
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
				choice = myVal.validIntRange("Would you like to: \n1. Continue to order menu \n2. Create an account\nSelection: " , 1, 2);
				
				switch (choice)
				{
				case 1: mainMenu();
				}
			}
			
	}
	
	//======================================METHOD FOR POPULATING CUST DATABASE==========================================
	//===================================================================================================================
	public static void populateDB (ArrayList <Integer> custID, ArrayList <String> custName, ArrayList <String> custAddress)
	{
		int id = 100;

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
		}
	}
	//======================================METHOD FOR CONFIRMING CUST DETAILS ONCE ID IS ENTERRED==========================================

	public static void checkDetails(int login, ArrayList <Integer> custID, ArrayList <String> custName, ArrayList <String> custAddress )
	{
		for (int i = 0; i<custID.size(); i++)
		{
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
	
	//======================================METHOD FOR MAIN MENU=========================================================
	//===================================================================================================================
	public static void mainMenu ()
	{
		int mainMenuOpt;
		
		My.clear();
		My.p("\n\n\t\t\tMAIN MENU");
		My.titleBar();
		My.p("\n\tPlease select which type of flooring you would like to order");
		My.p("\n\n\t\t1. Carpet");
		My.p("\n\n\t\t2. Wood");
		My.p("\n\n\t\t3. Tiled");

		mainMenuOpt = myVal.validIntRange("\n\n \t\t Selection: ", 1, 3);
		
		switch(mainMenuOpt)
		{
		case 1: My.p("you selected Carpet"); // put the carpet method in here
		case 2: My.p("you selected Wood"); // put the Wood method in here
		case 3: tileMainMenu(); // put the Tiles method in here

		}
	}

//======================================METHOD THE TILE MENU=========================================================
//===================================================================================================================
	public static void tileMainMenu()
	{
		/*THIS WILL WORK BY CHOOSING THE TILE
		 * THEN CHOOSING YOUR EXTRAS
		 *	 IF YOU DONT WANT ANY EXTRAS YOU CAN THEN CHOOSE TO GET YOUR TILES FITTED, IF NO THEN BACK TO TILEMAIN OR MAIN
		 * BEING ABLE TO PRODUCE A BILL SHOWING, TILES BOUGHT, TYPE AND AMOUNT + EXTRAS BOUGHT TYPE AND AMOUNT + FITTING CHARGES
		 * ARRAY WILL BE NEEDED
		 */ 
		ArrayList <Double> tileSubBill = new ArrayList <Double>(); // array slot 0 = tile cost| arrSlot 1 = extras cost| 2 = fitting cost
		double [] tileCost = {5.99, 6.89, 3.29, 4.67, 2.99}; 
		String [] tileName = 
			{"Quartz Stone Midnight Black", "Presealed Terracotta", "Super White Porcelain", "Coda Grey", "Grey Marble Split Mosaic"};
		String [] tileSize = {"M 300x300mm", "M 300x300mm", "L 300x600mm", "L 310x560mm", "S 300x150mm"};
		int displayMenuOpt = 1;
		int tileTypeOpt = 0;
		
			My.clear();
			My.pln("\n\n\t\t\tTILE MENU");
			//producing the menu
			for (int i = 0; i<tileCost.length; i++)
			{
				My.pln(String.format("|%3d. %30s |  £%-5.2f, | %s |", displayMenuOpt, tileName[i], tileCost[i], tileSize[i]));
				displayMenuOpt++;
			}
			// PUT AN OPTION HERE FOR BACK TO MAIN MENU 
			
			tileTypeOpt = myVal.validIntRange("\n\n Selection: ", 1, 5)-1;
			
			//method to calculate the amount of tiles required and cost.
			tileCostCalc(tileTypeOpt, tileSubBill);
			
			
			/* going to add the cost of the three bills saved in the array tileSubBill
			 for (int i = 0; i<tileSubBill.length; i++)
			 {
			   tileTotalBill += tileSubBill(i);
			 }*/
			 
				
				
	}
	///==================================== METHOD TO CALC AMOUNT OF TILES REQUIRED * PER TILE COST ======================================
	public static void tileCostCalc (int tileTypeOpt, ArrayList <Double> tileSubBill) // 
	{
		//will more than likely pass down [] tileSubBill and return it as a double [] tileSubBill 
		//then have a double totalBill add tile/extra/fitting charges.
		
		//I may also just add the tilecostEXtra + tileCost fitting in this method then return the tile/extra/fitting charges as one double in the main
		double amountOfTilesL = 0, amountOfTilesB = 0, tileBill = 0;
		int totAmountOfTiles = 0;
		double [] tileLength = {0.300, 0.300, 0.300, 0.310, 0.310};
		double [] tileBreadth = {0.300, 0.300, 0.600, 0.560, 0.560};
		double [] tileCost = {5.99, 6.89, 3.29, 4.67, 2.99}; 
		double lengthEntry = 0.00, breadthEntry = 0.00, tileTotalBill = 0.00;
		char cont =' ';
		//Inputting the length and breadth
		lengthEntry = myVal.validDouble("\n\tEnter the length in meters. '.3' decimals will give 'mm' accuracy\n  ");
		breadthEntry = myVal.validDouble("Enter the breadth in meters: ");
		
		//calculating the amount of tiles required rounded up and the amount it will cost for all the tiles.
				amountOfTilesL = Math.ceil(lengthEntry/tileLength[tileTypeOpt]);
				amountOfTilesB = Math.ceil(breadthEntry/tileBreadth[tileTypeOpt]);
				totAmountOfTiles = (int) (amountOfTilesL*amountOfTilesB);
				tileBill = totAmountOfTiles * tileCost[tileTypeOpt];
		
		//the amount of tiles will be determined by the length required / the length of the tile applied to breadth as well
		My.clear();
		My.p(String.format("\n\tYou will require %.0f tiles by length and %.0f tiles by breadth", amountOfTilesL, amountOfTilesB));
		My.p(String.format("\n\tTotal tiles required = %d", totAmountOfTiles));
		My.p(String.format("\n\tTile cost = £%.2f", tileBill=(totAmountOfTiles*tileCost[tileTypeOpt])));
		My.p(String.format("\n\tTotal area to cover in sq m %.3fm", lengthEntry*breadthEntry));
		My.p("\n\n\tPress any key and hit enter continue");
		cont = key.next().charAt(0);
		My.clear();
		tileSubMenu(amountOfTilesL, amountOfTilesB, totAmountOfTiles, tileSubBill);
		
	}
	
	public static void tileSubMenu(double amountOfTilesL, double amountOfTilesB, int totAmountOfTiles, ArrayList <Double> tileSubBill)
	{
		int choice = 0;
		My.p("\n\n\t\t\tTILE SUB MENU");
		My.pln("");
		choice = myVal.validIntRange("\n\t1. Order extras \n\n\t2. Order fitting services \n\n\t3. Return to tile menu \n\n\t4. Return to main menu\n\n\tSelection: ", 1, 4);
		switch (choice)
		{
		case 1: tileExtras(amountOfTilesL,amountOfTilesB,totAmountOfTiles, tileSubBill); break;
		}
	}
	
	public static ArrayList<Double> tileExtras (double amountOfTilesL, double amountOfTilesB, int totAmountOfTiles, ArrayList <Double>  tileSubBill)
	{
		// the totAMountOfTiles will be used to calc how much extras are needed
		// Red spacers would be the (amountOfTilesL–1) x (amountOfTilesB–1) + (L-1*2) + (W-1*2); 
		// spacers come in packs of 50. Number of spacers required / 50 = num of packs needed
		char yesNo = ' ';
		double spacerCost = 5.99, spacerPackets = 0.00;
		int spacers = 0;
		double greyGrout = 0.00, whiteGrout = 0.00, greyGroutCost = 29.95, whiteGroutCost = 19.95;
		String [] groutName = {"Grey Grout", "White Grout"};
		boolean ok;
		int choice = 0;
		spacers = (int) (((amountOfTilesL-1) * (amountOfTilesB-1)) + (((amountOfTilesL-1)*2) + ((amountOfTilesB-1)*2)));
		spacerPackets = Math.ceil((double)spacers/50);
		greyGrout = Math.ceil(amountOfTilesL*amountOfTilesB/20); // To calc how much grout is needed 
		whiteGrout = Math.ceil(amountOfTilesL*amountOfTilesB/8); // To calc how much grout is needed 
		
		
		
		My.p("\nSpacers required = " + spacers);
		// ask the customer if they would like to accept this or change as they may have spacers already
		My.p(String.format("\nWe recommend you buy %.0f spacer packets", spacerPackets)); 
		My.p(String.format("\nWould you like to buy the recommended amount of spacers? Or would you like to change the amount of packets?"
				+ "\n\t\t Y/N - "));
		yesNo = key.next().toUpperCase().charAt(0);
		if (yesNo == 'Y') 
		{
			My.p(String.format("\n%.2f packet(s) of spacers will be added to your bill at a cost of £%.2f", spacerPackets, spacerCost*spacerPackets));
		}
		else if (yesNo == 'N')
		{
			spacerPackets = myVal.validInt("\nHow many spacer packets would you like? Enter '0' if you would like no spacers");
			if (spacerPackets>0)
				My.p(String.format("\n%.2f packet(s) of spacers will be added to your bill at a cost of %.2f", spacerPackets, spacerCost*spacerPackets));
			else
				My.p("You have opted for no spacers");
		}
		
		My.clear();
		My.p(String.format("\n\nWe recommend you buy %.0f bags of grey grout for £%.2f or "
				+ "%.0f bags white grout for £%.2f. for the amount of area required %.3f ", greyGrout, greyGroutCost, whiteGrout, whiteGroutCost));
		
		choice = myVal.validIntRange("\nWould you like to purchase grout?"
				+ "\n1. Yes (Grey Grout for recommended amount) "
				+ "\n2. Yes (White Grout for recommnded amount)"
				+ "\n3. Yes (Input amount of grout and type)"
				+ "\n4. No.", 1, 2);
		
		
		switch (choice)
		{
		case 1: 
		}
		
		//extrasSubBill[0] = 0;
		return tileSubBill;
	}
				
				

				
}
