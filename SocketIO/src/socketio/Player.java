package socketio;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
/**
 *
 * @author Summer
 */
public class Player extends Thread{
    Game game;
    char mark;
    Player opponent;
    Socket socket;
    BufferedReader input;
    PrintWriter output;
    
    //Constructor
    public Player(Socket socket, char mark, Game game){
        this.socket = socket;
        this.mark = mark;
        this.game = game;
        try {  // Construct a thread to handle the passed-in socket
                input = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
                output = new PrintWriter(socket.getOutputStream(), true);
                output.println("WELCOME " + mark);
                output.println("MESSAGE Waiting for opponent to connect");
            } catch (IOException e) {
                System.out.println("Player died: " + e);
            }
    }
    
    //Setter
    public void setOpponenet(Player opponent){
        this.opponent = opponent;
    }
    
    public void opponentMoved(int location){
        this.opponent = opponent;
        output.println("OPPONENT_MOVED " + location);
        output.println(
            game.hasWinner() ? "DEFEAT" : game.catGame() ? "TIE" : ""); 
    }
    
    public void run() {
        try {
            // The thread is only started after everyone connects.
            output.println("MESSAGE All players connected");

            // Tell the first player that it is her turn.
            if (mark == 'X') {
                output.println("MESSAGE Your move");
            }

            // Repeatedly get commands from the client and process them.
            while (true) {
                String command = input.readLine();
                if (command.startsWith("MOVE")) {
                    int location = Integer.parseInt(command.substring(5));
                    if (game.legalMove(location, this)) {
                        output.println("VALID_MOVE");
                        output.println(game.hasWinner() ? "VICTORY"
                                     : game.catGame() ? "TIE"
                                     : "");
                    } else {
                        output.println("MESSAGE ?");
                    }
                } else if (command.startsWith("QUIT")) {
                    return;
                }
            }
        } catch (IOException e) {
             System.out.println("Player died: " + e);
        } finally {
            try {socket.close();} catch (IOException e) {}
        }
    }
}