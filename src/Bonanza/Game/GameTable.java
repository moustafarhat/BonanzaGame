package Bonanza.Game;

import Bonanza.Core.AbstractLayer.Table;

public class GameTable extends Table {

    public GameTable()
    {
        maxPlayerCount = 5;
    }

    @Override
    public String toString() {
        return "GameTable Class";
    }
}
