package BonanzaGame;

import BonanzaGame.Core.CoreGameManager;
import com.google.inject.AbstractModule;

/**
 *
 * @version 1
 * @author Moustafa Farhat , Author
 */
public class CoreGameModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(IGameManager.class).to(CoreGameManager.class);
    }
}
