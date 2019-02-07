package Test.Table.Test;
import BonanzaCore.Core.Enums.CardTypes;
import Bonanza.Game.GameTable;
import BonanzaCore.Core.Entities.Card;
import BonanzaCore.Core.HumanPlayer;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;

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
        int blueBeanCount = 0;
        int greenBeanCount = 0;
        int blackEyedBeanCount = 0;
        for (Card card : gameTable.drawPile()){
            switch (card.getCardType()){
                case REDBEAN:
                    redBeanCount++;
                    continue;
                case BLUEBEAN:
                    blueBeanCount++;
                    continue;
                case GREENBEAN:
                    greenBeanCount++;
                    continue;
                case BLACKEYEDBEAN:
                    blackEyedBeanCount++;
            }
        }
        Assert.assertEquals(8, redBeanCount);
        Assert.assertEquals(20, blueBeanCount);
        Assert.assertEquals(14, greenBeanCount);
        Assert.assertEquals(10, blackEyedBeanCount);
    }

    @Test
    public void playerListTest()
    {
        GameTable gameTable =new GameTable();
        Assert.assertEquals(gameTable.playerList().size(), 0);
    }

    @Test
    public void addPlayer() {
        GameTable gameTable = new GameTable();
        gameTable.addPlayer("Player1", 1, 2);
        Assert.assertEquals(1, gameTable.getHumanPlayers().size());
        gameTable.addPlayer("Player2", 2, 2);
        Assert.assertEquals(2, gameTable.getHumanPlayers().size());
        gameTable.addPlayer("Player3", 3, 2);
        Assert.assertEquals(3, gameTable.getHumanPlayers().size());
        gameTable.addPlayer("Player4", 4, 2);
        Assert.assertEquals(4, gameTable.getHumanPlayers().size());
        gameTable.addPlayer("Player5", 5, 2);
        Assert.assertEquals(5, gameTable.getHumanPlayers().size());
        gameTable.addPlayer("Player6", 5, 2);
        Assert.assertEquals(5, gameTable.getHumanPlayers().size());
    }

    @Test
    public void addCardToDiscardPile() {
        GameTable gameTable = new GameTable();
        Assert.assertEquals(0,gameTable.discardPile().size());
        Assert.assertTrue(gameTable.addCardToDiscardPile(Arrays.asList()));
        Assert.assertTrue(gameTable.addCardToDiscardPile(Arrays.asList(new Card(CardTypes.BLACKEYEDBEAN), new Card(CardTypes.BLUEBEAN))));
        Assert.assertEquals(2, gameTable.discardPile().size());
    }

    @Test
    public void generateCards() {
        GameTable gameTable = new GameTable();
        Assert.assertEquals(104,gameTable.generateCards().size());
    }

    @Test
    public void fillDrawPileWithDiscardedCards() {
        GameTable gameTable = new GameTable();
        gameTable.addCardToDiscardPile(gameTable.generateCards());
        gameTable.setDeck(new ArrayList<>());
        Assert.assertEquals(0, gameTable.drawPile().size());
        Assert.assertTrue(gameTable.fillDrawPileWithDiscardedCards());
        Assert.assertEquals(104, gameTable.drawPile().size());
    }

    @Test
    public void setDeck() {
        GameTable gameTable = new GameTable();
        gameTable.setDeck(gameTable.generateCards());
        Assert.assertEquals(104, gameTable.drawPile().size());
        gameTable.setDeck(new ArrayList<>());
        Assert.assertEquals(0, gameTable.drawPile().size());
        gameTable.setDeck(Arrays.asList(new Card(CardTypes.BLUEBEAN), new Card(CardTypes.REDBEAN), new Card(CardTypes.BLUEBEAN),
                new Card(CardTypes.BLUEBEAN), new Card(CardTypes.BLACKEYEDBEAN)));
        Assert.assertEquals(5, gameTable.drawPile().size());
    }

    @Test
    public void removeCardFromDrawPile() {
        GameTable gameTable = new GameTable();
        Assert.assertEquals(104, gameTable.drawPile().size());
        Assert.assertTrue(gameTable.removeCardFromDrawPile(new Card(CardTypes.REDBEAN)));
        Assert.assertEquals(103, gameTable.drawPile().size());
        Assert.assertTrue(gameTable.removeCardFromDrawPile(new Card(CardTypes.BLUEBEAN)));
        Assert.assertTrue(gameTable.removeCardFromDrawPile(new Card(CardTypes.GREENBEAN)));
        Assert.assertTrue(gameTable.removeCardFromDrawPile(new Card(CardTypes.BLACKEYEDBEAN)));
        Assert.assertEquals(100, gameTable.drawPile().size());
        int redBeanCount = 0;
        int blueBeanCount = 0;
        int greenBeanCount = 0;
        int blackEyedBeanCount = 0;
        for (Card card : gameTable.drawPile()){
            switch (card.getCardType()){
                case REDBEAN:
                    redBeanCount++;
                    continue;
                case BLUEBEAN:
                    blueBeanCount++;
                    continue;
                case GREENBEAN:
                    greenBeanCount++;
                    continue;
                case BLACKEYEDBEAN:
                    blackEyedBeanCount++;
            }
        }
        Assert.assertEquals(7, redBeanCount);
        Assert.assertEquals(19, blueBeanCount);
        Assert.assertEquals(13, greenBeanCount);
        Assert.assertEquals(9, blackEyedBeanCount);
    }


    @Test
    public void playerList() {
        GameTable gameTable = new GameTable();
        gameTable.addPlayer("Player1", 1, 2);
        Assert.assertEquals(1, gameTable.playerList().size());
        gameTable.addPlayer("Player2", 2, 2);
        Assert.assertEquals(2, gameTable.playerList().size());
        gameTable.addPlayer("Player3", 3, 2);
        Assert.assertEquals(3, gameTable.playerList().size());
        gameTable.addPlayer("Player4", 4, 2);
        Assert.assertEquals(4, gameTable.playerList().size());
        gameTable.addPlayer("Player5", 5, 2);
        Assert.assertEquals(5, gameTable.playerList().size());
        gameTable.addPlayer("Player6", 5, 2);
        Assert.assertEquals(5, gameTable.playerList().size());
    }


}
