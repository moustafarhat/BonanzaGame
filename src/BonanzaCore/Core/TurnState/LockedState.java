package BonanzaCore.Core.TurnState;


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
}
