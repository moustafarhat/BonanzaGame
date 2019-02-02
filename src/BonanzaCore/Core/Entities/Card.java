package BonanzaCore.Core.Entities;

import BonanzaCore.Core.Enums.CardTypes;

import java.util.List;

/**
 * The class 'Card' depicts a model of a real card that players play with and the deck, discard pile, trading areas etc. are filled with
 * A card has one CardType which gives information about the Rewards (eg. 3 cards are worth 1 coin) and the
 * number of occurences in the card deck (or draw pile)
 * @version 1
 * @author Arthur K
 */
public class Card
{
    private CardTypes cardType;
    private int maxCardCount;
    private List<Reward> rewards;
    //private Image image;


    public Card(CardTypes cardType) {
        this.cardType = cardType;
        this.maxCardCount = cardType.getMaxCardCount();
        this.rewards = cardType.getRewards();
    }

    public int getMaxCardNumber()
    {
        return maxCardCount;
    }

    public void setMaxCardNumber(int maxCardCount)
    {
        this.maxCardCount = maxCardCount;
    }

    public CardTypes getCardType()
    {
        return this.cardType;
    }

    public List<Reward> getRewards()
    {
        return this.rewards;
    }
}
