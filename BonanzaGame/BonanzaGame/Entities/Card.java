package BonanzaGame.Entities;

import BonanzaGame.Core.Enums.CardTypes;
import BonanzaGame.Entities.Reward;

import java.util.List;

public class Card
{
    private int _maxCardNumber;

    public int getMaxCardNumber()
    {
        return _maxCardNumber;
    }

    public void setMaxCardNumber(int maxCardNumber)
    {
        this._maxCardNumber = maxCardNumber;
    }

    public CardTypes types()
    {
        return null;
    }

    public List<Reward> rewards()
    {
        return null;
    }
}
