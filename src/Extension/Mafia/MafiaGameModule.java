package Extension.Mafia;

import BonanzaCore.Core.Interface.IGameManager;
import Extension.Mafia.Core.MafiaGameManager;
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
        bind(IGameManager.class).to(MafiaGameManager.class);
    }
}
