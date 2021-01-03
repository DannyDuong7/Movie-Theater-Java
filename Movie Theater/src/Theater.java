import java.util.Scanner;
public class Theater {

	char[][] arrayT;

	Theater() {
	}

	public Theater(char[][] newArray) {
		arrayT = null;
		arrayT = newArray;
	}
	
	int TotalSeats() {
		int columnNum = 1;
		char rowLet = 'A';
		int columnTotal = 0, rowTotal = 0; 
		for (int column = 0; column < arrayT[0].length; column++) {
			if (arrayT[0][column] != ' ') {
				columnTotal++;
			} else {
				break;
			}
		}
		for (int row = 0; row < arrayT.length; row++) {
			if (arrayT[row][0] != ' ') {

			} else {
				break;
			}
			for (int column = 0; column < arrayT[row].length; column++) {

				if ((arrayT[row][column] == 'A') || (arrayT[row][column] == 'C') || (arrayT[row][column] == 'S')) {
				} else {
				}
			}
			if (arrayT[row][0] != ' ') {
			} else {
				break;
			}
			rowTotal++;
		}
		return rowTotal*columnTotal;

	}
	
	int getRow() {
		int columnNum = 1;
		char rowLet = 'A';
		int columnTotal = 0, rowTotal = 0; 
		for (int column = 0; column < arrayT[0].length; column++) {
			if (arrayT[0][column] != ' ') {
				columnTotal++;
			} else {
				break;
			}
		}
		for (int row = 0; row < arrayT.length; row++) {
			if (arrayT[row][0] != ' ') {

			} else {
				break;
			}
			for (int column = 0; column < arrayT[row].length; column++) {

				if ((arrayT[row][column] == 'A') || (arrayT[row][column] == 'C') || (arrayT[row][column] == 'S')) {
				} else {
				}
			}
			if (arrayT[row][0] != ' ') {
			} else {
				break;
			}
			rowTotal++;
		}
		return rowTotal;

	}
	
	int getColumn() {
		int columnNum = 1;
		char rowLet = 'A';
		int columnTotal = 0, rowTotal = 0; 
		for (int column = 0; column < arrayT[0].length; column++) {
			if (arrayT[0][column] != ' ') {
				columnTotal++;
			} else {
				break;
			}
		}
		for (int row = 0; row < arrayT.length; row++) {
			if (arrayT[row][0] != ' ') {

			} else {
				break;
			}
			for (int column = 0; column < arrayT[row].length; column++) {

				if ((arrayT[row][column] == 'A') || (arrayT[row][column] == 'C') || (arrayT[row][column] == 'S')) {
				} else {
				}
			}
			if (arrayT[row][0] != ' ') {
			} else {
				break;
			}
			rowTotal++;
		}
		return columnTotal;

	}

	void GetFormattedDesc() {
		int columnNum = 1;
		char rowLet = 'A';
		//int columnTotal = 0, rowTotal = 0; 
		System.out.print("  ");
		for (int column = 0; column < arrayT[0].length; column++) {
			if (arrayT[0][column] != ' ') {
				System.out.print(rowLet++);
				//columnTotal++;
			} else {
				break;
			}
		}
		System.out.println();
		for (int row = 0; row < arrayT.length; row++) {
			if (arrayT[row][0] != ' ') {
				System.out.print(columnNum++);
				System.out.print(" ");
			} else {
				break;
			}
			for (int column = 0; column < arrayT[row].length; column++) {

				if ((arrayT[row][column] == 'A') || (arrayT[row][column] == 'C') || (arrayT[row][column] == 'S')) {
					System.out.print('#');
				} else {
					System.out.print(arrayT[row][column]);
				}

			}
			if (arrayT[row][0] != ' ') {
				System.out.println();
			} else {
				break;
			}
			//rowTotal++;
		}

	}

	void GetDescOfUser(int userChoice) {
		int columnNum = 1;
		char rowLet = 'A';
		System.out.print("  ");
		for (int column = 0; column < arrayT[0].length; column++) {
			if (arrayT[0][column] != ' ') {
				System.out.print(rowLet++);
			} else {
				break;
			}
		}
		System.out.println();
		for (int row = 0; row < arrayT.length; row++) {
			if (arrayT[row][0] != ' ') {
				System.out.print(columnNum++);
				System.out.print(" ");
			} else {
				break;
			}
			for (int column = 0; column < arrayT[row].length; column++) {

				if ((arrayT[row][column] == 'A') || (arrayT[row][column] == 'C') || (arrayT[row][column] == 'S')) {
					System.out.print('#');
				} else {
					System.out.print(arrayT[row][column]);
				}

			}
			if (arrayT[row][0] != ' ') {
				System.out.println();
			} else {
				break;
			}
		}
	}

