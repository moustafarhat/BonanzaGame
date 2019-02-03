package BonanzaCore.Core.TurnState;

import BonanzaCore.Core.HumanPlayer;
import BonanzaCore.Core.AbstractLayer.Table;
import BonanzaCore.Core.TradingManager;

public class TradingState extends PlayerState
{

    TradingState(HumanPlayer player) {
        super(player);
        player.setPlaying(false);
    }

    @Override
    public String onLock() {
        return null;
    }


    @Override
    public String onTrading() {
        return null;
    }

    @Override
    public String onDrawing(Table table, int count) {
        return null;
    }

    @Override
    public String onPlanting(int fieldIndex)  {
        return null;
    }

    public TradingManager startTrading()
    {
        return null;
    }

    public void finishTrading()
    {
        //implementation here
    }
}
