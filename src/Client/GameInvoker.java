package Client;
import BonanzaCore.Core.AbstractLayer.Gui.GuiManager;
import Extension.Mafia.Core.View.MafiaGuiManager;
import io.bitbucket.plt.sdp.bohnanza.gui.Color;
import io.bitbucket.plt.sdp.bohnanza.gui.GUI;
import io.bitbucket.plt.sdp.bohnanza.gui.Size;

/**
 * The class 'GameInvoker' handles the task of starting the game in the console and simulates one round in the game until the deck is empty
 * It creates a GameManager object and asks the user for an input, one of which starts the game
 * Shows the game implementation and includes dependency injection
 * @version 1
 * @author Arthur K
 */
public class GameInvoker {
    /**
     * Main method that simulates one round of a game
     * Asks user for input whether to start a new game and prints out all turn phases to the console
     */
    public static void main(String[] args) {

        GUI gui = new GUI(
                new Size(1015, 850),
                new Size(80, 100),
                new Color(50,50,50),
                new Color(255,255,255));

        //Injector injector = Guice.createInjector(new BonanzaGameModule() );

        //BonanzaGameManager gameManager = injector.getInstance( BonanzaGameManager.class );

        //IGameManager MafiagameManager = injector.getInstance( MafiaGameManager.class );

        //Start new BonanzaGame ---> Mafia

        //MafiagameManager.startNewGame();


        try {

            GuiManager mafiaGuiManager= new MafiaGuiManager(gui);
            new Thread(mafiaGuiManager).start();
            gui.start();

/*            Scanner input = new Scanner(System.in);
            System.out.println("Welcome to the BonanzaCore");
            int selection;

            do {
                System.out.println("[1] Start New BonanzaGame");
                System.out.println("[2] Exit");
                System.out.println("[3] Start Mafia Extension BonanzaGame");
                System.out.println("Insert Selection: ");
                selection = input.nextInt();

                switch (selection) {
                    case 1:
                        System.out.println("Started BonanzaGame");
                        gameManager.startNewGame();
                        *//*
                        for (int i = 0; i < 100; i++){

                        }
                         *//*
                        break;
                    case 2:
                        System.exit(0);
                        break;
                    case 3:
                        System.out.println("Start Mafia Extension BonanzaGame");
                        MafiaGameManager extension = new MafiaGameManager(gui);
                        extension.startNewGame();
                        new Thread(extension).start();
                        gui.start();
                        //MafiagameManager.startNewGame();
                        break;
                    case 4:

                    default:
                        System.out.println("The Selection is invalid");
                }
            } while (selection != 2);*/
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
}