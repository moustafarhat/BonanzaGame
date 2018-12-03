package Client;
import BonanzaGame.Core.GameManager;
import BonanzaGame.GameModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.Scanner;

public class GameInvoker {
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
