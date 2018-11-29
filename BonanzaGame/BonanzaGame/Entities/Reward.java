package BonanzaGame.Entities;

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
