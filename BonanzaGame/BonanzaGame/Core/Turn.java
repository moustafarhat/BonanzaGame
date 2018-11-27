package BonanzaGame.Core;

import BonanzaGame.Core.Enums.TurnPhases;
import BonanzaGame.Entities.Card;
import BonanzaGame.Entities.Player;

import java.util.List;

public class Turn
{
    private Player _currentPlayer;
    private TurnPhases _currentPhase;

    public void plant(int fieldPosition)
    {
      //implementation here
    }

    public List<Card> harvest(int fieldPosition)
    {
        return null;
      //implementation here
    }

    public TradingManager startTrading()
    {
       return null;
    }

    public void finishTrading()
    {
      //implementation here
    }

    public void giveGift(Player player, Card giftCards)
    {
      //implementation here
    }

    public void buyField()
    {
      //implementation here
    }

}
