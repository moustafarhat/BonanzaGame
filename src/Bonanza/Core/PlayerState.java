package Bonanza.Core;

import Bonanza.Game.Player;

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
