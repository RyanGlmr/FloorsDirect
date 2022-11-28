package Assignment1;

import java.util.ArrayList;

import general.My;
import general.myVal;

public class ryanTestMethods 
{
	// spacer calc. int spacers = (int) (((amountOfTilesL-1) * (amountOfTilesB-1)) + (((amountOfTilesL-1)*2) + ((amountOfTilesB-1)*2)));
	public static void libraryOfArarys()
	{
		//Array group for tile receipt
				ArrayList <String> tileOrderType = new ArrayList<String>();
				ArrayList <String> tileOrderSize = new ArrayList<String>(); 
				ArrayList <Integer> tileOrderAmount = new ArrayList<Integer>(); 
				ArrayList <Double> tileOrderCost = new ArrayList<Double>(); 	
				ArrayList <Double> tileOrderSubBill = new ArrayList<Double>();
				double [] tileCost = {5.99, 6.89, 3.29, 4.67, 2.99}; 

		//Array group for extra receipt
				ArrayList <String> extraOrderType = new ArrayList<String>(); //remember arrays are passed by reference
				ArrayList <Double> extraOrderCost = new ArrayList<Double>();  
		
	}

	public static void main(String[] args) 
	{
		ArrayList <Integer> areaNum = new ArrayList<Integer>();
		// aTileAmount aTileCost aTileSize aTileSubBill || aExGroup || aFitGroup
		
		//Array group for tile receipt
		ArrayList <String> tileOrderType = new ArrayList<String>();
		ArrayList <String> tileOrderSize = new ArrayList<String>(); 
		ArrayList <Integer> tileOrderAmount = new ArrayList<Integer>(); 
		ArrayList <Double> tileOrderCost = new ArrayList<Double>(); 
		double [] tileCost = {5.99, 6.89, 3.29, 4.67, 2.99}; 


		//Array group for extra receipt
		ArrayList <String> extraOrderType = new ArrayList<String>(); //remember arrays are passed by reference
		ArrayList <Double> extraOrderCost = new ArrayList<Double>();
			
		mainMenu(areaNum, tileOrderType, tileOrderSize, tileOrderAmount, tileOrderCost, tileCost);
	}
	
