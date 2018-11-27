package BonanzaGame.Entities;

import BonanzaGame.Core.Enums.CardTypes;
import BonanzaGame.Entities.Reward;

import java.awt.*;
import java.awt.font.ImageGraphicAttribute;
import java.util.List;

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
