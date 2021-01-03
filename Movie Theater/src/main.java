
/*
 * Author: Danny H Duong
 * NetID: dhd170001
 * 
 * */
import java.io.*;
import java.lang.reflect.Array;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class main {
	public static void main(String[] args) throws FileNotFoundException {

		System.out.println("You are reading files from the directory: " + System.getProperty("user.dir"));
		File folder = new File(System.getProperty("user.dir"));
		File[] listOfFiles = folder.listFiles();
		int adultTickets = 0, childTickets = 0, seniorTickets = 0, totalSeatsInAuditorium = 0, rowsInTheater = 0, columnsInTheater = 0, iteration = 1;
		char[][] auditorium = new char[10][26];
		for (char[] row: auditorium)
		    Arrays.fill(row, ' ');
		// char[] theater = new char[100];
		// create the list
		ArrayList<Theater> myList = new ArrayList<Theater>();
		for (int i = 0; i < listOfFiles.length; i++) {
			File file = listOfFiles[i];
			// numOfAuditorium++;

			if (file.isFile() && file.getName().toLowerCase().endsWith(".txt")) {
				// Reads the first file

				// numOfAuditorium++;

				auditorium = new char[10][26];
				for (char[] row: auditorium)
				    Arrays.fill(row, ' ');

				Scanner input = new Scanner(file);

				int size = 0;
				char aChar = 'a';
				int row = 0;
				while (input.hasNext()) {
					int column = 0;

					String lol = input.next();

					for (int index = 0; index < lol.length(); index++) {
						aChar = lol.charAt(index);
						auditorium[row][column] = aChar;
						// System.out.print(auditorium[row][column]);
						column++;
					}
					// }
					// System.out.println();
					row++;
				}
				// add the 2D arrays to the list
				myList.add(new Theater(auditorium));
				// System.out.println(auditorium[3][7]);

			} else {
				// numOfAuditorium--;
			}

		}

		System.out.println("1. Reserve Seats");
		System.out.println("2. Exit");
		Scanner input = new Scanner(System.in);
		int userChoice = input.nextInt();
		if (userChoice == 1) {
			while (userChoice == 1){
			int	numOfAuditorium = 0;
			for (Theater theater : myList) 
			{
				numOfAuditorium++;
				System.out.println("Theater " + numOfAuditorium);
				theater.GetFormattedDesc();
				totalSeatsInAuditorium = theater.TotalSeats();
			}
			System.out.println("Here are the theaters available above");
			System.out.println("The dots(.) means an empty seat while a pound/hashtag(#) is a seat that has already been reserved");
			System.out.println("Please select one of the theaters above by its number: ");
			int userTheater = input.nextInt();
			int numOfTheater = 0;
			for (Theater theaterChoice : myList) 
			{
				numOfTheater++;
				if(userTheater == numOfTheater) 
				{
					System.out.println("Theater " + numOfTheater);
					theaterChoice.GetDescOfUser(userTheater);
					rowsInTheater = theaterChoice.getRow();
					columnsInTheater = theaterChoice.getColumn();
				}
				else 
				{
					System.out.println("");
				}
				
			}
			System.out.println("The theater displayed above is the theater you selected");
			System.out.println("You will now begin reserving your seat. Please keep in mind when reserving multiple seats that the system reserves seats from left to right");
			System.out.println("Please type in the row number that you want to be seated at to begin your reservation: ");
			int userRow = input.nextInt();
			if(userRow>rowsInTheater) 
			{
				while(userRow > rowsInTheater) {
				System.out.println("Please enter a valid row number this time: ");
				userRow = input.nextInt();
				}
			}
			System.out.println("Now please type in the letter that you want to be seated at: ");
			String userString = input.next();
			char userLetter = 'a';
			if((userString.length() > 1) || (userString.length() == 0))
			{
				System.out.println("You did not enter a valid letter, only a word");
				while((userString.length() > 1) || (userString.length() == 0)) 
				{
					System.out.println("Please enter a valid letter: ");
					userString = input.next();
				}
			}
			
			for (int index = 0; index < userString.length(); index++) 
			{
			userLetter = userString.charAt(index);
			}

			System.out.println("Next, enter in the number of Adult Tickets you wish to purchase: ");
			int userAdultTickets = input.nextInt();
			if(userAdultTickets<0) 
			{
				while(userAdultTickets<0) 
				{
					System.out.println("Please enter a valid number of Adult Tickets: ");
					userAdultTickets = input.nextInt();
				}
			}
			System.out.println("Enter in the number of Children Tickets you wish to purchase: ");
			int userChildTickets = input.nextInt();
			if(userChildTickets<0) 
			{
				while(userChildTickets<0) 
				{
					System.out.println("Please enter a valid number of Adult Tickets: ");
					userChildTickets = input.nextInt();
				}
			}
			System.out.println("Finally, enter in the number of Senior Tickets you wish to purchase: ");
			int userSeniorTickets = input.nextInt();
			if(userSeniorTickets<0) 
			{
				while(userSeniorTickets<0) 
				{
					System.out.println("Please enter a valid number of Adult Tickets: ");
					userSeniorTickets = input.nextInt();
				}
			}
			int listOfTheater = 0;
			boolean bool = false;
			for (Theater theaterChoice : myList) 
			{
				listOfTheater++;
				if(userTheater == listOfTheater) 
				{
					bool = theaterChoice.checkSeats(userRow, userLetter, userAdultTickets, userChildTickets, userSeniorTickets, iteration);
				}
				else 
				{
					System.out.println("");
				}
				
			}
			//test
			int num = 0;
			for (Theater theaterChoice : myList) 
			{
				num++;
				if(userTheater == num) 
				{
					System.out.println("Theater " + num);
					theaterChoice.GetDescOfUser(userTheater);
				}
				else 
				{
					System.out.println("");
				}
				
			}
			if(bool == true) {
			adultTickets += userAdultTickets;
			childTickets += userChildTickets;
			seniorTickets += userSeniorTickets;
			}
			else 
			{
				int secondCheckList = 0;
				for (Theater finalCheck : myList) 
				{
					secondCheckList++;
					if(userTheater == secondCheckList) 
					{
						for (int x = 0; x < finalCheck.getColumn(); x++)
						bool = finalCheck.checkSeats(userRow, userLetter++, userAdultTickets, userChildTickets, userSeniorTickets, iteration++);
					}
					else 
					{
						System.out.println("");
					}
					
				}
				adultTickets = 0;
				childTickets = 0;
				seniorTickets = 0;
			}
			System.out.println("1. Reserve More Seats?");
			System.out.println("2. Exit");
			userChoice = input.nextInt();
			}
			double totalSale = (adultTickets*10.0)+(childTickets*5.0)+(seniorTickets*7.5);
			System.out.println("You have exited the program");
			System.out.println("Total Seats in Auditorium: " + totalSeatsInAuditorium);
			System.out.println("Total Tickets Sold: " + (adultTickets+childTickets+seniorTickets));
			System.out.println("Adult Tickets Sold: " + adultTickets);
			System.out.println("Children Tickets Sold: " + childTickets);
			System.out.println("Senior Tickets Sold: " + seniorTickets);
			System.out.println("Total Ticket Sales: " + totalSale);
		}
		else if (userChoice == 2) 
		{
			System.out.println("You have exited the program");
		}
		else 
		{
			System.out.println("You did not enter a valid number, you have now exited the program");
		}

	}
}