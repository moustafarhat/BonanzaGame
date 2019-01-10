package BonanzaGame.Entities;

/**
 * The class 'Reward' depicts a model of a card's rewards
 * A reward is specified by varying combinations of amount of cards needed for certain amount of coins
 * Each reward depends on the CardType of a card
 * For example to receive a coin a player needs to plant and harvest either 4 BlueBeans or only 2 RedBeans
 * @version 1
 * @author Arthur K
 */
public class Reward
{
    private int cardCount;
    private int coins;

    public Reward(int cardCount, int coins) {
        this.cardCount = cardCount;
        this.coins = coins;
    }

    public int getCardCount() {
        return cardCount;
    }

    public int getCoins() {
        return coins;
    }

}
