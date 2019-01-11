package Extensions.Mafia;

import BonanzaGame.IMainGameManager;
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
        bind(IMainGameManager.class).to(MafiaExtension.class);
    }
}
