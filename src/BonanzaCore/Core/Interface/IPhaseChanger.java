package BonanzaCore.Core.Interface;

import BonanzaCore.Core.HumanPlayer;
import BonanzaCore.Core.AbstractLayer.PlayerState;

public interface IPhaseChanger {
     PlayerState nextState(HumanPlayer player);
}
