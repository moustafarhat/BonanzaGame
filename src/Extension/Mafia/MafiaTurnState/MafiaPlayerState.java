package Extension.Mafia.MafiaTurnState;

import BonanzaCore.Core.AbstractLayer.Table;
import BonanzaCore.Core.Enums.TurnPhases;
import BonanzaCore.Core.HumanPlayer;
import BonanzaCore.Core.TurnState.*;

public abstract class MafiaPlayerState extends PlayerState {
    public MafiaPlayerState(HumanPlayer player) {
        super(player);

    }

    public abstract Boolean onLock();
    public abstract Boolean onDrawing(Table table, int count);
    public abstract Boolean onPlanting(int fieldIndex);
    public abstract Boolean onGiveBeansToMafia();
    public abstract Boolean onRevealFromPile();

  /*  @Override
    public void nextState(HumanPlayer player) {
 if(turnPhase== TurnPhases.LOCKED)
        {
            player.setPlayerState(new GiveBeansToMafiaState(getHumanPlayer()));
        }
        else if(turnPhase== TurnPhases.GIVEBEANSTOMAFIA)
        {
            player.setPlayerState(new PlantingState(getHumanPlayer()));
        }
        else if(turnPhase== TurnPhases.PLANTING)
        {
            player.setPlayerState(new RevealFromPileState(getHumanPlayer()));
        }
        else if(turnPhase== TurnPhases.REVEALFROMPILE)
        {
            player.setPlayerState(new DrawingState(getHumanPlayer()));
        }
        else
        {
            player.setPlayerState(new LockedState(getHumanPlayer()));
        }

    }*/
}
