package BonanzaGame.Core;

import BonanzaGame.Entities.GameSettingItem;

import java.util.List;

/**
 * The class 'GameSettings' describes user customizable settings for the game
 * It includes a collection of GameSettingItems which are able to tweak certain game variables
 * @version 1
 * @author Arthur K
 */
public class GameSettings  {

    private static GameSettings instance;

    private GameSettings(){}

    public static synchronized GameSettings getInstance()
    {
        if(instance == null)
        {
            instance = new GameSettings();
        }
        return instance;
    }

    private List<GameSettingItem> items() {
        return null;
    }

    private void setSettingValus(String key, String value) {
        //implementation here
    }

    private String getSettingValue(String key) {
        return null;
    }

    @Override
    public String toString() {
        return "GameSettings Class";
    }
}
