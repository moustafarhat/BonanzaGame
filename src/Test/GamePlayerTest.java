package Test;

import BonanzaCore.Core.HumanPlayer;
import Bonanza.Game.BonanzaGameManager;
import BonanzaCore.Core.Enums.CardTypes;
import BonanzaCore.Core.Entities.Card;
import BonanzaCore.Core.Entities.Field;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class GamePlayerTest {

    @Test
    public void addCardsToHand() {
        HumanPlayer testHumanPlayer = new HumanPlayer("TestPlayer", 1);
        BonanzaGameManager gameManager = new BonanzaGameManager();
        gameManager.startNewGame();
        //testHumanPlayer.addCardsToHand(gameManager.draw(5));
        assertEquals(5, testHumanPlayer.getHand().size());
        System.out.println("HumanPlayer's random hand: ");
        for (Card card : testHumanPlayer.getHand()){
            System.out.println(card.getCardType());
        }
    }

    @Test
    public void plant() {
        HumanPlayer testHumanPlayer = new HumanPlayer("TestPlayer", 1);
        //assertFalse(testHumanPlayer.plant(new Card(CardTypes.REDBEAN), 2));
        testHumanPlayer.setTreasury(Arrays.asList(new Card(CardTypes.REDBEAN), new Card(CardTypes.REDBEAN), new Card(CardTypes.REDBEAN)));
        //assertTrue(testHumanPlayer.buyField());
        //assertTrue(testHumanPlayer.plant(new Card(CardTypes.REDBEAN), 2));
    }

    @Test
    public void harvest() {
        HumanPlayer testHumanPlayer = new HumanPlayer("TestPlayer", 1);
        testHumanPlayer.setFields(Arrays.asList(
                new Field(Arrays.asList(new Card(CardTypes.CHILIBEAN), new Card(CardTypes.CHILIBEAN))),
                new Field(Arrays.asList(new Card(CardTypes.BLUEBEAN)))));
        //Harvesting field "2" with one BlueBean should not work due to Bean Protection Rule and return empty harvest
        assertTrue(testHumanPlayer.harvest(1).isEmpty());
        //Harvesting field "1" should work but yield no coins and just the harvested cards
        assertEquals(testHumanPlayer.harvest(0).size(), 2);
        assertEquals(0, testHumanPlayer.getCoinCount());
    }
    @Test
    public void harvest2() {
        HumanPlayer testHumanPlayer = new HumanPlayer("TestPlayer", 1);
        //With 2 RedBeans in one field player should receive 1 coin
        testHumanPlayer.setFields(Arrays.asList(
                new Field(Arrays.asList(new Card(CardTypes.REDBEAN), new Card(CardTypes.REDBEAN))),
                new Field(Arrays.asList(new Card(CardTypes.BLUEBEAN)))));
        testHumanPlayer.harvest(0);
        assertEquals(1, testHumanPlayer.getCoinCount());
        //With 3 Black Eyed Beans player should only receive 1 coin
        testHumanPlayer.setFields(Arrays.asList(
                new Field(Arrays.asList(new Card(CardTypes.BLACKEYEDBEAN), new Card(CardTypes.BLACKEYEDBEAN), new Card(CardTypes.BLACKEYEDBEAN))),
                new Field(Arrays.asList(new Card(CardTypes.BLUEBEAN)))));
        testHumanPlayer.harvest(0);
        assertEquals(2, testHumanPlayer.getCoinCount());

    }

    @Test
    public void buyField() {
        HumanPlayer testHumanPlayer = new HumanPlayer("TestPlayer", 1);
        testHumanPlayer.setTreasury(Arrays.asList(new Card(CardTypes.REDBEAN), new Card(CardTypes.REDBEAN), new Card(CardTypes.REDBEAN)));
        //assertTrue(testHumanPlayer.buyField());
        //assertFalse(testHumanPlayer.buyField());
    }

}