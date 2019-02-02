package BonanzaCore.Test;

import BonanzaGame.BonanzaGameManager;
import BonanzaCore.Core.Enums.CardTypes;
import BonanzaCore.Core.Entities.Card;
import BonanzaCore.Core.Entities.Field;
import BonanzaGame.GamePlayer;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class GamePlayerTest {

    @Test
    public void addCardsToHand() {
        GamePlayer testGamePlayer = new GamePlayer("TestPlayer", 1);
        BonanzaGameManager gameManager = new BonanzaGameManager();
        gameManager.startNewGame();
        testGamePlayer.addCardsToHand(gameManager.draw(5));
        assertEquals(5, testGamePlayer.getHand().size());
        System.out.println("GamePlayer's random hand: ");
        for (Card card : testGamePlayer.getHand()){
            System.out.println(card.getCardType());
        }
    }

    @Test
    public void plant() {
        GamePlayer testGamePlayer = new GamePlayer("TestPlayer", 1);
        assertFalse(testGamePlayer.plant(new Card(CardTypes.REDBEAN), 2));
        testGamePlayer.setTreasury(Arrays.asList(new Card(CardTypes.REDBEAN), new Card(CardTypes.REDBEAN), new Card(CardTypes.REDBEAN)));
        assertTrue(testGamePlayer.buyField());
        assertTrue(testGamePlayer.plant(new Card(CardTypes.REDBEAN), 2));
    }

    @Test
    public void harvest() {
        GamePlayer testGamePlayer = new GamePlayer("TestPlayer", 1);
        testGamePlayer.setFields(Arrays.asList(
                new Field(Arrays.asList(new Card(CardTypes.CHILIBEAN), new Card(CardTypes.CHILIBEAN))),
                new Field(Arrays.asList(new Card(CardTypes.BLUEBEAN)))));
        //Harvesting field "2" with one BlueBean should not work due to Bean Protection Rule and return empty harvest
        assertTrue(testGamePlayer.harvest(1).isEmpty());
        //Harvesting field "1" should work but yield no coins and just the harvested cards
        assertEquals(testGamePlayer.harvest(0).size(), 2);
        assertEquals(0, testGamePlayer.getCoinCount());
    }
    @Test
    public void harvest2() {
        GamePlayer testGamePlayer = new GamePlayer("TestPlayer", 1);
        //With 2 RedBeans in one field player should receive 1 coin
        testGamePlayer.setFields(Arrays.asList(
                new Field(Arrays.asList(new Card(CardTypes.REDBEAN), new Card(CardTypes.REDBEAN))),
                new Field(Arrays.asList(new Card(CardTypes.BLUEBEAN)))));
        testGamePlayer.harvest(0);
        assertEquals(1, testGamePlayer.getCoinCount());
        //With 3 Black Eyed Beans player should only receive 1 coin
        testGamePlayer.setFields(Arrays.asList(
                new Field(Arrays.asList(new Card(CardTypes.BLACKEYEDBEAN), new Card(CardTypes.BLACKEYEDBEAN), new Card(CardTypes.BLACKEYEDBEAN))),
                new Field(Arrays.asList(new Card(CardTypes.BLUEBEAN)))));
        testGamePlayer.harvest(0);
        assertEquals(2, testGamePlayer.getCoinCount());

    }

    @Test
    public void buyField() {
        GamePlayer testGamePlayer = new GamePlayer("TestPlayer", 1);
        testGamePlayer.setTreasury(Arrays.asList(new Card(CardTypes.REDBEAN), new Card(CardTypes.REDBEAN), new Card(CardTypes.REDBEAN)));
        assertTrue(testGamePlayer.buyField());
        assertFalse(testGamePlayer.buyField());
    }

}