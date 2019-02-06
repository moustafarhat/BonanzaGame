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
   protected TurnPhases turnPhase;
    public PlayerState(HumanPlayer player)
    {
        this.player=player;
        turnPhase=TurnPhases.LOCKED;
    }

    public PlayerState() {

    }

    public HumanPlayer getHumanPlayer(){return player;}

    public TurnPhases getTurnPhase(){return turnPhase;}


    public void setHumanPlayer(HumanPlayer player){this.player=player;}






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



}
