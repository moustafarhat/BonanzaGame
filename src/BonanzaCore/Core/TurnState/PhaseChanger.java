package BonanzaCore.Core.TurnState;

import BonanzaCore.Core.HumanPlayer;

public class PhaseChanger
{
    public static PlayerState phaseChanger(IPhaseChanger phaseChanger, HumanPlayer player)
    {
       return phaseChanger.nextState(player);
    }
}
