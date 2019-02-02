package BonanzaCore.Core.TurnState;

import BonanzaGame.GamePlayer;

public abstract class PlayerState
{
    public PlayerState(GamePlayer gamePlayer)
    {}

    public abstract String onLock();
    public abstract String onReady();
    public abstract String onTrading();
    public abstract String onDrawing();
    public abstract String onPlanting();


}
