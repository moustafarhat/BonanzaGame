package BonanzaGame.Test;
import BonanzaGame.Core.Table;
import org.junit.Test;
import org.junit.Assert;

public class TableClassTest
{
    @Test
    public void discardPileTest()
    {
        Table table=new Table();
        Assert.assertNull(table.discardPile());
    }

    @Test
    public void drawPileTest()
    {
        Table table=new Table();
        Assert.assertNull(table.drawPile());
    }

    @Test
    public void isPlayerTest()
    {
        Table table=new Table();
        Assert.assertNull(table.isPlayer());
    }
}
