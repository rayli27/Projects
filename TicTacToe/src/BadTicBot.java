import java.util.Scanner;

public class BadTicBot {
	String[] board;
	Scanner scanner;
	int choice;
	int count;
	
	public BadTicBot() {
		board = new String[9];
		scanner = new Scanner(System.in);
		
		emptyBoard();
		System.out.println("Would you like 1st move or 2nd?");
		choice = scanner.nextInt();
		
		while(choice != 1 && choice != 2) {
				System.out.println("Choice not valid. Input int 1 or 2");
				choice = scanner.nextInt();
		}
		
		if(choice == 1) {
			secondMove();
		} else {
			firstMove();
		}
	}
	
	public void firstMove() {
		while(!checkWinner()) {
			bestMove();
			if(checkWinner()) {
				System.out.println("You Lose");
				break;
			}
			if(count == 9) {
				System.out.println("Tie");
				break;
			}
			humanMove();
			if(checkWinner()) {
				System.out.println("You Win");
			}
		}
	}
	
	public void secondMove() {
		printBoard();
		while(!checkWinner()) {
			humanMove();
			if(checkWinner()) {
				System.out.println("You Win");
				break;
			}
			if(count == 9) {
				System.out.println("Tie");
				break;
			}
			bestMove();
			if(checkWinner()) {
				System.out.println("You Lose");
			}
		}
	}
	
	public void bestMove() {
		finishBlock();
		while(checkTaken()) {
			prioritizeMove();
		}
		board[choice-1] = "X";
		count++;
		printBoard();
	}
	
	public void randomMove() {
		while(checkTaken()) {
			choice = (int)(Math.random()*9) + 1;
		}
		board[choice-1] = "O";
		count++;
		printBoard();
	}
	
	public void humanMove() {
		System.out.println("Your Turn! Pick the number of your move:");
		choice = scanner.nextInt();
		while(choice<=1 && choice>=9 && checkTaken()) {
			System.out.println("Invalid move. Pick again:");
			choice = scanner.nextInt();
		}
		
		board[choice-1] = "O";
		count++;
		printBoard();
	}
	
	public void finishBlock() {
		for (int a = 0; a < 24; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = board[0] + board[1];
				choice = 3;
				break;
			case 1:
				line = board[0] + board[2];
				choice = 2;
				break;
			case 2:
				line = board[1] + board[2];
				choice = 1;
				break;
			case 3:
				line = board[3] + board[4];
				choice = 6;
				break;
			case 4:
				line = board[3] + board[5];
				choice = 5;
				break;
			case 5:
				line = board[4] + board[5];
				choice = 4;
				break;
			case 6:
				line = board[6] + board[7];
				choice = 9;
				break;
			case 7:
				line = board[6] + board[8];
				choice = 8;
				break;
			case 8:
				line = board[7] + board[8];
				choice = 7;
				break;
			case 9:
				line = board[0] + board[3];
				choice = 7;
				break;
			case 10:
				line = board[0] + board[6];
				choice = 4;
				break;
			case 11:
				line = board[3] + board[6];
				choice = 1;
				break;
			case 12:
				line = board[1] + board[4];
				choice = 8;
				break;
			case 13:
				line = board[1] + board[7];
				choice = 5;
				break;
			case 14:
				line = board[4] + board[7];
				choice = 2;
				break;
			case 15:
				line = board[2] + board[5];
				choice = 9;
				break;
			case 16:
				line = board[2] + board[8];
				choice = 6;
				break;
			case 17:
				line = board[5] + board[8];
				choice = 3;
				break;
			case 18:
				line = board[0] + board[4];
				choice = 9;
				break;
			case 19:
				line = board[0] + board[8];
				choice = 5;
				break;
			case 20:
				line = board[4] + board[8];
				choice = 1;
				break;
			case 21:
				line = board[2] + board[4];
				choice = 7;
				break;
			case 22:
				line = board[2] + board[6];
				choice = 5;
				break;
			case 23:
				line = board[4] + board[6];
				choice = 3;
				break;
			}
			if (line.equals("XX")) {
				if(!checkTaken()) {
					System.out.println("gottem");
					break;
				}
			} else if (line.equals("OO")) {
				if(!checkTaken()) {
					System.out.println("blocked");
					break;
				}
			}
		}
	}
	
	public void prioritizeMove() {
		for(int i = 0; i < 10; i++) {
			switch(i) {
			case 1:
				choice = 1;
				break;
			case 2:
				choice = 9;
				break;
			case 3:
				choice = 3;
				break;
			case 4:
				choice = 7;
				break;
			case 5:
				choice = 5;
				break;
			case 6:
				choice = 2;
				break;
			case 7:
				choice = 4;
				break;
			case 8:
				choice = 6;
				break;
			case 9:
				choice = 8;
				break;
			}
			
			if(!checkTaken()) {
				break;
			}
		}

	}

	public boolean checkTaken() {
		if(board[choice-1] == "X" || board[choice-1] == "O") {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean checkWinner() {		
		if((board[0]+board[1]+board[2]).equals("XXX") || (board[0]+board[1]+board[2]).equals("OOO")) {
			return true;
		} else if((board[3]+board[4]+board[5]).equals("XXX") || (board[3]+board[4]+board[5]).equals("OOO")) {
			return true;
		} else if((board[6]+board[7]+board[8]).equals("XXX") || (board[6]+board[7]+board[8]).equals("OOO")) {
			return true;
		} else if((board[0]+board[3]+board[6]).equals("XXX") || (board[0]+board[3]+board[6]).equals("OOO")) {
			return true;
		} else if((board[1]+board[4]+board[7]).equals("XXX") || (board[1]+board[4]+board[7]).equals("OOO")) {
			return true;
		} else if((board[2]+board[5]+board[8]).equals("XXX") || (board[2]+board[5]+board[8]).equals("OOO")) {
			return true;
		} else if((board[0]+board[4]+board[8]).equals("XXX") || (board[0]+board[4]+board[8]).equals("OOO")) {
			return true;
		} else if((board[2]+board[4]+board[6]).equals("XXX") || (board[2]+board[4]+board[6]).equals("OOO")) {
			return true;
		} else {
			return false;
		}
	}
	
	public void printBoard() {
		System.out.println();
		System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2] + " ");
		System.out.println("-----------");
		System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
		System.out.println("-----------");
		System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " ");
	}
	
	public void emptyBoard() {
		for(int i = 0; i<9; i++) {
			board[i] = String.valueOf(i+1);
		}
	}
}
