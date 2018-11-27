package Client;
import BonanzaGame.Core.GameManager;
import BonanzaGame.Core.Interfaces.IGameManager;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GameInvoker {
    public static void main(String[] args) {
        //Console console = System.console();

        /*if (console == null) {
            System.out.println("Console is not supported");
            System.exit(1);
        }*/

        //Test1
        try {
            Scanner input = new Scanner(System.in);

            System.out.println("Welcome to the BonanzaGame");

            int selection;

            do {
                System.out.println("[1] Option1");
                System.out.println("[2] Option2");
                System.out.println("[3] Option3");
                System.out.println("[4] Option4");
                System.out.println("Insert Selection: ");
                selection = input.nextInt();

                switch (selection) {
                    case 1:
                        System.out.println("Option1");
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


            //IGameManager gameManager= new GameManager();

            //gameManager.startNewGame();

        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }
    }
}
