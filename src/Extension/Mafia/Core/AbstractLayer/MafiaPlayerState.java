package Extension.Mafia.Core.AbstractLayer;

import BonanzaCore.Core.AbstractLayer.PlayerState;
import BonanzaCore.Core.AbstractLayer.Table;
import BonanzaCore.Core.HumanPlayer;

public abstract class MafiaPlayerState extends PlayerState {
    public MafiaPlayerState(HumanPlayer player) {
        super(player);

    }

    public abstract Boolean onLock();
    public abstract Boolean onDrawing(Table table, int count);
    public abstract Boolean onPlanting(int fieldIndex);
    public abstract Boolean onGiveBeansToMafia();
    public abstract Boolean onRevealFromPile();

}
