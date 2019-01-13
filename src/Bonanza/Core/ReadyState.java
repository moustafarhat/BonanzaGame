package Bonanza.Core;

import Bonanza.Core.Entities.Card;
import Bonanza.Game.GamePlayer;

import java.util.List;

public class ReadyState extends PlayerState {

    public ReadyState(GamePlayer gamePlayer) {
        super(gamePlayer);
        gamePlayer.setPlaying(false);
    }

    @Override
    public String onLock() {
        return null;
    }

    @Override
    public String onReady() {
        return null;
    }

    @Override
    public String onTrading() {
        return null;
    }

    @Override
    public String onDrawing() {
        return null;
    }

    @Override
    public String onPlanting() {
        return null;
    }

    public List<Card> harvest(int fieldPosition)
    {
        return null;
        //implementation here
    }



    public void giveGift(GamePlayer gamePlayer, Card giftCards)
    {
        //implementation here
    }

    public void buyField()
    {
        //implementation here
    }
}
