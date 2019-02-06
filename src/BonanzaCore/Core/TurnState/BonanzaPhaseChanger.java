package BonanzaCore.Core.TurnState;

import BonanzaCore.Core.AbstractLayer.Player;
import BonanzaCore.Core.Enums.TurnPhases;
import BonanzaCore.Core.HumanPlayer;

public class BonanzaPhaseChanger implements IPhaseChanger {
    @Override
    public PlayerState nextState(HumanPlayer player) {
        TurnPhases turnPhase = player.getPlayerState().turnPhase;
        PlayerState playerState;
        if (turnPhase == TurnPhases.LOCKED) {
            playerState = new PlantingState(player);
            player.changeState(playerState);
        } else if (turnPhase == TurnPhases.PLANTING) {
            playerState = new TradingState(player);
            player.changeState(playerState);

        } else if (turnPhase == TurnPhases.TRADING) {
            playerState = new DrawingState(player);
            player.changeState(playerState);
        } else {
            playerState = new LockedState(player);
            player.changeState(playerState);
        }
        return playerState;

    }
}
