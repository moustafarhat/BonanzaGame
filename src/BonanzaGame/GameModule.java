package BonanzaGame;

import BonanzaGame.Core.GameManager;
import BonanzaGame.Core.Interfaces.IGameManager;
import com.google.inject.AbstractModule;
import com.google.inject.binder.LinkedBindingBuilder;

/**
 *
 * @version 1
 * @author Moustafa Farhat , Author
 */
public class GameModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(IGameManager.class).to(GameManager.class);
    }
}
