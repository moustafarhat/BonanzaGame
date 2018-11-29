package BonanzaGame.Entities;

import BonanzaGame.Entities.Card;

import java.util.ArrayList;
import java.util.List;

public class Field
{
    private List<Card> cards;

    public List<Card> getCards()
    {
        return cards;
    }

    public Field() {
        this.cards = new ArrayList<>();
    }

    public Field(List<Card> cards) {
        this.cards = cards;
    }

    public boolean addCardToField(Card card){
        if (!cards.isEmpty()){
            if (card.getCardType().equals(cards.get(0).getCardType())){
                cards.add(card);
                return true;
            }
            return false;
        } else cards.add(card);
        return true;
    }

}
