package Extension.Mafia.MafiaTurnState;

import BonanzaCore.Core.AbstractLayer.Table;
import BonanzaCore.Core.Enums.TurnPhases;
import BonanzaCore.Core.HumanPlayer;
import Extension.Mafia.Core.AbstractLayer.MafiaPlayerState;

public class RevealFromPileState extends MafiaPlayerState {
    public RevealFromPileState(HumanPlayer player) {
        super(player);
        turnPhase= TurnPhases.REVEALFROMPILE;
    }

    @Override
    public Boolean onGiveBeansToMafia() {
        return null;
    }

    @Override
    public Boolean onRevealFromPile() {
        return null;
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
}
