package Extensions.Mafia;

import BonanzaGame.IGameManager;
import Extensions.Mafia.Core.MafiaExtension;
import com.google.inject.AbstractModule;

/**
 *
 * @version 1
 * @author Moustafa Farhat , Author
 */
public class MafiaGameModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(IGameManager.class).to(MafiaExtension.class);
    }
}
