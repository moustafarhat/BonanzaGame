package BonanzaGame.Core;

import BonanzaGame.Entities.GameSettingItem;

import java.util.List;

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
