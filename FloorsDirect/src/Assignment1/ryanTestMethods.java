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
		//ARRAY LIST STRING 
		
				ArrayList <String> tileOrderType = new ArrayList<String>();
				ArrayList <String> tileOrderSize = new ArrayList<String>(); 
				ArrayList <Integer> tileOrderAmount = new ArrayList<Integer>(); 
				ArrayList <Double> tileOrderCost = new ArrayList<Double>(); 	
				ArrayList <Double> tileOrderSubBill = new ArrayList<Double>();
				ArrayList <Double> tileOrderPTC = new ArrayList<Double>();
				
				double [] tileCost = {5.99, 6.89, 3.29, 4.67, 2.99}; 

		//Array group for extra receipt
				ArrayList <String> extraOrderType = new ArrayList<String>(); //remember arrays are passed by reference
				ArrayList <Double> extraOrderCost = new ArrayList<Double>();
				ArrayList <Integer>extraOrderAmount = new ArrayList<Integer>();
		
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
		ArrayList <Double> tileOrderPTC = new ArrayList<Double>();
		double [] tileCost = {5.99, 6.89, 3.29, 4.67, 2.99}; 


		//Array group for extra receipt
		ArrayList <String> extraOrderType = new ArrayList<String>(); //remember arrays are passed by reference
		ArrayList <Double> extraOrderCost = new ArrayList<Double>();
		ArrayList <Integer>extraOrderAmount = new ArrayList<Integer>();
			
		mainMenu(areaNum, tileOrderType, tileOrderSize, tileOrderAmount, tileOrderCost, tileOrderPTC, tileCost, extraOrderType, extraOrderCost, extraOrderAmount);
	}
	
	public static void mainMenu(ArrayList <Integer> areaNum, ArrayList <String> tileOrderType, ArrayList <String> tileOrderSize, ArrayList <Integer> tileOrderAmount, ArrayList <Double> tileOrderCost, ArrayList <Double> tileOrderPTC, double [] tileCost, ArrayList <String> extraOrderType, ArrayList <Double> extraOrderCost, ArrayList <Integer>extraOrderAmount)
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
		case 3: 		tileMainMenu(areaNum, tileOrderType, tileOrderSize, tileOrderAmount, tileOrderCost, tileOrderPTC, tileCost, extraOrderType, extraOrderCost, extraOrderAmount); // put the Tiles method in here
		}
		
	}
	public static void tileMainMenu(ArrayList <Integer> areaNum, ArrayList <String> tileOrderType, ArrayList <String> tileOrderSize, 
									ArrayList <Integer> tileOrderAmount, ArrayList <Double> tileOrderCost, ArrayList <Double> tileOrderPTC,  
									double [] tileCost, ArrayList <String> extraOrderType, ArrayList <Double> extraOrderCost, ArrayList <Integer>extraOrderAmount)
	{
		String [] tileType = {"Quartz Stone Midnight Black", "Presealed Terracotta", "Super White Porcelain", "Coda Grey", "Grey Marble Split Mosaic"};
		String [] tileSize = {"M 300x300mm", "M 300x300mm", "L 300x600mm", "L 310x560mm", "S 300x150mm"};
		double [] tileLength = {0.300, 0.300, 0.300, 0.310, 0.310};
		double [] tileBreadth = {0.300, 0.300, 0.600, 0.560, 0.150};
		double lengthEntry = 0.00, breadthEntry = 0.00, amountOfTilesL = 0, amountOfTilesB = 0, tileBill = 0;
		
		int displayMenuOpt = 1, choice = 0, area = 0, numOfTiles = 0, orderMore = 0;
		
		//IF AREA > 0 THEN...
		//WOULD YOU LIKE TO VIEW RECEIPT BEFORE ENTERING TILE MENU? 
		
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
					tileOrderType.add(tileType[choice-1]);						//1st of 4 receipt array used
					tileOrderSize.add(tileSize[choice-1]);						//2nd of 4 receipt array used
					tileOrderPTC.add(tileCost[choice-1]);						//3rd of 4 receipt array used
				}
			}
			//=============================Determine how many tiles required and cost=================================
			
			My.clear();
			My.p(String.format("\tYou Selected - %s. Dimensions - %s \n\n\t(0.001m = 1mm)", tileOrderType.get(area), tileOrderSize.get(area)));
			lengthEntry = myVal.validDouble("\n\tEnter the length in meters: ");
			breadthEntry = myVal.validDouble("\tEnter the breadth in meters: ");
			
			amountOfTilesL = Math.ceil(lengthEntry/tileLength[choice-1]);
			amountOfTilesB = Math.ceil(breadthEntry/tileBreadth[choice-1]);
			tileOrderAmount.add((int) (amountOfTilesL*amountOfTilesB)); 		//4th of 4 receipt array used
			
			numOfTiles = tileOrderAmount.get(area);
			tileOrderCost.add(numOfTiles*tileCost[choice-1]);					//5th of 4 receipt array used
			
			My.clear();
			My.pln(String.format("You require %d tiles for the area provided, costing £%.2f", tileOrderAmount.get(area), tileOrderCost.get(area)));
			
			extrasTileMenu(amountOfTilesL, amountOfTilesB, extraOrderType, extraOrderCost, extraOrderAmount);

			
			//========================Once Extras/Fittings have been ordered. This will loop round to start if YES====================
			choice = myVal.validIntRange("\n\nWould you like to buy more tiles?\n\t1. Yes\n\t2. Main Menu \n\t3. VIEW RECEIPT \nSelection: ", 1, 2);
			
			
			switch (choice)
			{
			case 1:	area++; break;//area will be like an index for the receipt. each area will correlate with items on order per area.
			case 2: tileReceipt(areaNum, tileOrderType, tileOrderSize, tileOrderAmount, tileOrderCost, tileOrderPTC) ; break;
			}
		}while(choice == 1);
	}
	
	public static void tileReceipt(ArrayList <Integer> areaNum, ArrayList <String> tileOrderType, ArrayList <String> tileOrderSize, ArrayList <Integer> tileOrderAmount, ArrayList <Double> tileOrderCost, ArrayList <Double> tileOrderPTC)
	{
		My.clear();
		char a = ' ';
		My.p(String.format("| Area |%26c TILE |  PER  | %5c  SIZE | AMOUNT | %4cCOST |", a, a, a)); 
		for (int i = 0; i < areaNum.size(); i++)
		{
			My.p(String.format("\n| %3d  | %30s | £%.2f | %s | %6d | £%7.2f |", 
					areaNum.get(i), tileOrderType.get(i), tileOrderPTC.get(i), tileOrderSize.get(i), tileOrderAmount.get(i), tileOrderCost.get(i)));
		}		
	}
	
	public static void extrasTileMenuPop()
	{
		String [] extraType = {"Grey Grout 5Kg", "White Grout 2Kg", "Spacers (50)" };
		double [] extraCost = {29.95, 19.95, 5.99};

		int displayMenuOpt = 1;
		for (int i = 0; i<extraType.length; i++)
		{
			My.p(String.format("|%3d. %15s |  £%5.2f, |\n", displayMenuOpt, extraType[i], extraCost[i]));
			displayMenuOpt++;
		}
	}
	
	public static void extrasTileMenu(double amountOfTilesL, double amountOfTilesB, ArrayList <String> extraOrderType, ArrayList <Double> extraOrderCost, ArrayList <Integer>extraOrderAmount)
	{
		char a = ' ';
		int displayMenuOpt = 1, choice = 0, amount = 0, arrCount = 0;;
		int spacers = 0;
		double greyGrout = 0, whiteGrout = 0, spacerPacks = 0;
		String [] extraType = {"Grey Grout 5Kg", "White Grout 2Kg", "Spacers (50)" };
		double [] extraCost = {29.95, 19.95, 5.99};
		double [] recAmount = new double [3],  recCost = new double [3];
		boolean overwrite = false;
		//==========================================Calculations=========================================================
		greyGrout = Math.ceil(amountOfTilesL*amountOfTilesB/20);  
		whiteGrout = Math.ceil(amountOfTilesL*amountOfTilesB/8); 
		spacers = (int) (((amountOfTilesL-1) * (amountOfTilesB-1)) + (((amountOfTilesL-1)*2) + ((amountOfTilesB-1)*2)));		
		spacerPacks = Math.ceil((double)spacers/50);
		//=========================Recommended amounts including cost for area provided==================================
		recAmount[0] = greyGrout;			recCost[0] = greyGrout*extraCost[0];
		recAmount[1] = whiteGrout;		recCost[1] = whiteGrout*extraCost[1];
		recAmount[2] = spacerPacks;			recCost[2] = spacerPacks*extraCost[2];
		
		//=================================Extras Menu including recValues===============================================
		My.p("Spacers = " + spacers);
		
		My.pln(String.format("\n\n\t\tEXTRAS MENU %20c RECOMMENDED VALUES", a));

		for (int i = 0; i<extraType.length; i++)
		{
			My.p(String.format("|%3d. %15s |  £%5.2f, | %20s | %3.0f | £%.2f\n", displayMenuOpt, extraType[i], extraCost[i], extraType[i], recAmount[i], recCost[i]));
			displayMenuOpt++;
			
				if (i == extraType.length-1)
				{ 
					do
					{
						if (choice > 0 && choice < 4)
							extrasTileMenuPop();
						choice = myVal.validIntRange("\n\tPress 4 for to return.  \n\nWhat extras would you like to order? \nSelection: ", 1, 4);
						overwrite = false;
						//=====================================If you want to overwrite a selection======================================================
						if (choice > 0 && choice < 4)
						{
							for (int j = 0; j<extraOrderType.size(); j++)  
							{	
								
								if (extraOrderType.get(j).equals(extraType[choice-1])) 
								{
									amount = myVal.validInt("\nHow many would you like?: ");	
									extraOrderAmount.set(j, amount);
									extraOrderCost.set(j, extraCost[choice-1]*amount);
									
									My.p(String.format("%d \"%s\" will cost £%.2f\n\n", extraOrderAmount.get(j), extraOrderType.get(j), extraOrderCost.get(j)));
									
								overwrite = true;
								//arrCount--;
								} 
							}
						}
						
						if (choice < 4 && !overwrite)
						{
						
						extraOrderType.add(extraType[choice-1]);						//1st of 3 receipt extraArray
						My.p("(Hint: you can reselect an extra type to overwrite amount requested)");
						amount = myVal.validInt("\nHow many would you like?: ");		//2nd of 3 receipt extraArray
						
						extraOrderAmount.add(amount);
						extraOrderCost.add(extraCost[choice-1]*amount);					//3rd of 3 receipt extraArray
						
						My.p(String.format("%d \"%s\" will cost £%.2f\n\n", extraOrderAmount.get(arrCount), extraOrderType.get(arrCount), extraOrderCost.get(arrCount)));
						arrCount++;
						
						}
					}while(choice !=4);
					
					for (int k = 0; k<arrCount; k++)
					{
						My.pln(String.format("Type: %s Amount: %d Cost £%.2f", extraOrderType.get(k), extraOrderAmount.get(k), extraOrderCost.get(k)));
					}
				}
		}
	}

}
