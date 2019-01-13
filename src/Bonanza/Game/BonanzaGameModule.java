package Bonanza.Game;

import Bonanza.Core.Interface.IGameManager;
import com.google.inject.AbstractModule;

/**
 *
 * @version 1
 * @author Moustafa Farhat , Author
 */
public class BonanzaGameModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(IGameManager.class).to(BonanzaGameManager.class);
    }
}
