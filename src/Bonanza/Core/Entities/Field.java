package Bonanza.Core.Entities;

import java.util.ArrayList;
import java.util.List;

/**
 * The class 'Field' depicts a model of a player's harvest field
 * Each player starts with two fields, is able to buy a third one, and plants and harvests bean cards from these fields
 * @version 1
 * @author Arthur K
 */
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
