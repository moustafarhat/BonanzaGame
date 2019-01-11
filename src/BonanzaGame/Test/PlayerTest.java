package BonanzaGame.Test;

import BonanzaGame.Core.Enums.CardTypes;
import BonanzaGame.Core.GameManager;
import BonanzaGame.Entities.Card;
import BonanzaGame.Entities.Field;
import BonanzaGame.Core.Player;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void addCardsToHand() {
        Player testPlayer = new Player("TestPlayer", 1);
        GameManager gameManager = new GameManager();
        //gameManager.GameInitializer();
        gameManager.startNewGame();
        testPlayer.addCardsToHand(gameManager.draw(5));
        assertEquals(5, testPlayer.getHand().size());
        System.out.println("Player's random hand: ");
        for (Card card : testPlayer.getHand()){
            System.out.println(card.getCardType());
        }
    }

    @Test
    public void plant() {
        Player testPlayer = new Player("TestPlayer", 1);
        assertFalse(testPlayer.plant(new Card(CardTypes.REDBEAN), 2));
        testPlayer.setTreasury(Arrays.asList(new Card(CardTypes.REDBEAN), new Card(CardTypes.REDBEAN), new Card(CardTypes.REDBEAN)));
        assertTrue(testPlayer.buyField());
        assertTrue(testPlayer.plant(new Card(CardTypes.REDBEAN), 2));
    }

    @Test
    public void harvest() {
        Player testPlayer = new Player("TestPlayer", 1);
        testPlayer.setFields(Arrays.asList(
                new Field(Arrays.asList(new Card(CardTypes.CHILIBEAN), new Card(CardTypes.CHILIBEAN))),
                new Field(Arrays.asList(new Card(CardTypes.BLUEBEAN)))));
        //Harvesting field "2" with one BlueBean should not work due to Bean Protection Rule and return empty harvest
        assertTrue(testPlayer.harvest(1).isEmpty());
        //Harvesting field "1" should work but yield no coins and just the harvested cards
        assertEquals(testPlayer.harvest(0).size(), 2);
        assertEquals(0, testPlayer.getCoinCount());
    }
    @Test
    public void harvest2() {
        Player testPlayer = new Player("TestPlayer", 1);
        //With 2 RedBeans in one field player should receive 1 coin
        testPlayer.setFields(Arrays.asList(
                new Field(Arrays.asList(new Card(CardTypes.REDBEAN), new Card(CardTypes.REDBEAN))),
                new Field(Arrays.asList(new Card(CardTypes.BLUEBEAN)))));
        testPlayer.harvest(0);
        assertEquals(1, testPlayer.getCoinCount());
        //With 3 Black Eyed Beans player should only receive 1 coin
        testPlayer.setFields(Arrays.asList(
                new Field(Arrays.asList(new Card(CardTypes.BLACKEYEDBEAN), new Card(CardTypes.BLACKEYEDBEAN), new Card(CardTypes.BLACKEYEDBEAN))),
                new Field(Arrays.asList(new Card(CardTypes.BLUEBEAN)))));
        testPlayer.harvest(0);
        assertEquals(2, testPlayer.getCoinCount());

    }

    @Test
    public void buyField() {
        Player testPlayer = new Player("TestPlayer", 1);
        testPlayer.setTreasury(Arrays.asList(new Card(CardTypes.REDBEAN), new Card(CardTypes.REDBEAN), new Card(CardTypes.REDBEAN)));
        assertTrue(testPlayer.buyField());
        assertFalse(testPlayer.buyField());
    }

}