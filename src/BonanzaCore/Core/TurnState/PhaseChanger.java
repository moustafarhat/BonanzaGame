package BonanzaCore.Core.TurnState;

import BonanzaCore.Core.AbstractLayer.PlayerState;
import BonanzaCore.Core.HumanPlayer;
import BonanzaCore.Core.Interface.IPhaseChanger;

public class PhaseChanger
{
    public static PlayerState phaseChanger(IPhaseChanger phaseChanger, HumanPlayer player)
    {
       return phaseChanger.nextState(player);
    }
}
