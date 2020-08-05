import java.util.Scanner;

public class TwoPlayer {
	String[] board;
	Scanner scanner;
	String turn;
	
	
	public TwoPlayer() {
		board = new String[9];
		scanner = new Scanner(System.in);
		turn = "X";
		boolean winner = false;
		int count = 0;
		int choice;
		
		emptyBoard();
		printBoard();
		System.out.println("Pick the number of your move: ");
		choice = scanner.nextInt();
		
		while(!winner) {
			if(choice>=1 && choice<=9 && board[choice-1] != "X" && board[choice-1] != "O") {
				board[choice-1] = turn;
				count++;
				winner = checkWinner();
				printBoard();
				if(winner || count == 9) {
					if(winner) {
						System.out.println(turn + " wins!");
					} else {
						System.out.println("Tie!");
					}
					break;
				}
				switchTurn();
				System.out.println("Switch Turns! Pick the number of your move: ");

			} else {
				System.out.println("Invalid move. Pick again:");
			}
			choice = scanner.nextInt();
		}		
	}
	
	public boolean checkWinner() {		
		if((board[0]+board[1]+board[2]).equals(turn+turn+turn)) {
			return true;
		} else if((board[3]+board[4]+board[5]).equals(turn+turn+turn)) {
			return true;
		} else if((board[6]+board[7]+board[8]).equals(turn+turn+turn)) {
			return true;
		} else if((board[0]+board[3]+board[6]).equals(turn+turn+turn)) {
			return true;
		} else if((board[1]+board[4]+board[7]).equals(turn+turn+turn)) {
			return true;
		} else if((board[2]+board[5]+board[8]).equals(turn+turn+turn)) {
			return true;
		} else if((board[0]+board[4]+board[8]).equals(turn+turn+turn)) {
			return true;
		} else if((board[2]+board[4]+board[6]).equals(turn+turn+turn)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void switchTurn() {
		if(turn == "X") {
			turn = "O";
		} else {
			turn = "X";
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
