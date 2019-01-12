package BonanzaGame.Core;

import BonanzaGame.Entities.Card;

import java.util.ArrayList;
import java.util.List;

abstract public class AbstractHumanPlayer extends AbstractPlayer {

    protected List<Card> hand;
    protected List<Card> tradingArea;
    protected int position;
    protected AbstractHumanPlayer(){
        this.hand = new ArrayList<>();
        this.tradingArea = new ArrayList<>();
    }

    //-------- Methods for the Player's handcards ----------
    public List<Card> getHand() { return hand; }

    abstract public void addCardsToHand(List<Card> cards);

    //-------- Methods for the Player's trading area ----------
    public void addCardsToTradingArea(List<Card> cardsToTrade){
        //When a player e.g draws two cards in his trading phase this method puts them into his trading area
        for (Card card : cardsToTrade){
            System.out.println("Card " + card.getCardType() + " put in trading area");
        }
        this.tradingArea.addAll(cardsToTrade);
    }

    public void removeFromTadingArea(List<Card> cards){
        this.tradingArea.removeAll(cards);
    }

    public List<Card> getTradingArea() { return tradingArea; }

    public int getPosition() { return position; }

    abstract protected boolean startTrading(boolean playerWantsToTrade);

    abstract protected void plantAnotherCard(boolean playersChoice, int fieldPosition);

    abstract protected boolean buyField();

    abstract protected boolean plant(Card card, int fieldPosition);

    abstract protected List<Card> harvest(int fieldPosition);
}
