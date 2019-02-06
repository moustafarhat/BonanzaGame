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

    @Override
    public String onGiveBeansToMafia() {
        return null;
    }

    @Override
    public String onRevealFromPile() {
        return null;
    }
}
