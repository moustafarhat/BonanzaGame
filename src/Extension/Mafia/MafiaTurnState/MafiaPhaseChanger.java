package Extension.Mafia.MafiaTurnState;

import BonanzaCore.Core.Enums.TurnPhases;
import BonanzaCore.Core.HumanPlayer;
import BonanzaCore.Core.TurnState.*;

public class MafiaPhaseChanger implements IPhaseChanger {
    @Override
    public PlayerState nextState(HumanPlayer player) {

        TurnPhases turnPhase = player.getPlayerState().getTurnPhase();
        PlayerState playerState;
        if (turnPhase == TurnPhases.LOCKED) {
            playerState = new GiveBeansToMafiaState(player);
            player.changeState(playerState);
        } else if (turnPhase == TurnPhases.GIVEBEANSTOMAFIA) {
            playerState = new PlantingState(player);
            player.changeState(playerState);

        } else if (turnPhase == TurnPhases.PLANTING) {
            playerState = new RevealFromPileState(player);
            player.changeState(playerState);
        } else if (turnPhase == TurnPhases.REVEALFROMPILE){
            playerState = new DrawingState(player);
            player.changeState(playerState);
        }
        else
        {
            playerState = new LockedState(player);
            player.changeState(playerState);
        }
        return playerState;



        /*if(turnPhase== TurnPhases.LOCKED)
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
        }*/
    }
}
