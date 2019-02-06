package Test.PlayerState.Test;

import BonanzaCore.Core.AbstractLayer.Player;
import BonanzaCore.Core.Enums.GameMode;
import BonanzaCore.Core.Enums.TurnPhases;
import BonanzaCore.Core.HumanPlayer;
import BonanzaCore.Core.TurnState.BonanzaPlayerState;
import BonanzaCore.Core.TurnState.PhaseChanger;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GamePlayerStateTest
{
 @Test
    public void TestBonanzaTurnPhases() {

     HumanPlayer player;
     player = new HumanPlayer("Mohammad",1);

     player.setGameMode(GameMode.BonanzaGame);


     TurnPhases phases1=player.nextState().getTurnPhase();


     assertEquals(TurnPhases.PLANTING,phases1);

     TurnPhases phases2=player.nextState().getTurnPhase();

     assertEquals(TurnPhases.TRADING, phases2);

     TurnPhases phases3=player.nextState().getTurnPhase();

     assertEquals(TurnPhases.DRAWING,phases3);

     TurnPhases phases4=player.nextState().getTurnPhase();

     assertEquals(TurnPhases.LOCKED, phases4);

     TurnPhases phases5=player.nextState().getTurnPhase();

     assertEquals(TurnPhases.PLANTING, phases5);


    }


    @Test
    public void TestMafiaTurnPhases() {

        HumanPlayer player;
        player = new HumanPlayer("Mohammad",1);

        player.setGameMode(GameMode.MafiaGame);


        TurnPhases phases1=player.nextState().getTurnPhase();


        assertEquals(TurnPhases.GIVEBEANSTOMAFIA,phases1);

        TurnPhases phases2=player.nextState().getTurnPhase();

        assertEquals(TurnPhases.PLANTING, phases2);

        TurnPhases phases3=player.nextState().getTurnPhase();

        assertEquals(TurnPhases.REVEALFROMPILE,phases3);

        TurnPhases phases4=player.nextState().getTurnPhase();

        assertEquals(TurnPhases.DRAWING, phases4);

        TurnPhases phases5=player.nextState().getTurnPhase();

        assertEquals(TurnPhases.LOCKED, phases5);


    }

}
