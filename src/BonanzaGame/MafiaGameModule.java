package BonanzaGame;

import Extensions.Mafia.MafiaExtension;
import com.google.inject.AbstractModule;
import com.google.inject.binder.LinkedBindingBuilder;

/**
 *
 * @version 1
 * @author Moustafa Farhat , Author
 */
public class MafiaGameModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(IMainGameManager.class).to(MafiaExtension.class);
    }
}
