package Bonanza.Test;

import Bonanza.Game.BonanzaGameManager;
import Bonanza.Game.BonanzaGameModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

public class GameManagerTest {

    Injector injector = Guice.createInjector(new BonanzaGameModule() );

    BonanzaGameManager gameManager = injector.getInstance( BonanzaGameManager.class );


    @Test
    public void startNewGame() {
    }

    @Test
    public void getWinner() {
    }

    @Test
    public void draw() {

    }
}