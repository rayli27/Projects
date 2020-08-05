import java.util.Scanner;

public class GoodTicBot {
	String[] board;
	Scanner scanner;
	int choice;
	String com = "O";
	String human = "X";
	
	public GoodTicBot() {
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
			comSecondMove();
		} else {
			comFirstMove();
		}
	}
	
	public void comSecondMove() {
		printBoard();
		while(checkWinner() != +10 || checkWinner() != -10) {
			humanMove();
			if(checkWinner() == -10) {
				System.out.println("You Win");
				break;
			}
			
			if(!movesLeft()) {
				System.out.println("Tie");
				break;
			}
			
			comMove();
			if(checkWinner() == +10) {
				System.out.println("You Lose");
			}
		}
	}
	
	public void comFirstMove() {
		printBoard();
		while(checkWinner() != +10 || checkWinner() != -10) {
			comMove();
			if(checkWinner() == +10) {
				System.out.println("You Lose");
				break;
			}
			
			if(!movesLeft()) {
				System.out.println("Tie");
				break;
			}
			
			humanMove();
			if(checkWinner() == -10) {
				System.out.println("You Win");
			}
		}
	}
	
	public void humanMove() {
		System.out.println("Your Turn! Pick the number of your move:");
		choice = scanner.nextInt();
		while(board[choice-1].equals(com) || board[choice-1].equals(human)) {
			System.out.println("Invalid move. Pick again:");
			choice = scanner.nextInt();
		}
		
		board[choice-1] = human;
		printBoard();
	}
	
	public void comMove() {
		board[bestMove()] = com;
		printBoard();
	}
	
	public int bestMove() {
	    int bestVal = Integer.MIN_VALUE; 
	    int bestMove = -1;
	  

	    for(int i = 0; i<9; i++) {
	    	if(board[i].equals(String.valueOf(i+1))) {
                board[i] = com; 
                int moveVal = minimax(0, false); 
                board[i] = (String.valueOf(i+1));
	  
                if (moveVal > bestVal) { 
                    bestMove = i; 
                    bestVal = moveVal; 
                } 
	    	}
	    }
	    
	    return bestMove;
	}
	
	public int minimax(int depth, boolean isCom) {
		int score = checkWinner();
		
		if (score == 10) {
	        return score; 
		}
	  
	    if (score == -10) {
	        return score; 
	    }

	    if (!movesLeft()) {
	        return 0; 
	    }
	    
	    if (isCom) { 
	        int best = -1000; 
	  
		    for(int i = 0; i<9; i++) {
		    	if(board[i].equals(String.valueOf(i+1))) {
		                board[i] = com; 
	                    best = Math.max(best, minimax(depth + 1, !isCom)); 
	                    board[i] = (String.valueOf(i+1));
		    	}
		    } 
	        return best; 
	    } 
	  

	    else { 
	        int best = 1000; 
	  
		    for(int i = 0; i<9; i++) {
		    	if(board[i].equals(String.valueOf(i+1))) {
		                board[i] = human; 
	                    best = Math.min(best, minimax(depth + 1, !isCom)); 
	                    board[i] = (String.valueOf(i+1));
		    	}
	        } 
	        return best; 
	    } 
	}
	
	public int checkWinner() {		
		for(int a = 0; a < 8; a++) {
			String line = null;
			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			if (line.equals(com+com+com)) {
				return +10;
			} else if (line.equals(human+human+human)) {
				return -10;
			} 
		}

		return 0;
	}
	
	public boolean movesLeft() {
	    for(int i = 0; i<9; i++) {
	    	if(board[i].equals(String.valueOf(i+1))) {
	    		return true;
	    	}
	    }
	    return false;
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