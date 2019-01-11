package BonanzaGame;

import BonanzaGame.Core.CoreGameManager;
import com.google.inject.AbstractModule;
import com.google.inject.binder.LinkedBindingBuilder;

/**
 *
 * @version 1
 * @author Moustafa Farhat , Author
 */
public class CoreGameModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(IMainGameManager.class).to(CoreGameManager.class);
    }
}
