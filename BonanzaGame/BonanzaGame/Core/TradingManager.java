package BonanzaGame.Core;

import BonanzaGame.Entities.Card;

import java.util.List;

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
