package BonanzaCore.Core.AbstractLayer;

import BonanzaCore.Core.Entities.Card;
import BonanzaCore.Core.Entities.Field;
import BonanzaCore.Core.Entities.Reward;
import BonanzaCore.Core.HumanPlayer;

import java.util.ArrayList;
import java.util.List;

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
