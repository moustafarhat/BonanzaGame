package Bonanza.Core.AbstractLayer;

import Bonanza.Core.Enums.TurnPhases;
import Bonanza.Core.Entities.Card;

import java.util.ArrayList;
import java.util.List;

abstract public class HumanPlayer extends Player {

    protected List<Card> hand;
    protected List<Card> tradingArea;
    protected int position;
    protected TurnPhases turnPhase;

    protected HumanPlayer(){
        this.hand = new ArrayList<>();
        this.tradingArea = new ArrayList<>();
    }

    //-------- Methods for the GamePlayer's handcards ----------
    public List<Card> getHand() { return hand; }

    abstract public void addCardsToHand(List<Card> cards);

    //-------- Methods for the GamePlayer's trading area ----------
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

    abstract public boolean startTrading(boolean playerWantsToTrade);

    abstract public void plantAnotherCard(boolean playersChoice, int fieldPosition);

    abstract public boolean buyField();

    abstract public boolean plant(Card card, int fieldPosition);

    abstract public List<Card> harvest(int fieldPosition);
}
