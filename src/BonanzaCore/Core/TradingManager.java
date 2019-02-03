package BonanzaCore.Core;

import BonanzaCore.Core.Entities.Card;

import java.util.List;


/**
 * The class 'TableManager' handles the task of trading between players
 * @version 1
 * @author Arthur K
 */
public class TradingManager
{
    public HumanPlayer currentGamePlayer;
    public HumanPlayer dealPartner;
    public List<HumanPlayer> watingList;

    public void addToWaitingList(HumanPlayer humanPlayer)
    {
      //implementation here
    }

    public void removeFromWaitingList(HumanPlayer humanPlayer)
    {
      //implementation here
    }

    public void setNextDealPartner()
    {
      //implementation here
    }

    public void deal(Card currentPlayerCard, Card dealPlayerCards)
    {
      //implementation here
    }

    @Override
    public String toString() {
        return "TradingManager Class";
    }
}
