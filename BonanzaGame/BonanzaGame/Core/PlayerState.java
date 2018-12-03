package BonanzaGame.Core;

import BonanzaGame.Core.Enums.TurnPhases;
import BonanzaGame.Entities.Card;

import java.util.List;

public abstract class PlayerState
{
    public PlayerState(Player player)
    {}

    public abstract String onLock();
    public abstract String onReady();
    public abstract String onTrading();
    public abstract String onDrawing();
    public abstract String onPlanting();



}
