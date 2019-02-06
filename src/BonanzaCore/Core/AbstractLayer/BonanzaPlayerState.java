package BonanzaCore.Core.AbstractLayer;

import BonanzaCore.Core.HumanPlayer;

public abstract class BonanzaPlayerState extends PlayerState
{

    public BonanzaPlayerState(HumanPlayer player)
    {
        super(player);
    }

    public abstract Boolean onLock();
    public abstract Boolean onTrading();
    public abstract Boolean onDrawing(Table table, int count);
    public abstract Boolean onPlanting(int fieldIndex);
}
