package BonanzaGame.Core;

import BonanzaGame.Entities.Card;

import java.util.List;


/**
 * The class 'TableManager' handles the task of trading between players
 * @version 1
 * @author Arthur K
 */
public class TradingManager
{
    public Player currentPlayer;
    public Player dealPartner;
    public List<Player> watingList;

    public void addToWaitingList(Player player)
    {
      //implementation here
    }

    public void removeFromWaitingList(Player player)
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
