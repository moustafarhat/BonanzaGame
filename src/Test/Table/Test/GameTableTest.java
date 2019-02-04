package Test.Table.Test;
import BonanzaCore.Core.Enums.CardTypes;
import Bonanza.Game.GameTable;
import BonanzaCore.Core.Entities.Card;
import org.junit.Test;
import org.junit.Assert;

public class GameTableTest
{

    GameTable gameTable = new GameTable();
    @Test
    public void discardPileTest()
    {
        Assert.assertEquals(gameTable.discardPile().size(), 0);
    }

    @Test
    public void drawPileTest1()
    {
        Assert.assertEquals(104, gameTable.drawPile().size());
    }

    @Test
    public void drawPileTest2()
    {
        GameTable gameTable = new GameTable();
        int redBeanCount = 0;
        for (Card card : gameTable.drawPile()){
            if (card.getCardType() == CardTypes.REDBEAN){
                redBeanCount++;
            }
        }
        Assert.assertEquals(8, redBeanCount);
    }

    @Test
    public void playerListTest()
    {
        GameTable gameTable =new GameTable();
        Assert.assertEquals(gameTable.playerList().size(), 0);
    }
}