	boolean seatsForCustomers(int rowU, int columnU, int totalC) 
	{
		boolean check = false;
			//for(int j = 0; j < arrayT[rowU].length; j++) 
			//{
				if(arrayT[rowU][columnU] == '.') 
				{
					for(int j = 1; j < totalC; j++) 
					{
						if(arrayT[rowU][columnU+j] == '.') 
						{
							check = true;
						}
						else if ((arrayT[rowU][columnU + j] == 'A') || (arrayT[rowU][columnU + j] == 'C')
								|| (arrayT[rowU][columnU + j] == 'S')) 
						{
							check = false;
							break;
						} 
					}
				}
				else 
				{
					check = false;
				}
			//}
		return check;
	}
	
	
	boolean checkSeats(int rowUser, char columnUser, int userA, int userC, int userS, int iteration) {
		boolean bool = false;
		int totalCustomers = userA + userC + userS;
		int columnLower = 0;
		int columnUpper = 0;
		boolean check = false;
		for (char start = 'a'; start <= 'z'; start++) {
			if (columnUser == start) {
				break;
			} else {
				columnLower++;
			}
		}

		for (char start = 'A'; start <= 'Z'; start++) {
			if (columnUser == start) {
				break;
			} else {
				columnUpper++;
			}
		}

		for (int indexL = 0; indexL <= totalCustomers; indexL++) {
			for (int row = 0; row < arrayT.length; row++) {

				for (int column = 0; column < arrayT[row].length; column++) {

					if ((row == rowUser - 1) && ((column == columnUpper) || (column == columnLower))) {
						// for (int addIndex = 0; addIndex < arrayT[row].length; addIndex++)
						// {
						if (arrayT[row][column] == '.') {
							
							check = seatsForCustomers(row, column, totalCustomers);
							
							if (check == true) {
								if(iteration == 1) {
								if (userA > 0) {
									//System.out.println("Seat reserved");
									arrayT[row][column] = 'A';
									userA--;
									} else if (userC > 0) {
									//System.out.println("Seat reserved");
									arrayT[row][column] = 'C';
									userC--;
									} else if (userS > 0) {
									//System.out.println("Seat reserved");
									arrayT[row][column] = 'S';
									userS--;
									}
								}
								else 
								{
									System.out.println("This is the next best option, at row " + rowUser + " column " + columnUser + " do you want to reserve this? Type Y or N");
									Scanner userInput = new Scanner(System.in);
									String newChoice = userInput.next();
									char userLetter = 'a';
									if((newChoice.length() > 1) || (newChoice.length() == 0))
									{
										System.out.println("You did not enter a valid letter, only a word");
										while((newChoice.length() > 1) || (newChoice.length() == 0) || ((newChoice != "Y") || (newChoice != "N"))) 
										{
											System.out.println("Please enter a valid letter: ");
											newChoice = userInput.next();
										}
									}
									
									for (int index = 0; index < newChoice.length(); index++) 
									{
									userLetter = newChoice.charAt(index);
									}
									
									if(userLetter == 'Y') 
									{
										if (userA > 0) {
											//System.out.println("Seat reserved");
											arrayT[row][column] = 'A';
											userA--;
											} else if (userC > 0) {
											//System.out.println("Seat reserved");
											arrayT[row][column] = 'C';
											userC--;
											} else if (userS > 0) {
											//System.out.println("Seat reserved");
											arrayT[row][column] = 'S';
											userS--;
											}
									}
									else if(userLetter == 'N')
									{
										System.out.println();
										System.out.println("There is not enough available seats for the amount of tickets you have");
										return bool;
									}
								}
								
							}
							else 
							{
								//System.out.println("There is not enough available seats for the amount of tickets you have");
								return bool;
							}
						} else if ((arrayT[row][column] == 'A') || (arrayT[row][column] == 'C')
								|| (arrayT[row][column] == 'S')) {
							//System.out.println("There is not enough seats for the amount of tickets you selected");
						}

					}
				}
			}
			columnLower++;
			columnUpper++;
		}
		return bool = true;
	}

}
