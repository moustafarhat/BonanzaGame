package BonanzaCore.Core.TurnState;

import BonanzaCore.Core.AbstractLayer.Player;
import BonanzaCore.Core.HumanPlayer;

public interface IPhaseChanger {
    public PlayerState nextState(HumanPlayer player);
}
