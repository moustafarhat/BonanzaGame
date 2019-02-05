package Client;
import BonanzaCore.Core.AbstractLayer.Gui.GameStarter;
import BonanzaCore.Core.Interface.IGameStarter;

/**
 * The class 'GameInvoker' handles the task of starting the game in the console and simulates one round in the game until the deck is empty
 * It creates a GameManager object and asks the user for an input, one of which starts the game
 * Shows the game implementation and includes dependency injection
 * @version 2
 * @author Moustafa Farhat
 */
public class GameInvoker {
    /**
     * Main method that simulates one round of a game
     * Asks user for input whether to start a new game and prints out all turn phases to the console
     */
    public static void main(String[] args) {

        try
        {
            IGameStarter game=new GameStarter();
            game.startNewGame();

        }

        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
}