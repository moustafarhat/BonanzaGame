package BonanzaCore.Core.TurnState;


import BonanzaCore.Core.AbstractLayer.BonanzaPlayerState;
import BonanzaCore.Core.Enums.TurnPhases;
import BonanzaCore.Core.HumanPlayer;
import BonanzaCore.Core.AbstractLayer.Table;

public class LockedState extends BonanzaPlayerState {

    public LockedState(HumanPlayer player) {
        super(player);
        player.setPlaying(false);
        turnPhase= TurnPhases.LOCKED;
    }

    @Override
    public Boolean onLock() {
        return null;
    }

    @Override
    public Boolean onTrading() {
        return null;
    }


    @Override
    public Boolean onDrawing(Table table, int count) {
        return null;
    }

    @Override
    public Boolean onPlanting(int fieldIndex)  {
        return null;
    }
}
