package BonanzaCore.Core.TurnState;

import BonanzaCore.Core.HumanPlayer;
import BonanzaCore.Core.AbstractLayer.Table;
import BonanzaCore.Core.Entities.Card;
import BonanzaCore.Core.Entities.Field;
import BonanzaCore.Core.Enums.TurnPhases;
import java.util.List;

public abstract class PlayerState
{
   protected HumanPlayer player;
    public PlayerState(HumanPlayer player)
    {
        this.player=player;
    }

    public HumanPlayer getHumanPlayer(){return player;}

    public void setHumanPlayer(HumanPlayer player){this.player=player;}

    public abstract String onLock();
    public abstract String onTrading();
    public abstract String onDrawing(Table table, int count);
    public abstract String onPlanting(int fieldIndex);





    public static void giveGift(HumanPlayer player, List<Card> giftCards)
    {
        //implementation here
    }

    public boolean buyField(){
        //Check if player has enough coins to buy another field
        if (getHumanPlayer().treasury.size() >= 3){
            //If yes add a new field to this player's Array of fields and remove 3 cards (= coins) from player's treasury
            //todo may need to change this method with other return type cause removed cards from treasury need to be placed into discardPile probably?
            this.getHumanPlayer().fields.add(new Field());
            this.getHumanPlayer().treasury.remove(0);
            this.getHumanPlayer().treasury.remove(0);
            this.getHumanPlayer().treasury.remove(0);
            System.out.println("GamePlayer bought a new field");
            return true;
        }
        System.out.println("GamePlayer couldn't buy a new field");
        return false;
    }


    public void nextState()
    {

        if(player.getTurnPhase()== TurnPhases.LOCKED)
        {
            player.setTurnPhase(TurnPhases.PLANTING);
        }
        else if(player.getTurnPhase()== TurnPhases.PLANTING)
        {
            player.setTurnPhase(TurnPhases.TRADING);
        }
        else if(player.getTurnPhase()== TurnPhases.TRADING)
        {
            player.setTurnPhase(TurnPhases.DRAWING);
        }
        else
        {
            player.setTurnPhase(TurnPhases.LOCKED);
        }

    }


}
