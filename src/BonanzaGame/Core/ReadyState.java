package BonanzaGame.Core;

import BonanzaGame.Entities.Card;

import java.util.List;

public class ReadyState extends PlayerState {

    ReadyState(Player player) {
        super(player);
        player.setPlaying(false);
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



    public void giveGift(Player player, Card giftCards)
    {
        //implementation here
    }

    public void buyField()
    {
        //implementation here
    }
}
