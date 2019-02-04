package Extension.Mafia.MafiaTurnState;

import BonanzaCore.Core.AbstractLayer.Table;
import BonanzaCore.Core.HumanPlayer;

public class GiveBeansToMafiaState extends MafiaPlayerState {
    public GiveBeansToMafiaState(HumanPlayer player) {
        super(player);
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
