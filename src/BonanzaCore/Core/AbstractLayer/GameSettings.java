package BonanzaCore.Core.AbstractLayer;

import BonanzaCore.Core.Entities.GameSettingItem;

import java.util.List;

/**
 * The class 'GameSettings' describes user customizable settings for the game
 * It includes a collection of GameSettingItems which are able to tweak certain game variables
 * @version 1
 * @author Arthur K
 */
public abstract class GameSettings  {

    public abstract List<GameSettingItem> Settings() ;

    @Override
    public String toString() {
        return "Abstract GameSettings ";
    }
}
