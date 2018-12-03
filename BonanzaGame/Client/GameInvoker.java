package Client;
import BonanzaGame.Core.GameManager;
import BonanzaGame.GameModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.Scanner;

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

        Injector injector = Guice.createInjector(new GameModule() );
        GameManager gameManager = injector.getInstance( GameManager.class );

        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome to the BonanzaGame");
            int selection;

            do {
                System.out.println("[1] Start New Game");
                System.out.println("[2] Option2");
                System.out.println("[3] Option3");
                System.out.println("[4] Exit");
                System.out.println("Insert Selection: ");
                selection = input.nextInt();

                switch (selection) {
                    case 1:
                        System.out.println("Started Game");
                        gameManager.startNewGame();
                        break;
                    case 2:
                        System.out.println("Option2");
                        break;
                    case 3:
                        System.out.println("Option3");
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("The Selection is invalid");
                }
            } while (selection != 4);
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
}
