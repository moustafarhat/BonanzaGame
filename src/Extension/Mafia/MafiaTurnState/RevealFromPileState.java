package Extension.Mafia.MafiaTurnState;

import BonanzaCore.Core.AbstractLayer.Table;
import BonanzaCore.Core.Enums.TurnPhases;
import BonanzaCore.Core.HumanPlayer;

public class RevealFromPileState extends MafiaPlayerState {
    public RevealFromPileState(HumanPlayer player) {
        super(player);
        turnPhase= TurnPhases.REVEALFROMPILE;
    }

    @Override
    public String onGiveBeansToMafia() {
        return null;
    }

    @Override
    public String onRevealFromPile() {
        return null;
    }

    @Override
    public String onLock() {
        return null;
    }



    @Override
    public String onDrawing(Table table, int count) {
        return null;
    }

    @Override
    public String onPlanting(int fieldIndex) {
        return null;
    }
}
