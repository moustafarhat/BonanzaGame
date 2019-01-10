package BonanzaGame.Test;

import BonanzaGame.Core.Enums.CardTypes;
import BonanzaGame.Entities.Card;
import org.junit.Assert;
import org.junit.Test;

public class CardClassTest
{
    @Test
    public void maxNumberTest()
    {
        Card card= new Card(CardTypes.REDBEAN);
        card.setMaxCardNumber(20);
        int Result = card.getMaxCardNumber();
        Assert.assertEquals(19, Result);
    }

    @Test
    public void maxNumberTest2()
    {
        Card card= new Card(CardTypes.BLUEBEAN);
        card.setMaxCardNumber(20);
        int Result = card.getMaxCardNumber();
        Assert.assertEquals(20, Result);
    }
}
