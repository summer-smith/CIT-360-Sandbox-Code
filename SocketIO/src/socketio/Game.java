package socketio;
/**
 * Sets up a two-player tic-tac-toe game
 * @author Summer
 */
public class Game {
    Player currentPlayer;
    //set up an empty 3x3 board
    private Player [] board = {
        null, null, null,
        null, null, null,
        null, null, null};
    
    //Singleton - because only one game should be instantiated per session
    public Game getInstance(){
        return this;
    }
    //determines if someone has one based on the current board configuration
    public boolean hasWinner() {
        return
            (board[0] != null && board[0] == board[1] && board[0] == board[2])
          ||(board[3] != null && board[3] == board[4] && board[3] == board[5])
          ||(board[6] != null && board[6] == board[7] && board[6] == board[8])
          ||(board[0] != null && board[0] == board[3] && board[0] == board[6])
          ||(board[1] != null && board[1] == board[4] && board[1] == board[7])
          ||(board[2] != null && board[2] == board[5] && board[2] == board[8])
          ||(board[0] != null && board[0] == board[4] && board[0] == board[8])
          ||(board[2] != null && board[2] == board[4] && board[2] == board[6]);
    } 

    public boolean catGame() {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == null) {
                return false;
            }
        }
        return true;
    }

    /*
    * keep the game synchronized - in order for the move to be valid, 
    * it must be the players turn, and the square must be empty
    */
    public synchronized boolean legalMove(int location, Player player) {
        if (player == currentPlayer && board[location] == null) {
            board[location] = currentPlayer;
            currentPlayer = currentPlayer.opponent;
            currentPlayer.opponentMoved(location);
            return true;
        }
        return false;
    }    

}
