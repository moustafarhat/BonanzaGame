package BonanzaGame.Test;
import BonanzaGame.Core.Enums.CardTypes;
import BonanzaGame.Core.Table;
import BonanzaGame.Entities.Card;
import org.junit.Test;
import org.junit.Assert;

public class TableClassTest
{

    Table table = new Table();
    @Test
    public void discardPileTest()
    {

        Assert.assertEquals(table.discardPile().size(), 0);
    }

    @Test
    public void drawPileTest1()
    {
        Assert.assertEquals(104, table.drawPile().size());
    }

    @Test
    public void drawPileTest2()
    {
        Table table = new Table();
        int redBeanCount = 0;
        for (Card card : table.drawPile()){
            if (card.getCardType() == CardTypes.REDBEAN){
                redBeanCount++;
            }
        }
        Assert.assertEquals(8, redBeanCount);
    }

    @Test
    public void playerListTest()
    {
        Table table=new Table();
        Assert.assertEquals(table.playerList().size(), 4);
    }
}
