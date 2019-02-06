package Test.Player.Test;

import BonanzaCore.Core.Entities.Card;
import BonanzaCore.Core.Entities.Field;
import BonanzaCore.Core.Enums.CardTypes;
import BonanzaCore.Core.HumanPlayer;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * The class 'GamePlayerTest' will test the core functions of class GamePlayer
 * @version 2
 * @author Moustafa Farhat
 */
public class GamePlayerTest {

    @Test
    public void harvestTestScenario1() {
        HumanPlayer testHumanPlayer = new HumanPlayer("TestVirtualPlayer", 1);
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
    public void harvestTestScenario2() {
        HumanPlayer testHumanPlayer = new HumanPlayer("TestVirtualPlayer", 1);
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
}