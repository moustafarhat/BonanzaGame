package BonanzaGame.Test;

import BonanzaGame.Core.GameManager;
import BonanzaGame.GameModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameManagerTest {

    Injector injector = Guice.createInjector(new GameModule() );
    
    GameManager gameManager = injector.getInstance( GameManager.class );


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