	public static void mainMenu(ArrayList <Integer> areaNum, ArrayList <String> tileOrderType, ArrayList <String> tileOrderSize, ArrayList <Integer> tileOrderAmount, ArrayList <Double> tileOrderCost, double [] tileCost)
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
		case 3: 		tileMainMenu(areaNum, tileOrderType, tileOrderSize, tileOrderAmount, tileOrderCost, tileCost);
; // put the Tiles method in here

		}
		
	}
	public static void tileMainMenu(ArrayList <Integer> areaNum, ArrayList <String> tileOrderType, ArrayList <String> tileOrderSize, ArrayList <Integer> tileOrderAmount, ArrayList <Double> tileOrderCost, double [] tileCost)
	{
		String [] tileType = {"Quartz Stone Midnight Black", "Presealed Terracotta", "Super White Porcelain", "Coda Grey", "Grey Marble Split Mosaic"};
		String [] tileSize = {"M 300x300mm", "M 300x300mm", "L 300x600mm", "L 310x560mm", "S 300x150mm"};
		double [] tileLength = {0.300, 0.300, 0.300, 0.310, 0.310};
		double [] tileBreadth = {0.300, 0.300, 0.600, 0.560, 0.150};
		double lengthEntry = 0.00, breadthEntry = 0.00, amountOfTilesL = 0, amountOfTilesB = 0, tileBill = 0;
		
		int displayMenuOpt = 1, choice = 0, area = 0, numOfTiles = 0, orderMore = 0;

		
		do
		{
			areaNum.add(area);
			My.clear();
			My.pln("\n\n\t\t\tTILE MENU"); //=Producing the tile menu=======================================
			displayMenuOpt = 1;
			for (int i = 0; i<tileCost.length; i++)
			{
				My.pln(String.format("|%3d. %30s |  £%-5.2f, | %s |", displayMenuOpt, tileType[i], tileCost[i], tileSize[i]));
				displayMenuOpt++;	
				
			//=============================Choosing what tile type you want=============================
				if (i == tileCost.length-1)
				{
					My.pln("|  6. PUT IN EXIT OPTION");
					choice = myVal.validIntRange("\nSelection: ", 1, 5);
					tileOrderType.add(tileType[choice-1]);						// 1st of 4 receipt array used
					tileOrderSize.add(tileSize[choice-1]);						// 2nd of 4 receipt array used

				}
			}
			//=============================Determine how many tiles required and cost=================================
			
			My.clear();
			lengthEntry = myVal.validDouble("\nPlease provide the largest length of the room in meters, up to 3 decimal places for mm accuracy: ");
			breadthEntry = myVal.validDouble("Please provide the largest breadth of the room in meters, up to 3 decimal places for mm accuracy: ");
			
			amountOfTilesL = Math.ceil(lengthEntry/tileLength[choice-1]);
			amountOfTilesB = Math.ceil(breadthEntry/tileBreadth[choice-1]);
			tileOrderAmount.add((int) (amountOfTilesL*amountOfTilesB)); 		//3rd of 4 receipt array used
			
			numOfTiles = tileOrderAmount.get(area);
			tileOrderCost.add(numOfTiles*tileCost[choice-1]);					//4th of 4 receipt array used
			
			My.p(String.format("You require %d tiles for the area provided, costing £%.2f", tileOrderAmount.get(area), tileOrderCost.get(area)));
			//extras();
			
			//========================Once Extras/Fittings have been ordered. This will loop round to start if YES====================
			choice = myVal.validIntRange("\nWould you like to buy more tiles?\n\t1. Yes\n\t2. Main Menu TEMP VIEW RECEIPT \nSelection: ", 1, 2);
			
			
			switch (choice)
			{
			case 1:	area++; break;//area will be like an index for the receipt. each area will correlate with items on order per area.
			case 2: tileReceipt(areaNum, tileOrderType, tileOrderSize, tileOrderAmount, tileOrderCost, tileCost) ; break;
			}
		}while(choice == 1);
	}
	
	public static void tileReceipt(ArrayList <Integer> areaNum, ArrayList <String> tileOrderType, ArrayList <String> tileOrderSize, ArrayList <Integer> tileOrderAmount, ArrayList <Double> tileOrderCost, double [] tileCost)
	{
		My.clear();
		char a = ' ';
		My.p(String.format("| Area |%24c TILE |  PER | %6c  SIZE | AMOUNT | COST", a, a)); 
		for (int i = 0; i < 10; i++)
		{
			My.p(String.format("\n| %d | %30s | £%.2f | %s | %6d | £%.2f |", 
					areaNum.get(i), tileOrderType.get(i), tileCost[i], tileOrderSize.get(i), tileOrderAmount.get(i), tileOrderCost.get(i)));
		}
		
		
	}
	
	public static void extras()
	{
		int displayMenuOpt = 1;
		
		String [] extraType = {"White Grout", "Grey Grout", "Spacers" };
		double [] extraCost = {29.95, 19.95, 5.99};
		
		ArrayList <String> extraOrderType = new ArrayList<String>(); //remember arrays are passed by reference
		ArrayList <Double> extraOrderCost = new ArrayList<Double>(); 
		
		ArrayList <Integer> numExtrasOrdered = new ArrayList<Integer>();

		My.pln("\n\n\t\tEXTRAS MENU");

		for (int i = 0; i<extraType.length; i++)
		{
			My.pln(String.format("|%3d. %15s |  £%5.2f, |", displayMenuOpt, extraType[i], extraCost[i]));
			displayMenuOpt++;
		}
		
		
	}
	
	
	
	
	

}
