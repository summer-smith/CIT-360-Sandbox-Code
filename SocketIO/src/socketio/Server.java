package socketio;

import java.net.ServerSocket;

/**
 *
 * @author Summer
 */
public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket listener = new ServerSocket(8901);
        System.out.println("Server running");
        try{
            while (true) {
                Game game = new Game();
                        Player playerX = new Player(listener.accept(), 'X', game);
                        Player playerO = new Player(listener.accept(), 'O', game);
                        playerX.setOpponenet(playerO);
                        playerO.setOpponenet(playerX);
                        
                        //X always goes first....
                        game.currentPlayer = playerX;
                        playerX.start();
                        playerO.start();
            }
        }finally {
            listener.close();
        }
    }
    
}
