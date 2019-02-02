package BonanzaCore.Core;

import BonanzaCore.Core.Entities.Card;
import BonanzaGame.GamePlayer;

import java.util.List;


/**
 * The class 'TableManager' handles the task of trading between players
 * @version 1
 * @author Arthur K
 */
public class TradingManager
{
    public GamePlayer currentGamePlayer;
    public GamePlayer dealPartner;
    public List<GamePlayer> watingList;

    public void addToWaitingList(GamePlayer gamePlayer)
    {
      //implementation here
    }

    public void removeFromWaitingList(GamePlayer gamePlayer)
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
