package Extension.Mafia.MafiaTurnState;

import BonanzaCore.Core.Enums.TurnPhases;
import BonanzaCore.Core.HumanPlayer;
import BonanzaCore.Core.TurnState.PlayerState;

public abstract class MafiaPlayerState extends PlayerState {
    public MafiaPlayerState(HumanPlayer player) {
        super(player);
    }

    public abstract String onGiveBeansToMafia();
    public abstract String onRevealFromPile();

    @Override
    public void nextState() {
        if(player.getTurnPhase()== TurnPhases.LOCKED)
        {
            player.setTurnPhase(TurnPhases.GIVEBEANSTOMAFIA);
        }
        else if(player.getTurnPhase()== TurnPhases.GIVEBEANSTOMAFIA)
        {
            player.setTurnPhase(TurnPhases.PLANTING);
        }
        else if(player.getTurnPhase()== TurnPhases.PLANTING)
        {
            player.setTurnPhase(TurnPhases.REVEALFROMPILE);
        }
        else if(player.getTurnPhase()== TurnPhases.REVEALFROMPILE)
        {
            player.setTurnPhase(TurnPhases.DRAWING);
        }
        else
        {
            player.setTurnPhase(TurnPhases.LOCKED);
        }

    }
}
