package Extension.Mafia.MafiaTurnState;

import BonanzaCore.Core.AbstractLayer.Table;
import BonanzaCore.Core.Enums.TurnPhases;
import BonanzaCore.Core.HumanPlayer;
import BonanzaCore.Core.TurnState.PlayerState;

public class GiveBeansToMafiaState extends MafiaPlayerState {
    public GiveBeansToMafiaState(HumanPlayer player) {
        super(player);
        turnPhase= TurnPhases.GIVEBEANSTOMAFIA;
    }

    @Override
    public Boolean onLock() {
        return null;
    }



    @Override
    public Boolean onDrawing(Table table, int count) {
        return null;
    }

    @Override
    public Boolean onPlanting(int fieldIndex) {
        return null;
    }

    @Override
    public Boolean onGiveBeansToMafia() {
        return null;
    }

    @Override
    public Boolean onRevealFromPile() {
        return null;
    }
}
