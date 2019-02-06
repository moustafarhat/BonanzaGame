package BonanzaCore.Core.TurnState;

import BonanzaCore.Core.AbstractLayer.Player;
import BonanzaCore.Core.AbstractLayer.Table;
import BonanzaCore.Core.HumanPlayer;
import BonanzaCore.Core.Enums.TurnPhases;

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
