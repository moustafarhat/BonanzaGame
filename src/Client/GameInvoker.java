package Client;
import BonanzaCore.Core.AbstractLayer.Gui.GameStarter;
import BonanzaCore.Core.AbstractLayer.Gui.GuiManager;
import BonanzaCore.Core.Interface.IGameStarter;
import Extension.Mafia.Core.View.MafiaGuiManager;
import io.bitbucket.plt.sdp.bohnanza.gui.Color;
import io.bitbucket.plt.sdp.bohnanza.gui.GUI;
import io.bitbucket.plt.sdp.bohnanza.gui.Size;

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

        IGameStarter game=new GameStarter();
        game.startNewGame();
       /* GUI gui = new GUI(
                new Size(1015, 850),
                new Size(80, 100),
                new Color(50,50,50),
                new Color(255,255,255));
        try {
            GuiManager mafiaGuiManager= new MafiaGuiManager(gui);
            new Thread(mafiaGuiManager).start();
            gui.start();
            }

        catch (Exception ex)
        {
            System.out.println(ex);
        }*/
    }
}