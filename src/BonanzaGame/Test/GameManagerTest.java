package BonanzaGame.Test;

import BonanzaGame.Core.CoreGameManager;
import BonanzaGame.CoreGameModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Test;

public class GameManagerTest {

    Injector injector = Guice.createInjector(new CoreGameModule() );

    CoreGameManager gameManager = injector.getInstance( CoreGameManager.class );


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